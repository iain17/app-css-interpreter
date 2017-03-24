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
		Operator=1, LiteralValue=2, ID=3, INT=4, ColorLiteral=5, HexaDecimal=6, 
		PixelLiteral=7, PercentageLiteral=8, START_BLOCK=9, END_BLOCK=10, EQUALS=11, 
		DOLLAR=12, HASH=13, DOT=14, SEMICOLON=15, COLON=16, PLUS=17, MINUS=18, 
		WS=19;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"'\\u0000'", "'\\u0001'", "'\\u0002'", "'\\u0003'", "'\\u0004'", "'\\u0005'", 
		"'\\u0006'", "'\\u0007'", "'\b'", "'\t'", "'\n'", "'\\u000B'", "'\f'", 
		"'\r'", "'\\u000E'", "'\\u000F'", "'\\u0010'", "'\\u0011'", "'\\u0012'", 
		"'\\u0013'"
	};
	public static final String[] ruleNames = {
		"Operator", "LiteralValue", "ID", "INT", "ColorLiteral", "HexaDecimal", 
		"PixelLiteral", "PercentageLiteral", "START_BLOCK", "END_BLOCK", "EQUALS", 
		"DOLLAR", "HASH", "DOT", "SEMICOLON", "COLON", "PLUS", "MINUS", "WS"
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\25f\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\3\2\3\2\5\2,\n\2\3\3\3\3\3\3\5\3\61\n\3\3\4\6\4\64"+
		"\n\4\r\4\16\4\65\3\5\6\59\n\5\r\5\16\5:\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3"+
		"\6\3\7\3\7\3\b\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16"+
		"\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3\23\3\24\6\24a\n\24"+
		"\r\24\16\24b\3\24\3\24\2\2\25\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13"+
		"\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25\3\2\6\7\2//\62;C\\"+
		"aac|\3\2\62;\5\2\62;CHch\5\2\13\f\17\17\"\"j\2\3\3\2\2\2\2\5\3\2\2\2\2"+
		"\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2"+
		"\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2"+
		"\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2"+
		"\2\3+\3\2\2\2\5-\3\2\2\2\7\63\3\2\2\2\t8\3\2\2\2\13<\3\2\2\2\rD\3\2\2"+
		"\2\17F\3\2\2\2\21I\3\2\2\2\23K\3\2\2\2\25M\3\2\2\2\27O\3\2\2\2\31Q\3\2"+
		"\2\2\33S\3\2\2\2\35U\3\2\2\2\37W\3\2\2\2!Y\3\2\2\2#[\3\2\2\2%]\3\2\2\2"+
		"\'`\3\2\2\2),\5#\22\2*,\5%\23\2+)\3\2\2\2+*\3\2\2\2,\4\3\2\2\2-\60\5\t"+
		"\5\2.\61\5\17\b\2/\61\5\21\t\2\60.\3\2\2\2\60/\3\2\2\2\61\6\3\2\2\2\62"+
		"\64\t\2\2\2\63\62\3\2\2\2\64\65\3\2\2\2\65\63\3\2\2\2\65\66\3\2\2\2\66"+
		"\b\3\2\2\2\679\t\3\2\28\67\3\2\2\29:\3\2\2\2:8\3\2\2\2:;\3\2\2\2;\n\3"+
		"\2\2\2<=\5\33\16\2=>\5\r\7\2>?\5\r\7\2?@\5\r\7\2@A\5\r\7\2AB\5\r\7\2B"+
		"C\5\r\7\2C\f\3\2\2\2DE\t\4\2\2E\16\3\2\2\2FG\7r\2\2GH\7z\2\2H\20\3\2\2"+
		"\2IJ\7\'\2\2J\22\3\2\2\2KL\7}\2\2L\24\3\2\2\2MN\7\177\2\2N\26\3\2\2\2"+
		"OP\7?\2\2P\30\3\2\2\2QR\7&\2\2R\32\3\2\2\2ST\7%\2\2T\34\3\2\2\2UV\7\60"+
		"\2\2V\36\3\2\2\2WX\7=\2\2X \3\2\2\2YZ\7<\2\2Z\"\3\2\2\2[\\\7-\2\2\\$\3"+
		"\2\2\2]^\7/\2\2^&\3\2\2\2_a\t\5\2\2`_\3\2\2\2ab\3\2\2\2b`\3\2\2\2bc\3"+
		"\2\2\2cd\3\2\2\2de\b\24\2\2e(\3\2\2\2\b\2+\60\65:b\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}