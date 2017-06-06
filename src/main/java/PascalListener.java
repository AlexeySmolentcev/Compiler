// Generated from Pascal by ANTLR 4.7
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link PascalParser}.
 */
public interface PascalListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link PascalParser#module}.
	 * @param ctx the parse tree
	 */
	void enterModule(PascalParser.ModuleContext ctx);
	/**
	 * Exit a parse tree produced by {@link PascalParser#module}.
	 * @param ctx the parse tree
	 */
	void exitModule(PascalParser.ModuleContext ctx);
	/**
	 * Enter a parse tree produced by {@link PascalParser#constants}.
	 * @param ctx the parse tree
	 */
	void enterConstants(PascalParser.ConstantsContext ctx);
	/**
	 * Exit a parse tree produced by {@link PascalParser#constants}.
	 * @param ctx the parse tree
	 */
	void exitConstants(PascalParser.ConstantsContext ctx);
	/**
	 * Enter a parse tree produced by {@link PascalParser#var}.
	 * @param ctx the parse tree
	 */
	void enterVar(PascalParser.VarContext ctx);
	/**
	 * Exit a parse tree produced by {@link PascalParser#var}.
	 * @param ctx the parse tree
	 */
	void exitVar(PascalParser.VarContext ctx);
	/**
	 * Enter a parse tree produced by {@link PascalParser#variable}.
	 * @param ctx the parse tree
	 */
	void enterVariable(PascalParser.VariableContext ctx);
	/**
	 * Exit a parse tree produced by {@link PascalParser#variable}.
	 * @param ctx the parse tree
	 */
	void exitVariable(PascalParser.VariableContext ctx);
	/**
	 * Enter a parse tree produced by {@link PascalParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(PascalParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link PascalParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(PascalParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link PascalParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(PascalParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link PascalParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(PascalParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link PascalParser#if_statement}.
	 * @param ctx the parse tree
	 */
	void enterIf_statement(PascalParser.If_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link PascalParser#if_statement}.
	 * @param ctx the parse tree
	 */
	void exitIf_statement(PascalParser.If_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link PascalParser#if_else_statement}.
	 * @param ctx the parse tree
	 */
	void enterIf_else_statement(PascalParser.If_else_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link PascalParser#if_else_statement}.
	 * @param ctx the parse tree
	 */
	void exitIf_else_statement(PascalParser.If_else_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link PascalParser#while_statement}.
	 * @param ctx the parse tree
	 */
	void enterWhile_statement(PascalParser.While_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link PascalParser#while_statement}.
	 * @param ctx the parse tree
	 */
	void exitWhile_statement(PascalParser.While_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link PascalParser#for_statement}.
	 * @param ctx the parse tree
	 */
	void enterFor_statement(PascalParser.For_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link PascalParser#for_statement}.
	 * @param ctx the parse tree
	 */
	void exitFor_statement(PascalParser.For_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link PascalParser#appropriation_statement}.
	 * @param ctx the parse tree
	 */
	void enterAppropriation_statement(PascalParser.Appropriation_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link PascalParser#appropriation_statement}.
	 * @param ctx the parse tree
	 */
	void exitAppropriation_statement(PascalParser.Appropriation_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link PascalParser#write_statement}.
	 * @param ctx the parse tree
	 */
	void enterWrite_statement(PascalParser.Write_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link PascalParser#write_statement}.
	 * @param ctx the parse tree
	 */
	void exitWrite_statement(PascalParser.Write_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link PascalParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(PascalParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link PascalParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(PascalParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link PascalParser#sum}.
	 * @param ctx the parse tree
	 */
	void enterSum(PascalParser.SumContext ctx);
	/**
	 * Exit a parse tree produced by {@link PascalParser#sum}.
	 * @param ctx the parse tree
	 */
	void exitSum(PascalParser.SumContext ctx);
	/**
	 * Enter a parse tree produced by {@link PascalParser#take}.
	 * @param ctx the parse tree
	 */
	void enterTake(PascalParser.TakeContext ctx);
	/**
	 * Exit a parse tree produced by {@link PascalParser#take}.
	 * @param ctx the parse tree
	 */
	void exitTake(PascalParser.TakeContext ctx);
	/**
	 * Enter a parse tree produced by {@link PascalParser#condition}.
	 * @param ctx the parse tree
	 */
	void enterCondition(PascalParser.ConditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link PascalParser#condition}.
	 * @param ctx the parse tree
	 */
	void exitCondition(PascalParser.ConditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link PascalParser#mod}.
	 * @param ctx the parse tree
	 */
	void enterMod(PascalParser.ModContext ctx);
	/**
	 * Exit a parse tree produced by {@link PascalParser#mod}.
	 * @param ctx the parse tree
	 */
	void exitMod(PascalParser.ModContext ctx);
}