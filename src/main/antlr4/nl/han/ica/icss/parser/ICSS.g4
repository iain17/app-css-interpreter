grammar ICSS;

//Parser
stylesheet 	            : constants? styleRules?;

styleRules              : styleRule+;
styleRule               : selector START_BLOCK (declarations? styleRules? |  styleRules? declarations?) END_BLOCK;

selector                : (selectorTag | selectorId | selectorClass);
selectorTag             : ID;
selectorId              : HASH ID;
selectorClass           : DOT ID;

declarations            : declaration+;
declaration             : ID COLON declarationValue SEMICOLON;
declarationValue        : (constantValue
                            | constantName
                            | operation+);

operation               : (constantValue | constantName) Operator? operation?;

constants               : constant+;
constant                : constantName EQUALS constantValue SEMICOLON;
constantName            : DOLLAR ID;
constantValue           : LiteralValue #valueLiteral
                        | ColorLiteral #colorLiteral;

//Lexer
Operator                : PLUS | MINUS;

LiteralValue            : INT (PixelLiteral | PercentageLiteral);

ID                      : [a-zA-Z0-9\-_]+;
INT                     : [0-9]+;

ColorLiteral            : HASH HexaDecimal HexaDecimal HexaDecimal HexaDecimal HexaDecimal HexaDecimal;
HexaDecimal             : [0-9a-fA-F];

PixelLiteral            : 'px';
PercentageLiteral       : '%';

START_BLOCK             : '{';
END_BLOCK               : '}';
EQUALS                  : '=';
DOLLAR                  : '$';
HASH                    : '#';
DOT                     : '.';
SEMICOLON               : ';';
COLON                   : ':';
PLUS                    : '+';
MINUS                   : '-';

WS			            : [ \t\r\n]+ -> skip ;