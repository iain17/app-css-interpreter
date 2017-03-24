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
		public StyleRulesContext styleRules() {
			return getRuleContext(StyleRulesContext.class,0);
		}
		public ConstantsContext constants() {
			return getRuleContext(ConstantsContext.class,0);
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
			setState(31);
			_la = _input.LA(1);
			if (_la==DOLLAR) {
				{
				setState(30); constants();
				}
			}

			setState(33); styleRules();
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
			setState(36); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(35); styleRule();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(38); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
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
			setState(40); selector();
			setState(41); match(START_BLOCK);
			setState(54);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				{
				setState(43);
				switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
				case 1:
					{
					setState(42); declarations();
					}
					break;
				}
				setState(46);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ID) | (1L << HASH) | (1L << DOT))) != 0)) {
					{
					setState(45); styleRules();
					}
				}

				}
				break;

			case 2:
				{
				setState(49);
				switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
				case 1:
					{
					setState(48); styleRules();
					}
					break;
				}
				setState(52);
				_la = _input.LA(1);
				if (_la==ID) {
					{
					setState(51); declarations();
					}
				}

				}
				break;
			}
			setState(56); match(END_BLOCK);
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
			setState(61);
			switch (_input.LA(1)) {
			case ID:
				{
				setState(58); selectorTag();
				}
				break;
			case HASH:
				{
				setState(59); selectorId();
				}
				break;
			case DOT:
				{
				setState(60); selectorClass();
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
			setState(63); match(ID);
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
			setState(65); match(HASH);
			setState(66); match(ID);
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
			setState(68); match(DOT);
			setState(69); match(ID);
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
			setState(72); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(71); declaration();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(74); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
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
			setState(76); match(ID);
			setState(77); match(COLON);
			setState(78); declarationValue();
			setState(79); match(SEMICOLON);
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
		public ConstantValueContext constantValue() {
			return getRuleContext(ConstantValueContext.class,0);
		}
		public OperationContext operation() {
			return getRuleContext(OperationContext.class,0);
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
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(84);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				{
				setState(81); constantValue();
				}
				break;

			case 2:
				{
				setState(82); constantName();
				}
				break;

			case 3:
				{
				setState(83); operation(0);
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
		public TerminalNode LiteralValue() { return getToken(ICSSParser.LiteralValue, 0); }
		public OperationContext operation(int i) {
			return getRuleContext(OperationContext.class,i);
		}
		public List<OperationContext> operation() {
			return getRuleContexts(OperationContext.class);
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
		return operation(0);
	}

	private OperationContext operation(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		OperationContext _localctx = new OperationContext(_ctx, _parentState);
		OperationContext _prevctx = _localctx;
		int _startState = 20;
		enterRecursionRule(_localctx, 20, RULE_operation, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(89);
			switch (_input.LA(1)) {
			case DOLLAR:
				{
				setState(87); constantName();
				}
				break;
			case LiteralValue:
				{
				setState(88); match(LiteralValue);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
			_ctx.stop = _input.LT(-1);
			setState(96);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new OperationContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_operation);
					setState(91);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(92); match(Operator);
					setState(93); operation(2);
					}
					} 
				}
				setState(98);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
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
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(100); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(99); constant();
				}
				}
				setState(102); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==DOLLAR );
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
			setState(104); constantName();
			setState(105); match(EQUALS);
			setState(106); constantValue();
			setState(107); match(SEMICOLON);
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
			setState(109); match(DOLLAR);
			setState(110); match(ID);
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
			setState(114);
			switch (_input.LA(1)) {
			case LiteralValue:
				_localctx = new ValueLiteralContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(112); match(LiteralValue);
				}
				break;
			case ColorLiteral:
				_localctx = new ColorLiteralContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(113); match(ColorLiteral);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 10: return operation_sempred((OperationContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean operation_sempred(OperationContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0: return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\25w\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t\13\4"+
		"\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\3\2\5\2\"\n\2\3\2\3\2\3\3"+
		"\6\3\'\n\3\r\3\16\3(\3\4\3\4\3\4\5\4.\n\4\3\4\5\4\61\n\4\3\4\5\4\64\n"+
		"\4\3\4\5\4\67\n\4\5\49\n\4\3\4\3\4\3\5\3\5\3\5\5\5@\n\5\3\6\3\6\3\7\3"+
		"\7\3\7\3\b\3\b\3\b\3\t\6\tK\n\t\r\t\16\tL\3\n\3\n\3\n\3\n\3\n\3\13\3\13"+
		"\3\13\5\13W\n\13\3\f\3\f\3\f\5\f\\\n\f\3\f\3\f\3\f\7\fa\n\f\f\f\16\fd"+
		"\13\f\3\r\6\rg\n\r\r\r\16\rh\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3"+
		"\20\3\20\5\20u\n\20\3\20\2\3\26\21\2\4\6\b\n\f\16\20\22\24\26\30\32\34"+
		"\36\2\2w\2!\3\2\2\2\4&\3\2\2\2\6*\3\2\2\2\b?\3\2\2\2\nA\3\2\2\2\fC\3\2"+
		"\2\2\16F\3\2\2\2\20J\3\2\2\2\22N\3\2\2\2\24V\3\2\2\2\26X\3\2\2\2\30f\3"+
		"\2\2\2\32j\3\2\2\2\34o\3\2\2\2\36t\3\2\2\2 \"\5\30\r\2! \3\2\2\2!\"\3"+
		"\2\2\2\"#\3\2\2\2#$\5\4\3\2$\3\3\2\2\2%\'\5\6\4\2&%\3\2\2\2\'(\3\2\2\2"+
		"(&\3\2\2\2()\3\2\2\2)\5\3\2\2\2*+\5\b\5\2+8\7\13\2\2,.\5\20\t\2-,\3\2"+
		"\2\2-.\3\2\2\2.\60\3\2\2\2/\61\5\4\3\2\60/\3\2\2\2\60\61\3\2\2\2\619\3"+
		"\2\2\2\62\64\5\4\3\2\63\62\3\2\2\2\63\64\3\2\2\2\64\66\3\2\2\2\65\67\5"+
		"\20\t\2\66\65\3\2\2\2\66\67\3\2\2\2\679\3\2\2\28-\3\2\2\28\63\3\2\2\2"+
		"9:\3\2\2\2:;\7\f\2\2;\7\3\2\2\2<@\5\n\6\2=@\5\f\7\2>@\5\16\b\2?<\3\2\2"+
		"\2?=\3\2\2\2?>\3\2\2\2@\t\3\2\2\2AB\7\5\2\2B\13\3\2\2\2CD\7\17\2\2DE\7"+
		"\5\2\2E\r\3\2\2\2FG\7\20\2\2GH\7\5\2\2H\17\3\2\2\2IK\5\22\n\2JI\3\2\2"+
		"\2KL\3\2\2\2LJ\3\2\2\2LM\3\2\2\2M\21\3\2\2\2NO\7\5\2\2OP\7\22\2\2PQ\5"+
		"\24\13\2QR\7\21\2\2R\23\3\2\2\2SW\5\36\20\2TW\5\34\17\2UW\5\26\f\2VS\3"+
		"\2\2\2VT\3\2\2\2VU\3\2\2\2W\25\3\2\2\2X[\b\f\1\2Y\\\5\34\17\2Z\\\7\4\2"+
		"\2[Y\3\2\2\2[Z\3\2\2\2\\b\3\2\2\2]^\f\3\2\2^_\7\3\2\2_a\5\26\f\4`]\3\2"+
		"\2\2ad\3\2\2\2b`\3\2\2\2bc\3\2\2\2c\27\3\2\2\2db\3\2\2\2eg\5\32\16\2f"+
		"e\3\2\2\2gh\3\2\2\2hf\3\2\2\2hi\3\2\2\2i\31\3\2\2\2jk\5\34\17\2kl\7\r"+
		"\2\2lm\5\36\20\2mn\7\21\2\2n\33\3\2\2\2op\7\16\2\2pq\7\5\2\2q\35\3\2\2"+
		"\2ru\7\4\2\2su\7\7\2\2tr\3\2\2\2ts\3\2\2\2u\37\3\2\2\2\20!(-\60\63\66"+
		"8?LV[bht";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}