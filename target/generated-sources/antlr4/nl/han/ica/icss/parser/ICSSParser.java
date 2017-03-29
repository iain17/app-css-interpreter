// Generated from nl/han/ica/icss/parser/ICSS.g4 by ANTLR 4.3
package nl.han.ica.icss.parser;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ICSSParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		Operator=1, LiteralValue=2, ID=3, INT=4, ColorLiteral=5, HexaDecimal=6, 
		PixelLiteral=7, PercentageLiteral=8, START_BLOCK=9, END_BLOCK=10, EQUALS=11, 
		DOLLAR=12, HASH=13, DOT=14, SEMICOLON=15, COLON=16, PLUS=17, MINUS=18, 
		WS=19;
	public static final String[] tokenNames = {
		"<INVALID>", "Operator", "LiteralValue", "ID", "INT", "ColorLiteral", 
		"HexaDecimal", "'px'", "'%'", "'{'", "'}'", "'='", "'$'", "'#'", "'.'", 
		"';'", "':'", "'+'", "'-'", "WS"
	};
	public static final int
		RULE_stylesheet = 0, RULE_styleRules = 1, RULE_styleRule = 2, RULE_selector = 3, 
		RULE_selectorTag = 4, RULE_selectorId = 5, RULE_selectorClass = 6, RULE_declarations = 7, 
		RULE_declaration = 8, RULE_declarationValue = 9, RULE_operation = 10, 
		RULE_constants = 11, RULE_constant = 12, RULE_constantName = 13, RULE_constantValue = 14;
	public static final String[] ruleNames = {
		"stylesheet", "styleRules", "styleRule", "selector", "selectorTag", "selectorId", 
		"selectorClass", "declarations", "declaration", "declarationValue", "operation", 
		"constants", "constant", "constantName", "constantValue"
	};

	@Override
	public String getGrammarFileName() { return "ICSS.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public ICSSParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class StylesheetContext extends ParserRuleContext {
		public StyleRulesContext styleRules(int i) {
			return getRuleContext(StyleRulesContext.class,i);
		}
		public ConstantsContext constants(int i) {
			return getRuleContext(ConstantsContext.class,i);
		}
		public List<StyleRulesContext> styleRules() {
			return getRuleContexts(StyleRulesContext.class);
		}
		public List<ConstantsContext> constants() {
			return getRuleContexts(ConstantsContext.class);
		}
		public StylesheetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stylesheet; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ICSSListener ) ((ICSSListener)listener).enterStylesheet(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ICSSListener ) ((ICSSListener)listener).exitStylesheet(this);
		}
	}

	public final StylesheetContext stylesheet() throws RecognitionException {
		StylesheetContext _localctx = new StylesheetContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_stylesheet);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(34);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ID) | (1L << DOLLAR) | (1L << HASH) | (1L << DOT))) != 0)) {
				{
				setState(32);
				switch (_input.LA(1)) {
				case DOLLAR:
					{
					setState(30); constants();
					}
					break;
				case ID:
				case HASH:
				case DOT:
					{
					setState(31); styleRules();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(36);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StyleRulesContext extends ParserRuleContext {
		public List<StyleRuleContext> styleRule() {
			return getRuleContexts(StyleRuleContext.class);
		}
		public StyleRuleContext styleRule(int i) {
			return getRuleContext(StyleRuleContext.class,i);
		}
		public StyleRulesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_styleRules; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ICSSListener ) ((ICSSListener)listener).enterStyleRules(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ICSSListener ) ((ICSSListener)listener).exitStyleRules(this);
		}
	}

	public final StyleRulesContext styleRules() throws RecognitionException {
		StyleRulesContext _localctx = new StyleRulesContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_styleRules);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(38); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(37); styleRule();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(40); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StyleRuleContext extends ParserRuleContext {
		public SelectorContext selector() {
			return getRuleContext(SelectorContext.class,0);
		}
		public DeclarationsContext declarations() {
			return getRuleContext(DeclarationsContext.class,0);
		}
		public StyleRulesContext styleRules() {
			return getRuleContext(StyleRulesContext.class,0);
		}
		public TerminalNode END_BLOCK() { return getToken(ICSSParser.END_BLOCK, 0); }
		public TerminalNode START_BLOCK() { return getToken(ICSSParser.START_BLOCK, 0); }
		public StyleRuleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_styleRule; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ICSSListener ) ((ICSSListener)listener).enterStyleRule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ICSSListener ) ((ICSSListener)listener).exitStyleRule(this);
		}
	}

	public final StyleRuleContext styleRule() throws RecognitionException {
		StyleRuleContext _localctx = new StyleRuleContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_styleRule);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(42); selector();
			setState(43); match(START_BLOCK);
			setState(56);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				{
				setState(45);
				switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
				case 1:
					{
					setState(44); declarations();
					}
					break;
				}
				setState(48);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ID) | (1L << HASH) | (1L << DOT))) != 0)) {
					{
					setState(47); styleRules();
					}
				}

				}
				break;

			case 2:
				{
				setState(51);
				switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
				case 1:
					{
					setState(50); styleRules();
					}
					break;
				}
				setState(54);
				_la = _input.LA(1);
				if (_la==ID) {
					{
					setState(53); declarations();
					}
				}

				}
				break;
			}
			setState(58); match(END_BLOCK);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SelectorContext extends ParserRuleContext {
		public SelectorTagContext selectorTag() {
			return getRuleContext(SelectorTagContext.class,0);
		}
		public SelectorIdContext selectorId() {
			return getRuleContext(SelectorIdContext.class,0);
		}
		public SelectorClassContext selectorClass() {
			return getRuleContext(SelectorClassContext.class,0);
		}
		public SelectorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_selector; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ICSSListener ) ((ICSSListener)listener).enterSelector(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ICSSListener ) ((ICSSListener)listener).exitSelector(this);
		}
	}

	public final SelectorContext selector() throws RecognitionException {
		SelectorContext _localctx = new SelectorContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_selector);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(63);
			switch (_input.LA(1)) {
			case ID:
				{
				setState(60); selectorTag();
				}
				break;
			case HASH:
				{
				setState(61); selectorId();
				}
				break;
			case DOT:
				{
				setState(62); selectorClass();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SelectorTagContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(ICSSParser.ID, 0); }
		public SelectorTagContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_selectorTag; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ICSSListener ) ((ICSSListener)listener).enterSelectorTag(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ICSSListener ) ((ICSSListener)listener).exitSelectorTag(this);
		}
	}

	public final SelectorTagContext selectorTag() throws RecognitionException {
		SelectorTagContext _localctx = new SelectorTagContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_selectorTag);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(65); match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SelectorIdContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(ICSSParser.ID, 0); }
		public TerminalNode HASH() { return getToken(ICSSParser.HASH, 0); }
		public SelectorIdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_selectorId; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ICSSListener ) ((ICSSListener)listener).enterSelectorId(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ICSSListener ) ((ICSSListener)listener).exitSelectorId(this);
		}
	}

	public final SelectorIdContext selectorId() throws RecognitionException {
		SelectorIdContext _localctx = new SelectorIdContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_selectorId);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(67); match(HASH);
			setState(68); match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SelectorClassContext extends ParserRuleContext {
		public TerminalNode DOT() { return getToken(ICSSParser.DOT, 0); }
		public TerminalNode ID() { return getToken(ICSSParser.ID, 0); }
		public SelectorClassContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_selectorClass; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ICSSListener ) ((ICSSListener)listener).enterSelectorClass(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ICSSListener ) ((ICSSListener)listener).exitSelectorClass(this);
		}
	}

	public final SelectorClassContext selectorClass() throws RecognitionException {
		SelectorClassContext _localctx = new SelectorClassContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_selectorClass);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(70); match(DOT);
			setState(71); match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeclarationsContext extends ParserRuleContext {
		public List<DeclarationContext> declaration() {
			return getRuleContexts(DeclarationContext.class);
		}
		public DeclarationContext declaration(int i) {
			return getRuleContext(DeclarationContext.class,i);
		}
		public DeclarationsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declarations; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ICSSListener ) ((ICSSListener)listener).enterDeclarations(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ICSSListener ) ((ICSSListener)listener).exitDeclarations(this);
		}
	}

	public final DeclarationsContext declarations() throws RecognitionException {
		DeclarationsContext _localctx = new DeclarationsContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_declarations);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(74); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(73); declaration();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(76); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeclarationContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(ICSSParser.ID, 0); }
		public TerminalNode SEMICOLON() { return getToken(ICSSParser.SEMICOLON, 0); }
		public DeclarationValueContext declarationValue() {
			return getRuleContext(DeclarationValueContext.class,0);
		}
		public TerminalNode COLON() { return getToken(ICSSParser.COLON, 0); }
		public DeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ICSSListener ) ((ICSSListener)listener).enterDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ICSSListener ) ((ICSSListener)listener).exitDeclaration(this);
		}
	}

	public final DeclarationContext declaration() throws RecognitionException {
		DeclarationContext _localctx = new DeclarationContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_declaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(78); match(ID);
			setState(79); match(COLON);
			setState(80); declarationValue();
			setState(81); match(SEMICOLON);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeclarationValueContext extends ParserRuleContext {
		public OperationContext operation(int i) {
			return getRuleContext(OperationContext.class,i);
		}
		public ConstantValueContext constantValue() {
			return getRuleContext(ConstantValueContext.class,0);
		}
		public List<OperationContext> operation() {
			return getRuleContexts(OperationContext.class);
		}
		public ConstantNameContext constantName() {
			return getRuleContext(ConstantNameContext.class,0);
		}
		public DeclarationValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declarationValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ICSSListener ) ((ICSSListener)listener).enterDeclarationValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ICSSListener ) ((ICSSListener)listener).exitDeclarationValue(this);
		}
	}

	public final DeclarationValueContext declarationValue() throws RecognitionException {
		DeclarationValueContext _localctx = new DeclarationValueContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_declarationValue);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(90);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				{
				setState(83); constantValue();
				}
				break;

			case 2:
				{
				setState(84); constantName();
				}
				break;

			case 3:
				{
				setState(86); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(85); operation();
					}
					}
					setState(88); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LiteralValue) | (1L << ColorLiteral) | (1L << DOLLAR))) != 0) );
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OperationContext extends ParserRuleContext {
		public ConstantValueContext constantValue() {
			return getRuleContext(ConstantValueContext.class,0);
		}
		public OperationContext operation() {
			return getRuleContext(OperationContext.class,0);
		}
		public TerminalNode Operator() { return getToken(ICSSParser.Operator, 0); }
		public ConstantNameContext constantName() {
			return getRuleContext(ConstantNameContext.class,0);
		}
		public OperationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ICSSListener ) ((ICSSListener)listener).enterOperation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ICSSListener ) ((ICSSListener)listener).exitOperation(this);
		}
	}

	public final OperationContext operation() throws RecognitionException {
		OperationContext _localctx = new OperationContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_operation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(94);
			switch (_input.LA(1)) {
			case LiteralValue:
			case ColorLiteral:
				{
				setState(92); constantValue();
				}
				break;
			case DOLLAR:
				{
				setState(93); constantName();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(97);
			_la = _input.LA(1);
			if (_la==Operator) {
				{
				setState(96); match(Operator);
				}
			}

			setState(100);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				{
				setState(99); operation();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConstantsContext extends ParserRuleContext {
		public List<ConstantContext> constant() {
			return getRuleContexts(ConstantContext.class);
		}
		public ConstantContext constant(int i) {
			return getRuleContext(ConstantContext.class,i);
		}
		public ConstantsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constants; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ICSSListener ) ((ICSSListener)listener).enterConstants(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ICSSListener ) ((ICSSListener)listener).exitConstants(this);
		}
	}

	public final ConstantsContext constants() throws RecognitionException {
		ConstantsContext _localctx = new ConstantsContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_constants);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(103); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(102); constant();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(105); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConstantContext extends ParserRuleContext {
		public TerminalNode EQUALS() { return getToken(ICSSParser.EQUALS, 0); }
		public TerminalNode SEMICOLON() { return getToken(ICSSParser.SEMICOLON, 0); }
		public ConstantValueContext constantValue() {
			return getRuleContext(ConstantValueContext.class,0);
		}
		public OperationContext operation() {
			return getRuleContext(OperationContext.class,0);
		}
		public ConstantNameContext constantName() {
			return getRuleContext(ConstantNameContext.class,0);
		}
		public ConstantContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constant; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ICSSListener ) ((ICSSListener)listener).enterConstant(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ICSSListener ) ((ICSSListener)listener).exitConstant(this);
		}
	}

	public final ConstantContext constant() throws RecognitionException {
		ConstantContext _localctx = new ConstantContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_constant);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(107); constantName();
			setState(108); match(EQUALS);
			setState(111);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				{
				setState(109); constantValue();
				}
				break;

			case 2:
				{
				setState(110); operation();
				}
				break;
			}
			setState(113); match(SEMICOLON);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConstantNameContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(ICSSParser.ID, 0); }
		public TerminalNode DOLLAR() { return getToken(ICSSParser.DOLLAR, 0); }
		public ConstantNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constantName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ICSSListener ) ((ICSSListener)listener).enterConstantName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ICSSListener ) ((ICSSListener)listener).exitConstantName(this);
		}
	}

	public final ConstantNameContext constantName() throws RecognitionException {
		ConstantNameContext _localctx = new ConstantNameContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_constantName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(115); match(DOLLAR);
			setState(116); match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConstantValueContext extends ParserRuleContext {
		public ConstantValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constantValue; }
	 
		public ConstantValueContext() { }
		public void copyFrom(ConstantValueContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ValueLiteralContext extends ConstantValueContext {
		public TerminalNode LiteralValue() { return getToken(ICSSParser.LiteralValue, 0); }
		public ValueLiteralContext(ConstantValueContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ICSSListener ) ((ICSSListener)listener).enterValueLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ICSSListener ) ((ICSSListener)listener).exitValueLiteral(this);
		}
	}
	public static class ColorLiteralContext extends ConstantValueContext {
		public TerminalNode ColorLiteral() { return getToken(ICSSParser.ColorLiteral, 0); }
		public ColorLiteralContext(ConstantValueContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ICSSListener ) ((ICSSListener)listener).enterColorLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ICSSListener ) ((ICSSListener)listener).exitColorLiteral(this);
		}
	}

	public final ConstantValueContext constantValue() throws RecognitionException {
		ConstantValueContext _localctx = new ConstantValueContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_constantValue);
		try {
			setState(120);
			switch (_input.LA(1)) {
			case LiteralValue:
				_localctx = new ValueLiteralContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(118); match(LiteralValue);
				}
				break;
			case ColorLiteral:
				_localctx = new ColorLiteralContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(119); match(ColorLiteral);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\25}\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t\13\4"+
		"\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\3\2\3\2\7\2#\n\2\f\2\16\2"+
		"&\13\2\3\3\6\3)\n\3\r\3\16\3*\3\4\3\4\3\4\5\4\60\n\4\3\4\5\4\63\n\4\3"+
		"\4\5\4\66\n\4\3\4\5\49\n\4\5\4;\n\4\3\4\3\4\3\5\3\5\3\5\5\5B\n\5\3\6\3"+
		"\6\3\7\3\7\3\7\3\b\3\b\3\b\3\t\6\tM\n\t\r\t\16\tN\3\n\3\n\3\n\3\n\3\n"+
		"\3\13\3\13\3\13\6\13Y\n\13\r\13\16\13Z\5\13]\n\13\3\f\3\f\5\fa\n\f\3\f"+
		"\5\fd\n\f\3\f\5\fg\n\f\3\r\6\rj\n\r\r\r\16\rk\3\16\3\16\3\16\3\16\5\16"+
		"r\n\16\3\16\3\16\3\17\3\17\3\17\3\20\3\20\5\20{\n\20\3\20\2\2\21\2\4\6"+
		"\b\n\f\16\20\22\24\26\30\32\34\36\2\2\u0081\2$\3\2\2\2\4(\3\2\2\2\6,\3"+
		"\2\2\2\bA\3\2\2\2\nC\3\2\2\2\fE\3\2\2\2\16H\3\2\2\2\20L\3\2\2\2\22P\3"+
		"\2\2\2\24\\\3\2\2\2\26`\3\2\2\2\30i\3\2\2\2\32m\3\2\2\2\34u\3\2\2\2\36"+
		"z\3\2\2\2 #\5\30\r\2!#\5\4\3\2\" \3\2\2\2\"!\3\2\2\2#&\3\2\2\2$\"\3\2"+
		"\2\2$%\3\2\2\2%\3\3\2\2\2&$\3\2\2\2\')\5\6\4\2(\'\3\2\2\2)*\3\2\2\2*("+
		"\3\2\2\2*+\3\2\2\2+\5\3\2\2\2,-\5\b\5\2-:\7\13\2\2.\60\5\20\t\2/.\3\2"+
		"\2\2/\60\3\2\2\2\60\62\3\2\2\2\61\63\5\4\3\2\62\61\3\2\2\2\62\63\3\2\2"+
		"\2\63;\3\2\2\2\64\66\5\4\3\2\65\64\3\2\2\2\65\66\3\2\2\2\668\3\2\2\2\67"+
		"9\5\20\t\28\67\3\2\2\289\3\2\2\29;\3\2\2\2:/\3\2\2\2:\65\3\2\2\2;<\3\2"+
		"\2\2<=\7\f\2\2=\7\3\2\2\2>B\5\n\6\2?B\5\f\7\2@B\5\16\b\2A>\3\2\2\2A?\3"+
		"\2\2\2A@\3\2\2\2B\t\3\2\2\2CD\7\5\2\2D\13\3\2\2\2EF\7\17\2\2FG\7\5\2\2"+
		"G\r\3\2\2\2HI\7\20\2\2IJ\7\5\2\2J\17\3\2\2\2KM\5\22\n\2LK\3\2\2\2MN\3"+
		"\2\2\2NL\3\2\2\2NO\3\2\2\2O\21\3\2\2\2PQ\7\5\2\2QR\7\22\2\2RS\5\24\13"+
		"\2ST\7\21\2\2T\23\3\2\2\2U]\5\36\20\2V]\5\34\17\2WY\5\26\f\2XW\3\2\2\2"+
		"YZ\3\2\2\2ZX\3\2\2\2Z[\3\2\2\2[]\3\2\2\2\\U\3\2\2\2\\V\3\2\2\2\\X\3\2"+
		"\2\2]\25\3\2\2\2^a\5\36\20\2_a\5\34\17\2`^\3\2\2\2`_\3\2\2\2ac\3\2\2\2"+
		"bd\7\3\2\2cb\3\2\2\2cd\3\2\2\2df\3\2\2\2eg\5\26\f\2fe\3\2\2\2fg\3\2\2"+
		"\2g\27\3\2\2\2hj\5\32\16\2ih\3\2\2\2jk\3\2\2\2ki\3\2\2\2kl\3\2\2\2l\31"+
		"\3\2\2\2mn\5\34\17\2nq\7\r\2\2or\5\36\20\2pr\5\26\f\2qo\3\2\2\2qp\3\2"+
		"\2\2rs\3\2\2\2st\7\21\2\2t\33\3\2\2\2uv\7\16\2\2vw\7\5\2\2w\35\3\2\2\2"+
		"x{\7\4\2\2y{\7\7\2\2zx\3\2\2\2zy\3\2\2\2{\37\3\2\2\2\24\"$*/\62\658:A"+
		"NZ\\`cfkqz";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}