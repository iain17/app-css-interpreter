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
		LiteralValue=10, PixelLiteral=11, PercentageLiteral=12, DeclarationType=13, 
		Number=14, ID=15, ColorLiteral=16, WS=17;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"'\\u0000'", "'\\u0001'", "'\\u0002'", "'\\u0003'", "'\\u0004'", "'\\u0005'", 
		"'\\u0006'", "'\\u0007'", "'\b'", "'\t'", "'\n'", "'\\u000B'", "'\f'", 
		"'\r'", "'\\u000E'", "'\\u000F'", "'\\u0010'", "'\\u0011'"
	};
	public static final String[] ruleNames = {
		"T__7", "T__6", "T__5", "T__4", "T__3", "T__2", "T__1", "T__0", "Operator", 
		"LiteralValue", "PixelLiteral", "PercentageLiteral", "DeclarationType", 
		"Number", "ID", "ColorLiteral", "WS"
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\23t\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3"+
		"\n\3\13\3\13\3\13\5\13;\n\13\3\f\3\f\3\f\3\r\3\r\3\16\3\16\3\16\3\16\3"+
		"\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3"+
		"\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\5\16\\\n\16\3\17\6\17_\n\17\r\17"+
		"\16\17`\3\20\6\20d\n\20\r\20\16\20e\3\21\3\21\6\21j\n\21\r\21\16\21k\3"+
		"\22\6\22o\n\22\r\22\16\22p\3\22\3\22\2\2\23\3\3\5\4\7\5\t\6\13\7\r\b\17"+
		"\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23\3\2\7\4\2--//"+
		"\3\2\62;\7\2//\62;C\\aac|\5\2\62;CHch\5\2\13\f\17\17\"\"z\2\3\3\2\2\2"+
		"\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2"+
		"\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2"+
		"\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\3%\3\2\2"+
		"\2\5\'\3\2\2\2\7)\3\2\2\2\t+\3\2\2\2\13-\3\2\2\2\r/\3\2\2\2\17\61\3\2"+
		"\2\2\21\63\3\2\2\2\23\65\3\2\2\2\25\67\3\2\2\2\27<\3\2\2\2\31?\3\2\2\2"+
		"\33[\3\2\2\2\35^\3\2\2\2\37c\3\2\2\2!g\3\2\2\2#n\3\2\2\2%&\7%\2\2&\4\3"+
		"\2\2\2\'(\7&\2\2(\6\3\2\2\2)*\7<\2\2*\b\3\2\2\2+,\7=\2\2,\n\3\2\2\2-."+
		"\7}\2\2.\f\3\2\2\2/\60\7?\2\2\60\16\3\2\2\2\61\62\7\177\2\2\62\20\3\2"+
		"\2\2\63\64\7\60\2\2\64\22\3\2\2\2\65\66\t\2\2\2\66\24\3\2\2\2\67:\5\35"+
		"\17\28;\5\27\f\29;\5\31\r\2:8\3\2\2\2:9\3\2\2\2;\26\3\2\2\2<=\7r\2\2="+
		">\7z\2\2>\30\3\2\2\2?@\7\'\2\2@\32\3\2\2\2AB\7d\2\2BC\7c\2\2CD\7e\2\2"+
		"DE\7m\2\2EF\7i\2\2FG\7t\2\2GH\7q\2\2HI\7w\2\2IJ\7p\2\2JK\7f\2\2KL\7/\2"+
		"\2LM\7e\2\2MN\7q\2\2NO\7n\2\2OP\7q\2\2P\\\7t\2\2QR\7y\2\2RS\7k\2\2ST\7"+
		"f\2\2TU\7v\2\2U\\\7j\2\2VW\7e\2\2WX\7q\2\2XY\7n\2\2YZ\7q\2\2Z\\\7t\2\2"+
		"[A\3\2\2\2[Q\3\2\2\2[V\3\2\2\2\\\34\3\2\2\2]_\t\3\2\2^]\3\2\2\2_`\3\2"+
		"\2\2`^\3\2\2\2`a\3\2\2\2a\36\3\2\2\2bd\t\4\2\2cb\3\2\2\2de\3\2\2\2ec\3"+
		"\2\2\2ef\3\2\2\2f \3\2\2\2gi\7%\2\2hj\t\5\2\2ih\3\2\2\2jk\3\2\2\2ki\3"+
		"\2\2\2kl\3\2\2\2l\"\3\2\2\2mo\t\6\2\2nm\3\2\2\2op\3\2\2\2pn\3\2\2\2pq"+
		"\3\2\2\2qr\3\2\2\2rs\b\22\2\2s$\3\2\2\2\t\2:[`ekp\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}