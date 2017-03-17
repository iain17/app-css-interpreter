#!/bin/bash
alias antlr4='java -jar /usr/local/lib/antlr-4.6-complete.jar'
alias grun='java org.antlr.v4.gui.TestRig'

rm *.java
rm *.class

antlr4 ICSS.g4
javac *.java
grun ICSS rules -gui example.icss
