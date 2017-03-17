// Generated from ICSS.g4 by ANTLR 4.6
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ICSSParser}.
 */
public interface ICSSListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ICSSParser#rules}.
	 * @param ctx the parse tree
	 */
	void enterRules(ICSSParser.RulesContext ctx);
	/**
	 * Exit a parse tree produced by {@link ICSSParser#rules}.
	 * @param ctx the parse tree
	 */
	void exitRules(ICSSParser.RulesContext ctx);
	/**
	 * Enter a parse tree produced by {@link ICSSParser#rule}.
	 * @param ctx the parse tree
	 */
	void enterRule(ICSSParser.RuleContext ctx);
	/**
	 * Exit a parse tree produced by {@link ICSSParser#rule}.
	 * @param ctx the parse tree
	 */
	void exitRule(ICSSParser.RuleContext ctx);
	/**
	 * Enter a parse tree produced by {@link ICSSParser#attributes}.
	 * @param ctx the parse tree
	 */
	void enterAttributes(ICSSParser.AttributesContext ctx);
	/**
	 * Exit a parse tree produced by {@link ICSSParser#attributes}.
	 * @param ctx the parse tree
	 */
	void exitAttributes(ICSSParser.AttributesContext ctx);
	/**
	 * Enter a parse tree produced by {@link ICSSParser#attribute}.
	 * @param ctx the parse tree
	 */
	void enterAttribute(ICSSParser.AttributeContext ctx);
	/**
	 * Exit a parse tree produced by {@link ICSSParser#attribute}.
	 * @param ctx the parse tree
	 */
	void exitAttribute(ICSSParser.AttributeContext ctx);
	/**
	 * Enter a parse tree produced by {@link ICSSParser#value}.
	 * @param ctx the parse tree
	 */
	void enterValue(ICSSParser.ValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link ICSSParser#value}.
	 * @param ctx the parse tree
	 */
	void exitValue(ICSSParser.ValueContext ctx);
}