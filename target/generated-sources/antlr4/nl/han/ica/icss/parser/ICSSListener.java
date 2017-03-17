// Generated from nl/han/ica/icss/parser/ICSS.g4 by ANTLR 4.3
package nl.han.ica.icss.parser;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ICSSParser}.
 */
public interface ICSSListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ICSSParser#stylesheet}.
	 * @param ctx the parse tree
	 */
	void enterStylesheet(@NotNull ICSSParser.StylesheetContext ctx);
	/**
	 * Exit a parse tree produced by {@link ICSSParser#stylesheet}.
	 * @param ctx the parse tree
	 */
	void exitStylesheet(@NotNull ICSSParser.StylesheetContext ctx);

	/**
	 * Enter a parse tree produced by {@link ICSSParser#varValue}.
	 * @param ctx the parse tree
	 */
	void enterVarValue(@NotNull ICSSParser.VarValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link ICSSParser#varValue}.
	 * @param ctx the parse tree
	 */
	void exitVarValue(@NotNull ICSSParser.VarValueContext ctx);

	/**
	 * Enter a parse tree produced by {@link ICSSParser#var}.
	 * @param ctx the parse tree
	 */
	void enterVar(@NotNull ICSSParser.VarContext ctx);
	/**
	 * Exit a parse tree produced by {@link ICSSParser#var}.
	 * @param ctx the parse tree
	 */
	void exitVar(@NotNull ICSSParser.VarContext ctx);

	/**
	 * Enter a parse tree produced by {@link ICSSParser#attributes}.
	 * @param ctx the parse tree
	 */
	void enterAttributes(@NotNull ICSSParser.AttributesContext ctx);
	/**
	 * Exit a parse tree produced by {@link ICSSParser#attributes}.
	 * @param ctx the parse tree
	 */
	void exitAttributes(@NotNull ICSSParser.AttributesContext ctx);

	/**
	 * Enter a parse tree produced by {@link ICSSParser#attribute}.
	 * @param ctx the parse tree
	 */
	void enterAttribute(@NotNull ICSSParser.AttributeContext ctx);
	/**
	 * Exit a parse tree produced by {@link ICSSParser#attribute}.
	 * @param ctx the parse tree
	 */
	void exitAttribute(@NotNull ICSSParser.AttributeContext ctx);

	/**
	 * Enter a parse tree produced by {@link ICSSParser#stylRule}.
	 * @param ctx the parse tree
	 */
	void enterStylRule(@NotNull ICSSParser.StylRuleContext ctx);
	/**
	 * Exit a parse tree produced by {@link ICSSParser#stylRule}.
	 * @param ctx the parse tree
	 */
	void exitStylRule(@NotNull ICSSParser.StylRuleContext ctx);

	/**
	 * Enter a parse tree produced by {@link ICSSParser#value}.
	 * @param ctx the parse tree
	 */
	void enterValue(@NotNull ICSSParser.ValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link ICSSParser#value}.
	 * @param ctx the parse tree
	 */
	void exitValue(@NotNull ICSSParser.ValueContext ctx);
}