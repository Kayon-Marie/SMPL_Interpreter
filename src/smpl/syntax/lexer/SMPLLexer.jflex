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

num = [0-9]

true = "#t"
false = "#f"

real = {num}*\.{num} | {num}+\.{num}*

// relational operators - excluding "=" AKA sym.ASSIGN
rel_op = "<"|"<="|">"|">="|"!="

%%

<YYINITIAL>	{nl}	{//skip newline, but reset char counter
			 yychar = 0;
			}
<YYINITIAL>	{ws}	{
			 // skip whitespace
			}


<YYINITIAL> ","	{return new Symbol(sym.COMMA);}
	
			
// Relational and Logical operators
<YYINITIAL> {rel_op} {return new Symbol(sym.RELOP, yytext());}
<YYINITIAL>	"="		{return new Symbol(sym.ASSIGN, yytext());} // also used as rel. op
<YYINITIAL> "and"	{return new Symbol(sym.AND);}
<YYINITIAL> "or"	{return new Symbol(sym.OR);}
<YYINITIAL> "not"	{return new Symbol(sym.NOT);}

//Bitwise operators
<YYINITIAL> "&"	{return new Symbol(sym.BAND);}
<YYINITIAL> "|"	{return new Symbol(sym.BOR);}
<YYINITIAL> "~"	{return new Symbol(sym.NEG);}



// arithmetic operators
<YYINITIAL>	"+"	{return new Symbol(sym.PLUS);}
<YYINITIAL>	"-"	{return new Symbol(sym.MINUS);}
<YYINITIAL>	"*"	{return new Symbol(sym.MUL);}
<YYINITIAL>	"/"	{return new Symbol(sym.DIV);}
<YYINITIAL>	"%"	{return new Symbol(sym.MOD);}
<YYINITIAL> "^" {return new Symbol(sym.POWER);}

// special symbols
<YYINITIAL>	":=" {return new Symbol(sym.ASSIGN, yytext());}
<YYINITIAL>	"("	{return new Symbol(sym.LPAREN);}
<YYINITIAL>	")"	{return new Symbol(sym.RPAREN);}
<YYINITIAL> ";" {return new Symbol(sym.SEMI); }

// keywords
<YYINITIAL> "def" {return new Symbol(sym.DEF);}

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

<YYINITIAL>   "#b"[01]+ {
			// BINARY
			String i = yytext().substring(2);
			return new Symbol(sym.INT,
				 Integer.parseInt(i, 2));
		}

<YYINITIAL>   "#x"{alphanum}+ {
			// HEX
			String i = yytext().substring(2);
			return new Symbol(sym.INT,
				 Integer.parseInt(i,16));
		}

// Strings and Chars	
<YYINITIAL>    {alpha}{alphanum}* {
	       // VAR
	       return new Symbol(sym.VAR, yytext());
		}

// Boolean
<YYINITIAL> {true} 		{return new Symbol(sym.TRUE, new Boolean(true));}
<YYINITIAL> {false} 	{return new Symbol(sym.FALSE, new Boolean(false));}


// error situation
<YYINITIAL>   [^]		{ 
	       String msg = String.format("Unrecognised Token: %s", yytext());
	       throw new TokenException(msg);
	       }