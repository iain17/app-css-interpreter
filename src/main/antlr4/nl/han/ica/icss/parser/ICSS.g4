grammar ICSS;

//Parser
stylesheet 	            : constants? styleRules;

styleRules              : styleRule+;
styleRule               : selector '{' declarations? styleRule? '}';
selector                : (ID | '#' ID | '.' ID);

declarations            : declaration+;
declaration             : ID+':' declarationValue ';';
declarationValue        : constantValue | constantName | operation;

operation               : (constantName | LiteralValue)
                        | operation Operator operation;

constants               : constant+;
constant                : constantName '=' constantValue ';';
constantName            : '$' ID;
constantValue           : LiteralValue | ColorLiteral;

//Lexer
Operator                : '+' | '-';

LiteralValue            : Number (PixelLiteral | PercentageLiteral);

PixelLiteral            : 'px';
PercentageLiteral       : '%';

Number                  : [0-9]+;
ID                      : [a-zA-Z0-9\-_]+;
ColorLiteral            : '#' [0-9a-fA-F]+;

WS			            : [ \t\r\n]+ -> skip ;