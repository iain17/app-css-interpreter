grammar ICSS;

//Parser
stylesheet: constant+ styleRule+ | styleRule+;
styleRule: selector '{' (declarations? stylesheet? | stylesheet? declarations?) '}';
selector: ID | '#'+ID | '.'+ID;
declarations: declaration+;
declaration: ID+':' (value | operation) ';';
value: Measurement | Color | constantName;
constantName: ('$'+ID);
constant: constantName '=' value ';';
operation: (value Operator value)+;

//Lexer
Measurement: Number Unit;
Operator: '+' | '-';

Color :  '#' ('0'..'9'|'a'..'f'|'A'..'F')+;
Unit : '%'|'px';

Number : [0-9]+;
ID : [a-zA-Z0-9\-]+;

WS : [ \t\r\n]+ -> skip ;
