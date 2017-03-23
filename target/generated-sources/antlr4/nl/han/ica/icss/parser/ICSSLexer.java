// Generated from nl/han/ica/icss/parser/ICSS.g4 by ANTLR 4.3
package nl.han.ica.icss.parser;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ICSSLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__7=1, T__6=2, T__5=3, T__4=4, T__3=5, T__2=6, T__1=7, T__0=8, Operator=9, 
		LiteralValue=10, PixelLiteral=11, PercentageLiteral=12, Number=13, ID=14, 
		ColorLiteral=15, WS=16;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"'\\u0000'", "'\\u0001'", "'\\u0002'", "'\\u0003'", "'\\u0004'", "'\\u0005'", 
		"'\\u0006'", "'\\u0007'", "'\b'", "'\t'", "'\n'", "'\\u000B'", "'\f'", 
		"'\r'", "'\\u000E'", "'\\u000F'", "'\\u0010'"
	};
	public static final String[] ruleNames = {
		"T__7", "T__6", "T__5", "T__4", "T__3", "T__2", "T__1", "T__0", "Operator", 
		"LiteralValue", "PixelLiteral", "PercentageLiteral", "Number", "ID", "ColorLiteral", 
		"WS"
	};


	public ICSSLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "ICSS.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\22V\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\3\2\3\2\3"+
		"\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3"+
		"\13\3\13\5\139\n\13\3\f\3\f\3\f\3\r\3\r\3\16\6\16A\n\16\r\16\16\16B\3"+
		"\17\6\17F\n\17\r\17\16\17G\3\20\3\20\6\20L\n\20\r\20\16\20M\3\21\6\21"+
		"Q\n\21\r\21\16\21R\3\21\3\21\2\2\22\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n"+
		"\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22\3\2\7\4\2--//\3\2\62;\7\2"+
		"//\62;C\\aac|\5\2\62;CHch\5\2\13\f\17\17\"\"Z\2\3\3\2\2\2\2\5\3\2\2\2"+
		"\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3"+
		"\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2"+
		"\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\3#\3\2\2\2\5%\3\2\2\2\7\'\3\2"+
		"\2\2\t)\3\2\2\2\13+\3\2\2\2\r-\3\2\2\2\17/\3\2\2\2\21\61\3\2\2\2\23\63"+
		"\3\2\2\2\25\65\3\2\2\2\27:\3\2\2\2\31=\3\2\2\2\33@\3\2\2\2\35E\3\2\2\2"+
		"\37I\3\2\2\2!P\3\2\2\2#$\7%\2\2$\4\3\2\2\2%&\7&\2\2&\6\3\2\2\2\'(\7<\2"+
		"\2(\b\3\2\2\2)*\7=\2\2*\n\3\2\2\2+,\7}\2\2,\f\3\2\2\2-.\7?\2\2.\16\3\2"+
		"\2\2/\60\7\177\2\2\60\20\3\2\2\2\61\62\7\60\2\2\62\22\3\2\2\2\63\64\t"+
		"\2\2\2\64\24\3\2\2\2\658\5\33\16\2\669\5\27\f\2\679\5\31\r\28\66\3\2\2"+
		"\28\67\3\2\2\29\26\3\2\2\2:;\7r\2\2;<\7z\2\2<\30\3\2\2\2=>\7\'\2\2>\32"+
		"\3\2\2\2?A\t\3\2\2@?\3\2\2\2AB\3\2\2\2B@\3\2\2\2BC\3\2\2\2C\34\3\2\2\2"+
		"DF\t\4\2\2ED\3\2\2\2FG\3\2\2\2GE\3\2\2\2GH\3\2\2\2H\36\3\2\2\2IK\7%\2"+
		"\2JL\t\5\2\2KJ\3\2\2\2LM\3\2\2\2MK\3\2\2\2MN\3\2\2\2N \3\2\2\2OQ\t\6\2"+
		"\2PO\3\2\2\2QR\3\2\2\2RP\3\2\2\2RS\3\2\2\2ST\3\2\2\2TU\b\21\2\2U\"\3\2"+
		"\2\2\b\28BGMR\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}