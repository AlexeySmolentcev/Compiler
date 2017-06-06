import jdk.internal.org.objectweb.asm.ClassWriter;
import jdk.internal.org.objectweb.asm.tree.*;
import org.antlr.v4.runtime.tree.ParseTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static jdk.internal.org.objectweb.asm.Opcodes.*;


// Класс, в котором будет происходить генерация кода


public class CodeGenerator extends ClassLoader {
    private ParseTree tree; // Тут хранится дерево, на основе которого происходит кодогенерация

    private InsnList insnList2;

    private int count = 0; // Количесто занятых ячеек стека

    private HashMap<String, Integer> variables = new HashMap<>(); // Тут будут лежать названия перевенных и номер ячейки, в которой они лежат


    // Конструктор. Принимает дерево, на основе которого будет происходить кодогенерация
    public CodeGenerator(ParseTree tree) {
        this.tree = tree;
    }


    public Class<?> loadClass(byte[] byteCode) {
        return defineClass(null, byteCode, 0, byteCode.length);
    }


    // Непоследственно кодогенерация
    public byte[] toByteCode(String className, int memorySize) {
        ClassNode classNode = new ClassNode(); // Класс для генерации класса
        classNode.version = V1_8; // Версия библеотеки ASM
        classNode.access = ACC_PUBLIC + ACC_SUPER; // Класс публичный
        classNode.name = className; // Название класса
        classNode.superName = "java/lang/Object"; // Название родительского класса
        classNode.interfaces.add("java/lang/Runnable"); // Реализуемый интерфейс

        // Создаем метод public void <init>()
        MethodNode methodNode = new MethodNode(ACC_PUBLIC, "<init>", "()V", null, null);

        // Список инструкций метода
        InsnList insnList = methodNode.instructions;

        // Вызывем родительский конструктор
        insnList.add(new VarInsnNode(ALOAD, 0));
        insnList.add(new MethodInsnNode(INVOKESPECIAL, classNode.superName, "<init>", "()V", false));

        // Выход
        insnList.add(new InsnNode(RETURN));

        // Добавляем метод к классу
        classNode.methods.add(methodNode);


        // Создаем метод public void run()
        MethodNode methodNode2 = new MethodNode(ACC_PUBLIC, "run", "()V", null, null);

        // Список инструкий метода
        insnList2 = methodNode2.instructions;

        //объявляем массив размером memorySize
        insnList2.add(new LdcInsnNode(memorySize)); //заносим в стэк константу типа integer
        insnList2.add(new IntInsnNode(NEWARRAY, T_CHAR)); //создаем массив
        count += 1;
        insnList2.add(new VarInsnNode(ASTORE, count)); //кладем его в локальную переменную 1

        //объявляем позицию
        insnList2.add(new LdcInsnNode(memorySize / 2));
        count += 1;
        insnList2.add(new VarInsnNode(ISTORE, count)); //кладем его в локальную переменную 2


        for (ParseTree subTree : getLeafs(tree)) {
            generateByteCode(subTree);
        }

        // Выход
        insnList2.add(new InsnNode(RETURN));

        // Добавляем метод к классу
        classNode.methods.add(methodNode2);


        // С помощью этого класса получаем байткод
        ClassWriter classWriter = new ClassWriter(ClassWriter.COMPUTE_FRAMES);

        // Связываем ClassNode с ClassWriter
        classNode.accept(classWriter);

        // Получаем байткод
        return classWriter.toByteArray();
    }


    // Вспомогательный метод. Возвращает список листьев переданного дерева
    private List<ParseTree> getLeafs(ParseTree tree) {
        ArrayList<ParseTree> leafs = new ArrayList<>();
        int count = tree.getChildCount();
        for (int i = 0; i < count; i++) {
            leafs.add(tree.getChild(i));
        }
        return leafs;
    }


    // Метод, генерирующий байткод
    private void generateByteCode(ParseTree subTree) {
        String textRepresentation = subTree.getText();

        // Розбираем блок констант (constants)
        if (textRepresentation.startsWith("CONST")) {
            String name = subTree.getChild(2).getText();
            int value = Integer.parseInt(subTree.getChild(4).getText());
            insnList2.add(new LdcInsnNode(value));
            count += 1;
            variables.put(name, count);
            insnList2.add(new VarInsnNode(ISTORE, count));
            return;
        }

        // Разбираем блок переменных (var)
        if (textRepresentation.startsWith("VAR") && !textRepresentation.contains(" VAR ")) {
            for (int i = 2; i < subTree.getChildCount(); i++) {
                generateByteCode(subTree.getChild(i));
            }
            return;
        }

        // Продолжаем разбирать переменные (variable)
        if (textRepresentation.contains(": ")) {
            String name = subTree.getChild(0).getText();
            if (subTree.getChild(2).getText().contains("ARRAY")) {
                String to = subTree.getChild(2).getChild(1).getText();
                insnList2.add(new VarInsnNode(ILOAD, variables.get(to)));
                insnList2.add(new IntInsnNode(NEWARRAY, T_INT));
                count += 1;
                variables.put(name, count);
                insnList2.add(new VarInsnNode(ASTORE, count));
            } else {
                count += 1;
                variables.put(name, count);
            }
        }

        // Разбираем условный оператор без else (if_statement)
        if (textRepresentation.startsWith("IF") && !textRepresentation.contains("ELSE")) {
            ParseTree ifStatement = subTree.getChild(0);
            generateByteCode(ifStatement.getChild(1));
            LabelNode end = new LabelNode();
            if (ifStatement.getChild(1).getText().contains(" <> ")) {
                insnList2.add(new JumpInsnNode(IF_ICMPEQ, end));
            } else {
                insnList2.add(new JumpInsnNode(IF_ICMPNE, end));
            }
            for (int i = 6; i < ifStatement.getChildCount() - 2; i++) {
                generateByteCode(ifStatement.getChild(i));
            }
            insnList2.add(end);
            return;
        }

        // Разбираем условный оператор с else (if_else_statement)
        if (textRepresentation.startsWith("IF") && textRepresentation.contains("ELSE")) {
            ParseTree ifElseStatement = subTree.getChild(0);
            generateByteCode(ifElseStatement.getChild(1));
            LabelNode elseLabel = new LabelNode();
            if (ifElseStatement.getChild(1).getText().contains(" <> ")) {
                insnList2.add(new JumpInsnNode(IF_ICMPEQ, elseLabel));
            } else {
                insnList2.add(new JumpInsnNode(IF_ICMPNE, elseLabel));
            }
            int cnt = 6;
            for (int i = cnt; i < ifElseStatement.getChildCount() - 2; i++) {
                if (ifElseStatement.getChild(i).getText().contains("END")) {
                    break;
                }
                generateByteCode(ifElseStatement.getChild(i));
                cnt += 1;
            }
            LabelNode end = new LabelNode();
            insnList2.add(new JumpInsnNode(GOTO, end));
            insnList2.add(elseLabel);
            for (int i = cnt + 6; i < ifElseStatement.getChildCount() - 2; i++) {
                generateByteCode(ifElseStatement.getChild(i));
            }
            insnList2.add(end);
            return;
        }

        // Разбираем цикл while (while_statement)     // пока что-то не работает
        if (textRepresentation.startsWith("WHILE")) {
            ParseTree whileStatement = subTree.getChild(0);
            LabelNode begin = new LabelNode();
            LabelNode end = new LabelNode();
            insnList2.add(begin);
            generateByteCode(whileStatement.getChild(1));
            if (whileStatement.getChild(1).getText().contains(" <> ")) {
                insnList2.add(new JumpInsnNode(IF_ICMPEQ, end));
            } else {
                insnList2.add(new JumpInsnNode(IF_ICMPNE, end));
            }
            for (int i = 6; i < whileStatement.getChildCount() - 2; i++) {
                generateByteCode(whileStatement.getChild(i));
            }
            insnList2.add(new JumpInsnNode(GOTO, begin));
            insnList2.add(end);
            return;
        }

        // Разбираем цикл for (for_statement)
        if (textRepresentation.startsWith("FOR VAR ")) {
            ParseTree forStatement = subTree.getChild(0);
            ParseTree appropriation = forStatement.getChild(1);
            Integer num1 = Integer.parseInt(appropriation.getChild(2).getText());
            switch (num1) {
                case 0:
                    insnList2.add(new InsnNode(ICONST_0));
                    break;
                case 1:
                    insnList2.add(new InsnNode(ICONST_1));
                    break;
                case 2:
                    insnList2.add(new InsnNode(ICONST_2));
                    break;
                case 3:
                    insnList2.add(new InsnNode(ICONST_3));
                    break;
                case 4:
                    insnList2.add(new InsnNode(ICONST_4));
                    break;
                case 5:
                    insnList2.add(new InsnNode(ICONST_5));
                    break;
                default:
                    insnList2.add(new VarInsnNode(BIPUSH, num1));
            }
            count += 1;
            String name = appropriation.getChild(0).getText();
            variables.put(name, count);
            insnList2.add(new VarInsnNode(ISTORE, count));
            LabelNode begin = new LabelNode();
            LabelNode end = new LabelNode();
            insnList2.add(begin);
            insnList2.add(new VarInsnNode(ILOAD, variables.get(name)));
            ParseTree to = forStatement.getChild(3).getChild(0);
            insnList2.add(new VarInsnNode(ILOAD, variables.get(to.getChild(0).getText())));
            Integer num2 = Integer.parseInt(to.getChild(2).getText());
            switch (num2) {
                case 0:
                    insnList2.add(new InsnNode(ICONST_0));
                    break;
                case 1:
                    insnList2.add(new InsnNode(ICONST_1));
                    break;
                case 2:
                    insnList2.add(new InsnNode(ICONST_2));
                    break;
                case 3:
                    insnList2.add(new InsnNode(ICONST_3));
                    break;
                case 4:
                    insnList2.add(new InsnNode(ICONST_4));
                    break;
                case 5:
                    insnList2.add(new InsnNode(ICONST_5));
                    break;
                default:
                    insnList2.add(new VarInsnNode(BIPUSH, num2));
            }
            insnList2.add(new InsnNode(ISUB));
            insnList2.add(new JumpInsnNode(IF_ICMPGT, end));
            for (int j = 8; j < forStatement.getChildCount() - 2; j++) {
                generateByteCode(forStatement.getChild(j));
            }
            insnList2.add(new IincInsnNode(variables.get(name), 1));
            insnList2.add(new JumpInsnNode(GOTO, begin));
            insnList2.add(end);
            return;
        }

        // Разбираем условие (condition)
        if (textRepresentation.contains(" <> ") || textRepresentation.contains(" = ")) {
            if (textRepresentation.contains(" <> ")) {
                String name1 = subTree.getChild(0).getText();
                String name2 = subTree.getChild(2).getText();
                insnList2.add(new VarInsnNode(ILOAD, variables.get(name1)));
                insnList2.add(new VarInsnNode(ILOAD, variables.get(name2)));
            } else {
                if (textRepresentation.contains(" MOD ")) {
                    ParseTree mod = subTree.getChild(0);
                    insnList2.add(new VarInsnNode(ILOAD, variables.get(mod.getChild(0).getText())));
                    ParseTree take = mod.getChild(2);
                    insnList2.add(new VarInsnNode(ALOAD, variables.get(take.getChild(0).getText())));
                    if (Character.isDigit(take.getChild(2).getText().charAt(0))) {
                        Integer num = Integer.parseInt(take.getChild(2).getText());
                        switch (num) {
                            case 0:
                                insnList2.add(new InsnNode(ICONST_0));
                                break;
                            case 1:
                                insnList2.add(new InsnNode(ICONST_1));
                                break;
                            case 2:
                                insnList2.add(new InsnNode(ICONST_2));
                                break;
                            case 3:
                                insnList2.add(new InsnNode(ICONST_3));
                                break;
                            case 4:
                                insnList2.add(new InsnNode(ICONST_4));
                                break;
                            case 5:
                                insnList2.add(new InsnNode(ICONST_5));
                                break;
                            default:
                                insnList2.add(new VarInsnNode(BIPUSH, num));
                        }
                    } else {
                        insnList2.add(new VarInsnNode(ILOAD, variables.get(take.getChild(2).getText())));
                    }

                    insnList2.add(new InsnNode(IALOAD));
                    insnList2.add(new InsnNode(IREM));

                    Integer num2 = Integer.parseInt(subTree.getChild(2).getText());
                    switch (num2) {
                        case 0:
                            insnList2.add(new InsnNode(ICONST_0));
                            break;
                        case 1:
                            insnList2.add(new InsnNode(ICONST_1));
                            break;
                        case 2:
                            insnList2.add(new InsnNode(ICONST_2));
                            break;
                        case 3:
                            insnList2.add(new InsnNode(ICONST_3));
                            break;
                        case 4:
                            insnList2.add(new InsnNode(ICONST_4));
                            break;
                        case 5:
                            insnList2.add(new InsnNode(ICONST_5));
                            break;
                        default:
                            insnList2.add(new VarInsnNode(BIPUSH, num2));
                    }
                } else {
                    insnList2.add(new VarInsnNode(ILOAD, variables.get(subTree.getChild(0).getText())));
                    Integer num = Integer.parseInt(subTree.getChild(2).getText());
                    switch (num) {
                        case 0:
                            insnList2.add(new InsnNode(ICONST_0));
                            break;
                        case 1:
                            insnList2.add(new InsnNode(ICONST_1));
                            break;
                        case 2:
                            insnList2.add(new InsnNode(ICONST_2));
                            break;
                        case 3:
                            insnList2.add(new InsnNode(ICONST_3));
                            break;
                        case 4:
                            insnList2.add(new InsnNode(ICONST_4));
                            break;
                        case 5:
                            insnList2.add(new InsnNode(ICONST_5));
                            break;
                        default:
                            insnList2.add(new VarInsnNode(BIPUSH, num));
                    }
                }
            }
        }

        // Разбираем присваивание (appropriation_statement)
        if (textRepresentation.contains(" := ")) {
            ParseTree appropriation = subTree.getChild(0);
            String name = appropriation.getChild(0).getText();
            if (!(name.contains("[") && name.contains("]"))) {
                if (appropriation.getText().contains("+") || appropriation.getText().contains("-")) {
                    ParseTree sum = appropriation.getChild(2).getChild(0);
                    insnList2.add(new VarInsnNode(ILOAD, variables.get(sum.getChild(0).getText())));
                    Integer num = Integer.parseInt(sum.getChild(2).getText());
                    switch (num) {
                        case 0:
                            insnList2.add(new InsnNode(ICONST_0));
                            break;
                        case 1:
                            insnList2.add(new InsnNode(ICONST_1));
                            break;
                        case 2:
                            insnList2.add(new InsnNode(ICONST_2));
                            break;
                        case 3:
                            insnList2.add(new InsnNode(ICONST_3));
                            break;
                        case 4:
                            insnList2.add(new InsnNode(ICONST_4));
                            break;
                        case 5:
                            insnList2.add(new InsnNode(ICONST_5));
                            break;
                        default:
                            insnList2.add(new VarInsnNode(BIPUSH, num));
                    }
                    if (appropriation.getText().contains("+")) {
                        insnList2.add(new InsnNode(IADD));
                    } else {
                        insnList2.add(new InsnNode(ISUB));
                    }
                } else {
                    if (Character.isLetter(appropriation.getChild(2).getText().charAt(0))) {
                        insnList2.add(new VarInsnNode(ILOAD, variables.get(appropriation.getChild(2).getText())));
                    } else {
                        Integer num = Integer.parseInt(appropriation.getChild(2).getText());
                        switch (num) {
                            case 0:
                                insnList2.add(new InsnNode(ICONST_0));
                                break;
                            case 1:
                                insnList2.add(new InsnNode(ICONST_1));
                                break;
                            case 2:
                                insnList2.add(new InsnNode(ICONST_2));
                                break;
                            case 3:
                                insnList2.add(new InsnNode(ICONST_3));
                                break;
                            case 4:
                                insnList2.add(new InsnNode(ICONST_4));
                                break;
                            case 5:
                                insnList2.add(new InsnNode(ICONST_5));
                                break;
                            default:
                                insnList2.add(new VarInsnNode(BIPUSH, num));
                        }
                    }
                }
                insnList2.add(new VarInsnNode(ISTORE, variables.get(name)));
            } else {
                ParseTree take = appropriation.getChild(0);
                insnList2.add(new VarInsnNode(ALOAD, variables.get(take.getChild(0).getText())));

                if (Character.isLetter(take.getChild(2).getText().charAt(0))) {
                    insnList2.add(new VarInsnNode(ILOAD, variables.get(take.getChild(2).getText())));
                } else {
                    Integer num = Integer.parseInt(take.getChild(2).getText());
                    switch (num) {
                        case 0:
                            insnList2.add(new InsnNode(ICONST_0));
                            break;
                        case 1:
                            insnList2.add(new InsnNode(ICONST_1));
                            break;
                        case 2:
                            insnList2.add(new InsnNode(ICONST_2));
                            break;
                        case 3:
                            insnList2.add(new InsnNode(ICONST_3));
                            break;
                        case 4:
                            insnList2.add(new InsnNode(ICONST_4));
                            break;
                        case 5:
                            insnList2.add(new InsnNode(ICONST_5));
                            break;
                        default:
                            insnList2.add(new VarInsnNode(BIPUSH, num));
                    }
                }

                if (Character.isLetter(appropriation.getChild(2).getText().charAt(0))) {
                    insnList2.add(new VarInsnNode(ILOAD, variables.get(appropriation.getChild(2).getText())));
                } else {
                    Integer num = Integer.parseInt(appropriation.getChild(2).getText());
                    switch (num) {
                        case 0:
                            insnList2.add(new InsnNode(ICONST_0));
                            break;
                        case 1:
                            insnList2.add(new InsnNode(ICONST_1));
                            break;
                        case 2:
                            insnList2.add(new InsnNode(ICONST_2));
                            break;
                        case 3:
                            insnList2.add(new InsnNode(ICONST_3));
                            break;
                        case 4:
                            insnList2.add(new InsnNode(ICONST_4));
                            break;
                        case 5:
                            insnList2.add(new InsnNode(ICONST_5));
                            break;
                        default:
                            insnList2.add(new VarInsnNode(BIPUSH, num));
                    }
                }

                insnList2.add(new InsnNode(IASTORE));
            }
        }

        // Разбираем вывод (write_statement)
        if (textRepresentation.startsWith("WRITELN")) {
            String name = subTree.getChild(0).getChild(1).getChild(0).getText();
            insnList2.add(new FieldInsnNode(GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;"));
            if (Character.isLetter(name.charAt(0))) {
                if (name.contains("+") || name.contains("-")) {
                    ParseTree sum = subTree.getChild(0).getChild(1).getChild(0);
                    insnList2.add(new VarInsnNode(ILOAD, variables.get(sum.getChild(0).getText())));
                    Integer num = Integer.parseInt(sum.getChild(2).getText());
                    switch (num) {
                        case 0:
                            insnList2.add(new InsnNode(ICONST_0));
                            break;
                        case 1:
                            insnList2.add(new InsnNode(ICONST_1));
                            break;
                        case 2:
                            insnList2.add(new InsnNode(ICONST_2));
                            break;
                        case 3:
                            insnList2.add(new InsnNode(ICONST_3));
                            break;
                        case 4:
                            insnList2.add(new InsnNode(ICONST_4));
                            break;
                        case 5:
                            insnList2.add(new InsnNode(ICONST_5));
                            break;
                        default:
                            insnList2.add(new VarInsnNode(BIPUSH, num));
                    }
                    if (name.contains("+")) {
                        insnList2.add(new InsnNode(IADD));
                    } else {
                        insnList2.add(new InsnNode(ISUB));
                    }
                } else {
                    insnList2.add(new VarInsnNode(ILOAD, variables.get(name)));
                }
            } else {
                Integer num = Integer.parseInt(name);
                switch (num) {
                    case 0:
                        insnList2.add(new InsnNode(ICONST_0));
                        break;
                    case 1:
                        insnList2.add(new InsnNode(ICONST_1));
                        break;
                    case 2:
                        insnList2.add(new InsnNode(ICONST_2));
                        break;
                    case 3:
                        insnList2.add(new InsnNode(ICONST_3));
                        break;
                    case 4:
                        insnList2.add(new InsnNode(ICONST_4));
                        break;
                    case 5:
                        insnList2.add(new InsnNode(ICONST_5));
                        break;
                    default:
                        insnList2.add(new VarInsnNode(BIPUSH, num));
                }
            }
            insnList2.add(new MethodInsnNode(INVOKEVIRTUAL, "java/io/PrintStream", "println", "(I)V", false));
        }
    }
}
