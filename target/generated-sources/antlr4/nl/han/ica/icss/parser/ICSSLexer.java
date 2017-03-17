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
		T__7=1, T__6=2, T__5=3, T__4=4, T__3=5, T__2=6, T__1=7, T__0=8, ID=9, 
		Measurement=10, WS=11, Number=12, HexColor=13, Unit=14;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"'\\u0000'", "'\\u0001'", "'\\u0002'", "'\\u0003'", "'\\u0004'", "'\\u0005'", 
		"'\\u0006'", "'\\u0007'", "'\b'", "'\t'", "'\n'", "'\\u000B'", "'\f'", 
		"'\r'", "'\\u000E'"
	};
	public static final String[] ruleNames = {
		"T__7", "T__6", "T__5", "T__4", "T__3", "T__2", "T__1", "T__0", "ID", 
		"Measurement", "WS", "Number", "HexColor", "Unit"
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\20\u0088\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\3\2\3\2\3\3\3\3\3\4\3\4\3"+
		"\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\6\n\61\n\n\r\n\16\n\62\3\13"+
		"\3\13\3\13\3\f\6\f9\n\f\r\f\16\f:\3\f\3\f\3\r\3\r\7\rA\n\r\f\r\16\rD\13"+
		"\r\3\r\5\rG\n\r\3\r\6\rJ\n\r\r\r\16\rK\3\r\7\rO\n\r\f\r\16\rR\13\r\3\r"+
		"\5\rU\n\r\3\r\6\rX\n\r\r\r\16\rY\5\r\\\n\r\3\16\3\16\6\16`\n\16\r\16\16"+
		"\16a\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\5\17\u0087\n\17\2\2\20\3\3\5"+
		"\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\3\2\5"+
		"\6\2//\62;C\\c|\5\2\13\f\17\17\"\"\5\2\62;CHch\u00a0\2\3\3\2\2\2\2\5\3"+
		"\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2"+
		"\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3"+
		"\2\2\2\2\35\3\2\2\2\3\37\3\2\2\2\5!\3\2\2\2\7#\3\2\2\2\t%\3\2\2\2\13\'"+
		"\3\2\2\2\r)\3\2\2\2\17+\3\2\2\2\21-\3\2\2\2\23\60\3\2\2\2\25\64\3\2\2"+
		"\2\278\3\2\2\2\31[\3\2\2\2\33]\3\2\2\2\35\u0086\3\2\2\2\37 \7%\2\2 \4"+
		"\3\2\2\2!\"\7&\2\2\"\6\3\2\2\2#$\7<\2\2$\b\3\2\2\2%&\7=\2\2&\n\3\2\2\2"+
		"\'(\7}\2\2(\f\3\2\2\2)*\7?\2\2*\16\3\2\2\2+,\7\177\2\2,\20\3\2\2\2-.\7"+
		"\60\2\2.\22\3\2\2\2/\61\t\2\2\2\60/\3\2\2\2\61\62\3\2\2\2\62\60\3\2\2"+
		"\2\62\63\3\2\2\2\63\24\3\2\2\2\64\65\5\31\r\2\65\66\5\35\17\2\66\26\3"+
		"\2\2\2\679\t\3\2\28\67\3\2\2\29:\3\2\2\2:8\3\2\2\2:;\3\2\2\2;<\3\2\2\2"+
		"<=\b\f\2\2=\30\3\2\2\2>F\7/\2\2?A\4\62;\2@?\3\2\2\2AD\3\2\2\2B@\3\2\2"+
		"\2BC\3\2\2\2CE\3\2\2\2DB\3\2\2\2EG\7\60\2\2FB\3\2\2\2FG\3\2\2\2GI\3\2"+
		"\2\2HJ\4\62;\2IH\3\2\2\2JK\3\2\2\2KI\3\2\2\2KL\3\2\2\2L\\\3\2\2\2MO\4"+
		"\62;\2NM\3\2\2\2OR\3\2\2\2PN\3\2\2\2PQ\3\2\2\2QS\3\2\2\2RP\3\2\2\2SU\7"+
		"\60\2\2TP\3\2\2\2TU\3\2\2\2UW\3\2\2\2VX\4\62;\2WV\3\2\2\2XY\3\2\2\2YW"+
		"\3\2\2\2YZ\3\2\2\2Z\\\3\2\2\2[>\3\2\2\2[T\3\2\2\2\\\32\3\2\2\2]_\7%\2"+
		"\2^`\t\4\2\2_^\3\2\2\2`a\3\2\2\2a_\3\2\2\2ab\3\2\2\2b\34\3\2\2\2c\u0087"+
		"\7\'\2\2de\7r\2\2e\u0087\7z\2\2fg\7e\2\2g\u0087\7o\2\2hi\7o\2\2i\u0087"+
		"\7o\2\2jk\7k\2\2k\u0087\7p\2\2lm\7r\2\2m\u0087\7v\2\2no\7r\2\2o\u0087"+
		"\7e\2\2pq\7g\2\2q\u0087\7o\2\2rs\7g\2\2s\u0087\7z\2\2tu\7f\2\2uv\7g\2"+
		"\2v\u0087\7i\2\2wx\7t\2\2xy\7c\2\2y\u0087\7f\2\2z{\7i\2\2{|\7t\2\2|}\7"+
		"c\2\2}\u0087\7f\2\2~\177\7o\2\2\177\u0087\7u\2\2\u0080\u0087\7u\2\2\u0081"+
		"\u0082\7j\2\2\u0082\u0087\7|\2\2\u0083\u0084\7m\2\2\u0084\u0085\7j\2\2"+
		"\u0085\u0087\7|\2\2\u0086c\3\2\2\2\u0086d\3\2\2\2\u0086f\3\2\2\2\u0086"+
		"h\3\2\2\2\u0086j\3\2\2\2\u0086l\3\2\2\2\u0086n\3\2\2\2\u0086p\3\2\2\2"+
		"\u0086r\3\2\2\2\u0086t\3\2\2\2\u0086w\3\2\2\2\u0086z\3\2\2\2\u0086~\3"+
		"\2\2\2\u0086\u0080\3\2\2\2\u0086\u0081\3\2\2\2\u0086\u0083\3\2\2\2\u0087"+
		"\36\3\2\2\2\16\2\62:BFKPTY[a\u0086\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}