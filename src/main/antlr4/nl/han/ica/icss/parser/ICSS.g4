grammar ICSS;

//Parser
stylesheet: var+ stylRule+ | stylRule+;
stylRule: (ID | '#'+ID | '.'+ID) '{' (attributes? stylesheet? | stylesheet? attributes?) '}';
attributes: attribute+;
attribute: ID+':' (value | sum) ';';
value: Measurement | HexColor | varName;
varName: ('$'+ID);
var: varName '=' value ';';
sum: (value Operator value)+;

//Lexer
Measurement: Number Unit;
Operator: '+' | '-' | '*' | '/';

HexColor :  '#' ('0'..'9'|'a'..'f'|'A'..'F')+;
Unit : '%'|'px'|'cm'|'mm'|'in'|'pt'|'pc'|'em'|'ex'|'deg'|'rad'|'grad'|'ms'|'s'|'hz'|'khz';

Number : [0-9]+;
ID : [a-zA-Z0-9\-]+;

WS : [ \t\r\n]+ -> skip ;
