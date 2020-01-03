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
    StringBuffer string = new StringBuffer();

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

char = "#c"{alpha}
unicode = [a-zA-Z0-9]

nil = "#e"

real = {num}*\.{num} | {num}+\.{num}*

// relational operators - excluding "=" AKA sym.ASSIGN
rel_op = "<"|"<="|">"|">="|"!="|"="

// error handling
// special cases to permit the non use of spaces
start_symbol = [^\,\(\[\{\s]
end_symbol = [^\;\)\]\}]

%state STRING

%%

<YYINITIAL>	{nl}	{//skip newline, but reset char counter
			 yychar = 0;
			}
<YYINITIAL>	{ws}	{
			 // skip whitespace
			}
	

// Iteration operators
<YYINITIAL> "for" 	   {return new Symbol(sym.FOR);}
<YYINITIAL> "while"    {return new Symbol(sym.WHILE);}
<YYINITIAL> "repeat"   {return new Symbol(sym.REPEAT);}

// Relational and Logical operators
<YYINITIAL> {rel_op} {return new Symbol(sym.RELOP, yytext());}
<YYINITIAL> "and"	 {return new Symbol(sym.AND);}
<YYINITIAL> "or"	 {return new Symbol(sym.OR);}
<YYINITIAL> "not"	 {return new Symbol(sym.NOT);}

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

// keywords
<YYINITIAL> "def"  {return new Symbol(sym.DEF);}
<YYINITIAL> "proc" {return new Symbol(sym.PROC);}
<YYINITIAL> "let"  {return new Symbol(sym.LET);}


// Special symbols
<YYINITIAL>	":=" {return new Symbol(sym.ASSIGN, yytext());}
<YYINITIAL>	"("	{return new Symbol(sym.LPAREN);}
<YYINITIAL>	")"	{return new Symbol(sym.RPAREN);}
<YYINITIAL>	"{"	{return new Symbol(sym.LBRACE);}
<YYINITIAL>	"}"	{return new Symbol(sym.RBRACE);}
<YYINITIAL> "," {return new Symbol(sym.COMMA);}
<YYINITIAL> ":" {return new Symbol(sym.COLON);}
<YYINITIAL> ";" {return new Symbol(sym.SEMI);}
<YYINITIAL> "." {return new Symbol(sym.PERIOD);}
<YYINITIAL> "[" {return new Symbol(sym.LSQUARE); }
<YYINITIAL> "]" {return new Symbol(sym.RSQUARE); }

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

// Characters
<YYINITIAL> {char} {
			// ChARACTER
			return new Symbol(sym.CHAR, yycharat(2));
		}

<YYINITIAL> "#u"{unicode}+ {
			//Unicode
			return new Symbol(sym.UNI, yytext().substring(2));
		}

// Newline Character Representation
<YYINITIAL> "#c"\\n {
			//SPECIAL CHARACTERS
			return new Symbol(sym.CHAR, '\n');
		}

// Tab Character Representation
<YYINITIAL> "#c"\\t {
			//SPECIAL CHARACTERS
			return new Symbol(sym.CHAR, '\t');
		}

// Newline Character Representation
<YYINITIAL> "#c"\\ {
			//SPECIAL CHARACTERS
			return new Symbol(sym.CHAR, '\\');
		}

<YYINITIAL>  \"   	{string.setLength(0); yybegin(STRING);}

// String
<STRING> {
	\"				{yybegin(YYINITIAL);
						return new Symbol(sym.STRING, string.toString());
					}
	
	[^\n\r\"\\]+	{string.append( yytext() );}

	\\t				{string.append('\t');}

	\\n				{string.append('\n');}

	\\\"			{string.append('\"');}

	\\				{string.append('\\');}
}

// Boolean
<YYINITIAL> {true} 		{return new Symbol(sym.TRUE, new Boolean(true));}
<YYINITIAL> {false} 	{return new Symbol(sym.FALSE, new Boolean(false));}

// Nil (empty List)
<YYINITIAL> {nil}	{return new Symbol(sym.NIL);}

// [^\"\(\s]\S+[^\)]$
// [^\,\(\[\{\s]\S+[^\)\]\}]$
// error situation
<YYINITIAL>   {start_symbol}\S+{end_symbol}$		{ 
	       String msg = String.format("Unrecognised Token: %s", yytext());
	       throw new TokenException(msg);
	       }