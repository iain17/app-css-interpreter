grammar ICSS;


//Parser
rules: var+ rule+ | rule+;
rule: (ID | '#'+ID | '.'+ID) '{' (attributes? rules? | rules? attributes?) '}';
attributes: attribute+;
attribute: ID+':' value ';';
value: Measurement | HexColor;//varValue
varValue: ('$'+ID);
var: varValue '=' value ';';

//Lexer
ID : [a-zA-Z-0-9\-]+;
Measurement: Number Unit;
WS : [ \t\r\n]+ -> skip ;
Number : '-' (('0'..'9')* '.')? ('0'..'9')+
        |  (('0'..'9')* '.')? ('0'..'9')+;
HexColor :  '#' ('0'..'9'|'a'..'f'|'A'..'F')+;
Unit : ('%'|'px'|'cm'|'mm'|'in'|'pt'|'pc'|'em'|'ex'|'deg'|'rad'|'grad'|'ms'|'s'|'hz'|'khz');