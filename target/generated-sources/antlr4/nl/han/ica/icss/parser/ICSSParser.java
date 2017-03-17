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
		T__7=1, T__6=2, T__5=3, T__4=4, T__3=5, T__2=6, T__1=7, T__0=8, ID=9, 
		Measurement=10, WS=11, Number=12, HexColor=13, Unit=14;
	public static final String[] tokenNames = {
		"<INVALID>", "'#'", "'$'", "':'", "';'", "'{'", "'='", "'}'", "'.'", "ID", 
		"Measurement", "WS", "Number", "HexColor", "Unit"
	};
	public static final int
		RULE_stylesheet = 0, RULE_stylRule = 1, RULE_attributes = 2, RULE_attribute = 3, 
		RULE_value = 4, RULE_varValue = 5, RULE_var = 6;
	public static final String[] ruleNames = {
		"stylesheet", "stylRule", "attributes", "attribute", "value", "varValue", 
		"var"
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
		public List<VarContext> var() {
			return getRuleContexts(VarContext.class);
		}
		public List<StylRuleContext> stylRule() {
			return getRuleContexts(StylRuleContext.class);
		}
		public StylRuleContext stylRule(int i) {
			return getRuleContext(StylRuleContext.class,i);
		}
		public VarContext var(int i) {
			return getRuleContext(VarContext.class,i);
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
			int _alt;
			setState(29);
			switch (_input.LA(1)) {
			case T__6:
				enterOuterAlt(_localctx, 1);
				{
				setState(15); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(14); var();
					}
					}
					setState(17); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==T__6 );
				setState(20); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(19); stylRule();
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(22); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				break;
			case T__7:
			case T__0:
			case ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(25); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(24); stylRule();
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(27); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
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

	public static class StylRuleContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(ICSSParser.ID, 0); }
		public AttributesContext attributes() {
			return getRuleContext(AttributesContext.class,0);
		}
		public StylesheetContext stylesheet() {
			return getRuleContext(StylesheetContext.class,0);
		}
		public StylRuleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stylRule; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ICSSListener ) ((ICSSListener)listener).enterStylRule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ICSSListener ) ((ICSSListener)listener).exitStylRule(this);
		}
	}

	public final StylRuleContext stylRule() throws RecognitionException {
		StylRuleContext _localctx = new StylRuleContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_stylRule);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(44);
			switch (_input.LA(1)) {
			case ID:
				{
				setState(31); match(ID);
				}
				break;
			case T__7:
				{
				setState(33); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(32); match(T__7);
					}
					}
					setState(35); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==T__7 );
				setState(37); match(ID);
				}
				break;
			case T__0:
				{
				setState(39); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(38); match(T__0);
					}
					}
					setState(41); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==T__0 );
				setState(43); match(ID);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(46); match(T__3);
			setState(59);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				{
				setState(48);
				switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
				case 1:
					{
					setState(47); attributes();
					}
					break;
				}
				setState(51);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__6) | (1L << T__0) | (1L << ID))) != 0)) {
					{
					setState(50); stylesheet();
					}
				}

				}
				break;

			case 2:
				{
				setState(54);
				switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
				case 1:
					{
					setState(53); stylesheet();
					}
					break;
				}
				setState(57);
				_la = _input.LA(1);
				if (_la==ID) {
					{
					setState(56); attributes();
					}
				}

				}
				break;
			}
			setState(61); match(T__1);
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

	public static class AttributesContext extends ParserRuleContext {
		public List<AttributeContext> attribute() {
			return getRuleContexts(AttributeContext.class);
		}
		public AttributeContext attribute(int i) {
			return getRuleContext(AttributeContext.class,i);
		}
		public AttributesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attributes; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ICSSListener ) ((ICSSListener)listener).enterAttributes(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ICSSListener ) ((ICSSListener)listener).exitAttributes(this);
		}
	}

	public final AttributesContext attributes() throws RecognitionException {
		AttributesContext _localctx = new AttributesContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_attributes);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(64); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(63); attribute();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(66); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
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

	public static class AttributeContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(ICSSParser.ID); }
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public TerminalNode ID(int i) {
			return getToken(ICSSParser.ID, i);
		}
		public AttributeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attribute; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ICSSListener ) ((ICSSListener)listener).enterAttribute(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ICSSListener ) ((ICSSListener)listener).exitAttribute(this);
		}
	}

	public final AttributeContext attribute() throws RecognitionException {
		AttributeContext _localctx = new AttributeContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_attribute);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(69); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(68); match(ID);
				}
				}
				setState(71); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==ID );
			setState(73); match(T__5);
			setState(74); value();
			setState(75); match(T__4);
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

	public static class ValueContext extends ParserRuleContext {
		public TerminalNode HexColor() { return getToken(ICSSParser.HexColor, 0); }
		public TerminalNode Measurement() { return getToken(ICSSParser.Measurement, 0); }
		public ValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ICSSListener ) ((ICSSListener)listener).enterValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ICSSListener ) ((ICSSListener)listener).exitValue(this);
		}
	}

	public final ValueContext value() throws RecognitionException {
		ValueContext _localctx = new ValueContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_value);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(77);
			_la = _input.LA(1);
			if ( !(_la==Measurement || _la==HexColor) ) {
			_errHandler.recoverInline(this);
			}
			consume();
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

	public static class VarValueContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(ICSSParser.ID, 0); }
		public VarValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ICSSListener ) ((ICSSListener)listener).enterVarValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ICSSListener ) ((ICSSListener)listener).exitVarValue(this);
		}
	}

	public final VarValueContext varValue() throws RecognitionException {
		VarValueContext _localctx = new VarValueContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_varValue);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(80); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(79); match(T__6);
				}
				}
				setState(82); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__6 );
			setState(84); match(ID);
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

	public static class VarContext extends ParserRuleContext {
		public VarValueContext varValue() {
			return getRuleContext(VarValueContext.class,0);
		}
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public VarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_var; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ICSSListener ) ((ICSSListener)listener).enterVar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ICSSListener ) ((ICSSListener)listener).exitVar(this);
		}
	}

	public final VarContext var() throws RecognitionException {
		VarContext _localctx = new VarContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_var);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(86); varValue();
			setState(87); match(T__2);
			setState(88); value();
			setState(89); match(T__4);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\20^\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\3\2\6\2\22\n\2\r\2\16\2\23"+
		"\3\2\6\2\27\n\2\r\2\16\2\30\3\2\6\2\34\n\2\r\2\16\2\35\5\2 \n\2\3\3\3"+
		"\3\6\3$\n\3\r\3\16\3%\3\3\3\3\6\3*\n\3\r\3\16\3+\3\3\5\3/\n\3\3\3\3\3"+
		"\5\3\63\n\3\3\3\5\3\66\n\3\3\3\5\39\n\3\3\3\5\3<\n\3\5\3>\n\3\3\3\3\3"+
		"\3\4\6\4C\n\4\r\4\16\4D\3\5\6\5H\n\5\r\5\16\5I\3\5\3\5\3\5\3\5\3\6\3\6"+
		"\3\7\6\7S\n\7\r\7\16\7T\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\2\2\t\2\4\6\b"+
		"\n\f\16\2\3\4\2\f\f\17\17f\2\37\3\2\2\2\4.\3\2\2\2\6B\3\2\2\2\bG\3\2\2"+
		"\2\nO\3\2\2\2\fR\3\2\2\2\16X\3\2\2\2\20\22\5\16\b\2\21\20\3\2\2\2\22\23"+
		"\3\2\2\2\23\21\3\2\2\2\23\24\3\2\2\2\24\26\3\2\2\2\25\27\5\4\3\2\26\25"+
		"\3\2\2\2\27\30\3\2\2\2\30\26\3\2\2\2\30\31\3\2\2\2\31 \3\2\2\2\32\34\5"+
		"\4\3\2\33\32\3\2\2\2\34\35\3\2\2\2\35\33\3\2\2\2\35\36\3\2\2\2\36 \3\2"+
		"\2\2\37\21\3\2\2\2\37\33\3\2\2\2 \3\3\2\2\2!/\7\13\2\2\"$\7\3\2\2#\"\3"+
		"\2\2\2$%\3\2\2\2%#\3\2\2\2%&\3\2\2\2&\'\3\2\2\2\'/\7\13\2\2(*\7\n\2\2"+
		")(\3\2\2\2*+\3\2\2\2+)\3\2\2\2+,\3\2\2\2,-\3\2\2\2-/\7\13\2\2.!\3\2\2"+
		"\2.#\3\2\2\2.)\3\2\2\2/\60\3\2\2\2\60=\7\7\2\2\61\63\5\6\4\2\62\61\3\2"+
		"\2\2\62\63\3\2\2\2\63\65\3\2\2\2\64\66\5\2\2\2\65\64\3\2\2\2\65\66\3\2"+
		"\2\2\66>\3\2\2\2\679\5\2\2\28\67\3\2\2\289\3\2\2\29;\3\2\2\2:<\5\6\4\2"+
		";:\3\2\2\2;<\3\2\2\2<>\3\2\2\2=\62\3\2\2\2=8\3\2\2\2>?\3\2\2\2?@\7\t\2"+
		"\2@\5\3\2\2\2AC\5\b\5\2BA\3\2\2\2CD\3\2\2\2DB\3\2\2\2DE\3\2\2\2E\7\3\2"+
		"\2\2FH\7\13\2\2GF\3\2\2\2HI\3\2\2\2IG\3\2\2\2IJ\3\2\2\2JK\3\2\2\2KL\7"+
		"\5\2\2LM\5\n\6\2MN\7\6\2\2N\t\3\2\2\2OP\t\2\2\2P\13\3\2\2\2QS\7\4\2\2"+
		"RQ\3\2\2\2ST\3\2\2\2TR\3\2\2\2TU\3\2\2\2UV\3\2\2\2VW\7\13\2\2W\r\3\2\2"+
		"\2XY\5\f\7\2YZ\7\b\2\2Z[\5\n\6\2[\\\7\6\2\2\\\17\3\2\2\2\21\23\30\35\37"+
		"%+.\62\658;=DIT";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}