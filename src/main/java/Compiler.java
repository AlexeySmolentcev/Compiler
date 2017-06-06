import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

public class Compiler {
    public static void main(String[] args) throws java.io.IOException {
        // Создаю поток входных данных, который читает текст указанного файла
        ANTLRFileStream inp = new ANTLRFileStream("C:\\Users\\Алексей\\IdeaProjects\\Compiler2\\src\\main\\java\\PrimeNumberPascal");

        // Создаю лексический анализатор (лексер) на основе входного потока
        PascalLexer lexer = new PascalLexer(inp);

        // Создаю хранилище токенов, которые выделяет лексер
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        // Создаю синтаксический анализатор (парсер) на основе хранилища выделенных токенов
        PascalParser parser = new PascalParser(tokens);

        // Начинаю процесс парсинга, начиная с первой аксиомы
        ParseTree tree = parser.module();

        // Создаю кодогенератор и передаю ему дерево, с которым он должен будет работать
        CodeGenerator generator = new CodeGenerator(tree);

        // Забираю у кодогенератора сгенерированный им класс
        Class<?> primeNumber = generator.loadClass(generator.toByteCode("PrimeNumber", 30000));

        // Запускаю забранный класс. Точнее, его метод run().
        try {
            double begin = System.currentTimeMillis();
            ((Runnable) primeNumber.newInstance()).run();
            double end = System.currentTimeMillis();
            System.out.println("Откомпилированная программа выполнялась " + (end - begin) / 1000 + " секунд." );
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}