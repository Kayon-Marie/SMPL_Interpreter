package smpl.syntax.lexer;

/* Specification for SMPL tokens */

// user customisations
import java_cup.runtime.*;

import smpl.exceptions.TokenException;

import smpl.syntax.parser.sym;

// Jlex directives
    
%%

%cup
%public

%class SMPLLexer

%type java_cup.runtime.Symbol

%throws TokenException

%eofval{
	return new Symbol(sym.EOF);
%eofval}

%eofclose false

%char
%column
%line

%debug

%{
    public int getChar() {
	return yychar + 1;
    }

    public int getColumn() {
    	return yycolumn + 1;
    }

    public int getLine() {
	return yyline + 1;
    }

    public String getText() {
	return yytext();
    }
%}

nl = [\n\r]

cc = ([\b\f]|{nl})

ws = {cc}|[\t ]

alpha = [a-zA-Z_]

alphanum = {alpha}|[0-9]

special = {nl} | [\t ] | [\\]

num = [0-9]

true = "#t"
false = "#f"

char = "#c"{alpha}

string = \".*\"

real = {num}*\.{num} | {num}+\.{num}*

%%

<YYINITIAL>	{nl}	{//skip newline, but reset char counter
			 yychar = 0;
			}
<YYINITIAL>	{ws}	{
			 // skip whitespace
			}
<YYINITIAL>	"+"	{return new Symbol(sym.PLUS);}
<YYINITIAL>	"-"	{return new Symbol(sym.MINUS);}
<YYINITIAL>	"*"	{return new Symbol(sym.MUL);}
<YYINITIAL>	"/"	{return new Symbol(sym.DIV);}
<YYINITIAL>	"%"	{return new Symbol(sym.MOD);}
<YYINITIAL> "^" {return new Symbol(sym.POWER);}

<YYINITIAL>	"="	{return new Symbol(sym.ASSIGN);}
<YYINITIAL>	"("	{return new Symbol(sym.LPAREN);}
<YYINITIAL>	")"	{return new Symbol(sym.RPAREN);}

// Numerical Values
<YYINITIAL>    {num}+ {
	       // INTEGER
	       return new Symbol(sym.INT, 
				 new Integer(yytext()));
		}

<YYINITIAL>   {real} {
			// REAL
			return new Symbol(sym.REAL,
				 new Double(yytext()));
		}

// Variables	
<YYINITIAL>    {alpha}{alphanum}* {
	       // VAR
	       return new Symbol(sym.VAR, yytext());
		}

// Characters
<YYINITIAL> {char} {
			// ChARACTER
			return new Symbol(sym.CHAR, yytext());
		}

// String
<YYINITIAL> {string} {
			// Strings
			return new Symbol(sym.STRING, yytext());
		}

// Boolean
<YYINITIAL> {true} 		{return new Symbol(sym.TRUE, new Boolean(true));}
<YYINITIAL> {false} 	{return new Symbol(sym.FALSE, new Boolean(false));}

<YYINITIAL>    \S+		{ // error situation
	       String msg = String.format("Unrecognised Token: %s", yytext());
	       throw new TokenException(msg);
	       }