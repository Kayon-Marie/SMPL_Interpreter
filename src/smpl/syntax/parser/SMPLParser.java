
//----------------------------------------------------
// The following code was generated by CUP v0.11a beta 20060608
// Thu Dec 19 19:06:46 EST 2019
//----------------------------------------------------

package smpl.syntax.parser;

import java_cup.runtime.*;
import java.io.*;
import java.util.*;
import smpl.syntax.lexer.SMPLLexer;
import smpl.syntax.ast.core.Exp;
import smpl.syntax.ast.core.SMPLProgram;
import smpl.syntax.ast.*;

/** CUP v0.11a beta 20060608 generated parser.
  * @version Thu Dec 19 19:06:46 EST 2019
  */
public class SMPLParser extends java_cup.runtime.lr_parser {

  /** Default constructor. */
  public SMPLParser() {super();}

  /** Constructor which sets the default scanner. */
  public SMPLParser(java_cup.runtime.Scanner s) {super(s);}

  /** Constructor which sets the default scanner. */
  public SMPLParser(java_cup.runtime.Scanner s, java_cup.runtime.SymbolFactory sf) {super(s,sf);}

  /** Production table. */
  protected static final short _production_table[][] = 
    unpackFromStrings(new String[] {
    "\000\030\000\002\002\003\000\002\002\004\000\002\003" +
    "\004\000\002\003\003\000\002\004\003\000\002\004\003" +
    "\000\002\005\005\000\002\006\005\000\002\006\005\000" +
    "\002\006\003\000\002\007\005\000\002\007\005\000\002" +
    "\007\005\000\002\007\006\000\002\007\003\000\002\010" +
    "\005\000\002\010\003\000\002\010\003\000\002\010\003" +
    "\000\002\011\003\000\002\011\003\000\002\011\003\000" +
    "\002\011\005\000\002\012\002" });

  /** Access to production table. */
  public short[][] production_table() {return _production_table;}

  /** Parse-action table. */
  protected static final short[][] _action_table = 
    unpackFromStrings(new String[] {
    "\000\046\000\016\004\021\015\004\016\013\017\017\020" +
    "\010\021\014\001\002\000\036\002\uffee\004\uffee\005\uffee" +
    "\006\uffee\007\uffee\010\uffee\011\uffee\012\uffee\014\uffee\015" +
    "\uffee\016\uffee\017\uffee\020\uffee\021\uffee\001\002\000\020" +
    "\002\ufffd\004\ufffd\015\ufffd\016\ufffd\017\ufffd\020\ufffd\021" +
    "\ufffd\001\002\000\020\002\ufffe\004\ufffe\015\ufffe\016\ufffe" +
    "\017\ufffe\020\ufffe\021\ufffe\001\002\000\034\002\ufff8\004" +
    "\ufff8\005\ufff8\006\ufff8\007\ufff8\010\032\011\033\012\031" +
    "\015\ufff8\016\ufff8\017\ufff8\020\ufff8\021\ufff8\001\002\000" +
    "\036\002\ufff1\004\ufff1\005\ufff1\006\ufff1\007\ufff1\010\ufff1" +
    "\011\ufff1\012\ufff1\014\ufff1\015\ufff1\016\ufff1\017\ufff1\020" +
    "\ufff1\021\ufff1\001\002\000\004\002\050\001\002\000\020" +
    "\002\001\004\021\015\004\016\013\017\017\020\010\021" +
    "\014\001\002\000\036\002\uffec\004\uffec\006\uffec\007\uffec" +
    "\010\uffec\011\uffec\012\uffec\013\045\014\uffec\015\uffec\016" +
    "\uffec\017\uffec\020\uffec\021\uffec\001\002\000\036\002\ufff0" +
    "\004\ufff0\005\ufff0\006\ufff0\007\ufff0\010\ufff0\011\ufff0\012" +
    "\ufff0\014\ufff0\015\ufff0\016\ufff0\017\ufff0\020\ufff0\021\ufff0" +
    "\001\002\000\024\002\ufffc\004\ufffc\006\026\007\027\015" +
    "\ufffc\016\ufffc\017\ufffc\020\ufffc\021\ufffc\001\002\000\036" +
    "\002\ufff3\004\ufff3\005\ufff3\006\ufff3\007\ufff3\010\ufff3\011" +
    "\ufff3\012\ufff3\014\036\015\ufff3\016\ufff3\017\ufff3\020\ufff3" +
    "\021\ufff3\001\002\000\036\002\uffed\004\uffed\005\uffed\006" +
    "\uffed\007\uffed\010\uffed\011\uffed\012\uffed\014\uffed\015\uffed" +
    "\016\uffed\017\uffed\020\uffed\021\uffed\001\002\000\036\002" +
    "\uffef\004\uffef\005\uffef\006\uffef\007\uffef\010\uffef\011\uffef" +
    "\012\uffef\014\uffef\015\uffef\016\uffef\017\uffef\020\uffef\021" +
    "\uffef\001\002\000\020\004\021\007\022\015\004\016\023" +
    "\017\017\020\010\021\014\001\002\000\016\004\035\015" +
    "\004\016\023\017\017\020\010\021\014\001\002\000\036" +
    "\002\uffec\004\uffec\005\uffec\006\uffec\007\uffec\010\uffec\011" +
    "\uffec\012\uffec\014\uffec\015\uffec\016\uffec\017\uffec\020\uffec" +
    "\021\uffec\001\002\000\010\005\025\006\026\007\027\001" +
    "\002\000\036\002\uffeb\004\uffeb\005\uffeb\006\uffeb\007\uffeb" +
    "\010\uffeb\011\uffeb\012\uffeb\014\uffeb\015\uffeb\016\uffeb\017" +
    "\uffeb\020\uffeb\021\uffeb\001\002\000\016\004\021\015\004" +
    "\016\023\017\017\020\010\021\014\001\002\000\016\004" +
    "\021\015\004\016\023\017\017\020\010\021\014\001\002" +
    "\000\034\002\ufff9\004\ufff9\005\ufff9\006\ufff9\007\ufff9\010" +
    "\032\011\033\012\031\015\ufff9\016\ufff9\017\ufff9\020\ufff9" +
    "\021\ufff9\001\002\000\016\004\035\015\004\016\023\017" +
    "\017\020\010\021\014\001\002\000\016\004\035\015\004" +
    "\016\023\017\017\020\010\021\014\001\002\000\016\004" +
    "\035\015\004\016\023\017\017\020\010\021\014\001\002" +
    "\000\036\002\ufff6\004\ufff6\005\ufff6\006\ufff6\007\ufff6\010" +
    "\ufff6\011\ufff6\012\ufff6\014\036\015\ufff6\016\ufff6\017\ufff6" +
    "\020\ufff6\021\ufff6\001\002\000\016\004\021\015\004\016" +
    "\023\017\017\020\010\021\014\001\002\000\012\004\035" +
    "\015\004\016\023\017\017\001\002\000\036\002\ufff2\004" +
    "\ufff2\005\ufff2\006\ufff2\007\ufff2\010\ufff2\011\ufff2\012\ufff2" +
    "\014\ufff2\015\ufff2\016\ufff2\017\ufff2\020\ufff2\021\ufff2\001" +
    "\002\000\036\002\ufff7\004\ufff7\005\ufff7\006\ufff7\007\ufff7" +
    "\010\ufff7\011\ufff7\012\ufff7\014\036\015\ufff7\016\ufff7\017" +
    "\ufff7\020\ufff7\021\ufff7\001\002\000\036\002\ufff5\004\ufff5" +
    "\005\ufff5\006\ufff5\007\ufff5\010\ufff5\011\ufff5\012\ufff5\014" +
    "\036\015\ufff5\016\ufff5\017\ufff5\020\ufff5\021\ufff5\001\002" +
    "\000\034\002\ufffa\004\ufffa\005\ufffa\006\ufffa\007\ufffa\010" +
    "\032\011\033\012\031\015\ufffa\016\ufffa\017\ufffa\020\ufffa" +
    "\021\ufffa\001\002\000\006\005\044\014\036\001\002\000" +
    "\034\002\ufff4\004\ufff4\005\ufff4\006\ufff4\007\ufff4\010\ufff4" +
    "\011\ufff4\012\ufff4\015\ufff4\016\ufff4\017\ufff4\020\ufff4\021" +
    "\ufff4\001\002\000\016\004\021\015\004\016\023\017\017" +
    "\020\010\021\014\001\002\000\024\002\ufffb\004\ufffb\006" +
    "\026\007\027\015\ufffb\016\ufffb\017\ufffb\020\ufffb\021\ufffb" +
    "\001\002\000\020\002\uffff\004\uffff\015\uffff\016\uffff\017" +
    "\uffff\020\uffff\021\uffff\001\002\000\004\002\000\001\002" +
    "" });

  /** Access to parse-action table. */
  public short[][] action_table() {return _action_table;}

  /** <code>reduce_goto</code> table. */
  protected static final short[][] _reduce_table = 
    unpackFromStrings(new String[] {
    "\000\046\000\022\002\010\003\011\004\005\005\004\006" +
    "\014\007\006\010\015\011\017\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\016\004\046\005\004" +
    "\006\014\007\006\010\015\011\017\001\001\000\002\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\012\006\023\007" +
    "\006\010\015\011\017\001\001\000\006\010\042\011\017" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001\000\010\007\041\010\015\011\017\001\001\000\010" +
    "\007\027\010\015\011\017\001\001\000\002\001\001\000" +
    "\006\010\040\011\017\001\001\000\006\010\037\011\017" +
    "\001\001\000\006\010\033\011\017\001\001\000\002\001" +
    "\001\000\012\006\023\007\006\010\015\011\017\001\001" +
    "\000\004\011\036\001\001\000\002\001\001\000\002\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\012\006\045\007\006\010\015\011" +
    "\017\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001" });

  /** Access to <code>reduce_goto</code> table. */
  public short[][] reduce_table() {return _reduce_table;}

  /** Instance of action encapsulation class. */
  protected CUP$SMPLParser$actions action_obj;

  /** Action encapsulation object initializer. */
  protected void init_actions()
    {
      action_obj = new CUP$SMPLParser$actions(this);
    }

  /** Invoke a user supplied parse action. */
  public java_cup.runtime.Symbol do_action(
    int                        act_num,
    java_cup.runtime.lr_parser parser,
    java.util.Stack            stack,
    int                        top)
    throws java.lang.Exception
  {
    /* call code in generated class */
    return action_obj.CUP$SMPLParser$do_action(act_num, parser, stack, top);
  }

  /** Indicates start state. */
  public int start_state() {return 0;}
  /** Indicates start production. */
  public int start_production() {return 1;}

  /** <code>EOF</code> Symbol index. */
  public int EOF_sym() {return 0;}

  /** <code>error</code> Symbol index. */
  public int error_sym() {return 1;}


  /** User initialization code. */
  public void user_init() throws java.lang.Exception
    {

	  
    }

  /** Scan to get the next Symbol. */
  public java_cup.runtime.Symbol scan()
    throws java.lang.Exception
    {

		try {
		    return lexer.next_token();
		} catch (java.io.IOException ioe) {
		    System.out.println("Line " + lexer.getLine() + ", pos " +
				       lexer.getChar() +
				       ": Unrecognised token");
		    System.out.println(ioe.getMessage());
		    throw ioe;
		}
	  
    }


		SMPLLexer lexer;

		public SMPLParser(SMPLLexer l) {
		    // As of CUP v0.11, need to pass Lexer to superclass
		    super(l);
		    lexer = l;
		}

		public void report_error(String message, Object info) {
		    System.err.println(message);
		}

		public void syntax_error(Symbol cur_token) {
		    System.err.print("Line " + lexer.getLine() +
				     " near char " + lexer.getChar() + ": ");
		    report_error("Syntax error", cur_token);
		    System.err.println ("Last token read is " +
					 lexer.getText());
		}
	    
}

/** Cup generated class to encapsulate user supplied action code.*/
class CUP$SMPLParser$actions {
  private final SMPLParser parser;

  /** Constructor */
  CUP$SMPLParser$actions(SMPLParser parser) {
    this.parser = parser;
  }

  /** Method with the actual generated action code. */
  public final java_cup.runtime.Symbol CUP$SMPLParser$do_action(
    int                        CUP$SMPLParser$act_num,
    java_cup.runtime.lr_parser CUP$SMPLParser$parser,
    java.util.Stack            CUP$SMPLParser$stack,
    int                        CUP$SMPLParser$top)
    throws java.lang.Exception
    {
      /* Symbol object for return from actions */
      java_cup.runtime.Symbol CUP$SMPLParser$result;

      /* select the action based on the action number */
      switch (CUP$SMPLParser$act_num)
        {
          /*. . . . . . . . . . . . . . . . . . . .*/
          case 23: // empty ::= 
            {
              Object RESULT =null;

              CUP$SMPLParser$result = parser.getSymbolFactory().newSymbol("empty",8, ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.peek()), ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.peek()), RESULT);
            }
          return CUP$SMPLParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 22: // value ::= LPAREN expression RPAREN 
            {
              Exp RESULT =null;
		int eleft = ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.elementAt(CUP$SMPLParser$top-1)).left;
		int eright = ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.elementAt(CUP$SMPLParser$top-1)).right;
		Exp e = (Exp)((java_cup.runtime.Symbol) CUP$SMPLParser$stack.elementAt(CUP$SMPLParser$top-1)).value;
		 RESULT = e; 
              CUP$SMPLParser$result = parser.getSymbolFactory().newSymbol("value",7, ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.elementAt(CUP$SMPLParser$top-2)), ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.peek()), RESULT);
            }
          return CUP$SMPLParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 21: // value ::= VAR 
            {
              Exp RESULT =null;
		int varleft = ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.peek()).left;
		int varright = ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.peek()).right;
		String var = (String)((java_cup.runtime.Symbol) CUP$SMPLParser$stack.peek()).value;
		 RESULT = new ExpVar(var); 
              CUP$SMPLParser$result = parser.getSymbolFactory().newSymbol("value",7, ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.peek()), ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.peek()), RESULT);
            }
          return CUP$SMPLParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 20: // value ::= REAL 
            {
              Exp RESULT =null;
		int rlitleft = ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.peek()).left;
		int rlitright = ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.peek()).right;
		Double rlit = (Double)((java_cup.runtime.Symbol) CUP$SMPLParser$stack.peek()).value;
		 RESULT = new ExpLit(rlit); 
              CUP$SMPLParser$result = parser.getSymbolFactory().newSymbol("value",7, ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.peek()), ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.peek()), RESULT);
            }
          return CUP$SMPLParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 19: // value ::= INT 
            {
              Exp RESULT =null;
		int ilitleft = ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.peek()).left;
		int ilitright = ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.peek()).right;
		Integer ilit = (Integer)((java_cup.runtime.Symbol) CUP$SMPLParser$stack.peek()).value;
		 RESULT = new ExpLit(ilit); 
              CUP$SMPLParser$result = parser.getSymbolFactory().newSymbol("value",7, ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.peek()), ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.peek()), RESULT);
            }
          return CUP$SMPLParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 18: // factor ::= value 
            {
              Exp RESULT =null;
		int vleft = ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.peek()).left;
		int vright = ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.peek()).right;
		Exp v = (Exp)((java_cup.runtime.Symbol) CUP$SMPLParser$stack.peek()).value;
		 RESULT = v; 
              CUP$SMPLParser$result = parser.getSymbolFactory().newSymbol("factor",6, ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.peek()), ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.peek()), RESULT);
            }
          return CUP$SMPLParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 17: // factor ::= FALSE 
            {
              Exp RESULT =null;
		int fleft = ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.peek()).left;
		int fright = ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.peek()).right;
		Boolean f = (Boolean)((java_cup.runtime.Symbol) CUP$SMPLParser$stack.peek()).value;
		 RESULT = new ExpBool(f); 
              CUP$SMPLParser$result = parser.getSymbolFactory().newSymbol("factor",6, ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.peek()), ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.peek()), RESULT);
            }
          return CUP$SMPLParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 16: // factor ::= TRUE 
            {
              Exp RESULT =null;
		int tleft = ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.peek()).left;
		int tright = ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.peek()).right;
		Boolean t = (Boolean)((java_cup.runtime.Symbol) CUP$SMPLParser$stack.peek()).value;
		 RESULT = new ExpBool(t); 
              CUP$SMPLParser$result = parser.getSymbolFactory().newSymbol("factor",6, ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.peek()), ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.peek()), RESULT);
            }
          return CUP$SMPLParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 15: // factor ::= factor POWER value 
            {
              Exp RESULT =null;
		int fleft = ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.elementAt(CUP$SMPLParser$top-2)).left;
		int fright = ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.elementAt(CUP$SMPLParser$top-2)).right;
		Exp f = (Exp)((java_cup.runtime.Symbol) CUP$SMPLParser$stack.elementAt(CUP$SMPLParser$top-2)).value;
		int vleft = ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.peek()).left;
		int vright = ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.peek()).right;
		Exp v = (Exp)((java_cup.runtime.Symbol) CUP$SMPLParser$stack.peek()).value;
		
				RESULT = new ExpPow(f, v); 
              CUP$SMPLParser$result = parser.getSymbolFactory().newSymbol("factor",6, ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.elementAt(CUP$SMPLParser$top-2)), ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.peek()), RESULT);
            }
          return CUP$SMPLParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 14: // term ::= factor 
            {
              Exp RESULT =null;
		int fleft = ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.peek()).left;
		int fright = ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.peek()).right;
		Exp f = (Exp)((java_cup.runtime.Symbol) CUP$SMPLParser$stack.peek()).value;
		 RESULT = f; 
              CUP$SMPLParser$result = parser.getSymbolFactory().newSymbol("term",5, ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.peek()), ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.peek()), RESULT);
            }
          return CUP$SMPLParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 13: // term ::= LPAREN MINUS factor RPAREN 
            {
              Exp RESULT =null;
		int fleft = ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.elementAt(CUP$SMPLParser$top-1)).left;
		int fright = ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.elementAt(CUP$SMPLParser$top-1)).right;
		Exp f = (Exp)((java_cup.runtime.Symbol) CUP$SMPLParser$stack.elementAt(CUP$SMPLParser$top-1)).value;
		
				RESULT = new ExpNeg(f); 
              CUP$SMPLParser$result = parser.getSymbolFactory().newSymbol("term",5, ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.elementAt(CUP$SMPLParser$top-3)), ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.peek()), RESULT);
            }
          return CUP$SMPLParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 12: // term ::= term MOD factor 
            {
              Exp RESULT =null;
		int tleft = ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.elementAt(CUP$SMPLParser$top-2)).left;
		int tright = ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.elementAt(CUP$SMPLParser$top-2)).right;
		Exp t = (Exp)((java_cup.runtime.Symbol) CUP$SMPLParser$stack.elementAt(CUP$SMPLParser$top-2)).value;
		int fleft = ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.peek()).left;
		int fright = ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.peek()).right;
		Exp f = (Exp)((java_cup.runtime.Symbol) CUP$SMPLParser$stack.peek()).value;
		
				RESULT = new ExpMod(t, f); 
              CUP$SMPLParser$result = parser.getSymbolFactory().newSymbol("term",5, ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.elementAt(CUP$SMPLParser$top-2)), ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.peek()), RESULT);
            }
          return CUP$SMPLParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 11: // term ::= term DIV factor 
            {
              Exp RESULT =null;
		int tleft = ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.elementAt(CUP$SMPLParser$top-2)).left;
		int tright = ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.elementAt(CUP$SMPLParser$top-2)).right;
		Exp t = (Exp)((java_cup.runtime.Symbol) CUP$SMPLParser$stack.elementAt(CUP$SMPLParser$top-2)).value;
		int fleft = ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.peek()).left;
		int fright = ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.peek()).right;
		Exp f = (Exp)((java_cup.runtime.Symbol) CUP$SMPLParser$stack.peek()).value;
		
				RESULT = new ExpDiv(t, f); 
              CUP$SMPLParser$result = parser.getSymbolFactory().newSymbol("term",5, ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.elementAt(CUP$SMPLParser$top-2)), ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.peek()), RESULT);
            }
          return CUP$SMPLParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 10: // term ::= term MUL factor 
            {
              Exp RESULT =null;
		int tleft = ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.elementAt(CUP$SMPLParser$top-2)).left;
		int tright = ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.elementAt(CUP$SMPLParser$top-2)).right;
		Exp t = (Exp)((java_cup.runtime.Symbol) CUP$SMPLParser$stack.elementAt(CUP$SMPLParser$top-2)).value;
		int fleft = ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.peek()).left;
		int fright = ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.peek()).right;
		Exp f = (Exp)((java_cup.runtime.Symbol) CUP$SMPLParser$stack.peek()).value;
		
				RESULT = new ExpMul(t, f); 
              CUP$SMPLParser$result = parser.getSymbolFactory().newSymbol("term",5, ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.elementAt(CUP$SMPLParser$top-2)), ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.peek()), RESULT);
            }
          return CUP$SMPLParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 9: // expression ::= term 
            {
              Exp RESULT =null;
		int tleft = ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.peek()).left;
		int tright = ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.peek()).right;
		Exp t = (Exp)((java_cup.runtime.Symbol) CUP$SMPLParser$stack.peek()).value;
		 RESULT = t; 
              CUP$SMPLParser$result = parser.getSymbolFactory().newSymbol("expression",4, ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.peek()), ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.peek()), RESULT);
            }
          return CUP$SMPLParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 8: // expression ::= expression MINUS term 
            {
              Exp RESULT =null;
		int eleft = ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.elementAt(CUP$SMPLParser$top-2)).left;
		int eright = ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.elementAt(CUP$SMPLParser$top-2)).right;
		Exp e = (Exp)((java_cup.runtime.Symbol) CUP$SMPLParser$stack.elementAt(CUP$SMPLParser$top-2)).value;
		int tleft = ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.peek()).left;
		int tright = ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.peek()).right;
		Exp t = (Exp)((java_cup.runtime.Symbol) CUP$SMPLParser$stack.peek()).value;
		
					RESULT = new ExpSub(e, t); 
              CUP$SMPLParser$result = parser.getSymbolFactory().newSymbol("expression",4, ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.elementAt(CUP$SMPLParser$top-2)), ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.peek()), RESULT);
            }
          return CUP$SMPLParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 7: // expression ::= expression PLUS term 
            {
              Exp RESULT =null;
		int eleft = ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.elementAt(CUP$SMPLParser$top-2)).left;
		int eright = ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.elementAt(CUP$SMPLParser$top-2)).right;
		Exp e = (Exp)((java_cup.runtime.Symbol) CUP$SMPLParser$stack.elementAt(CUP$SMPLParser$top-2)).value;
		int tleft = ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.peek()).left;
		int tright = ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.peek()).right;
		Exp t = (Exp)((java_cup.runtime.Symbol) CUP$SMPLParser$stack.peek()).value;
		
					RESULT = new ExpAdd(e, t); 
              CUP$SMPLParser$result = parser.getSymbolFactory().newSymbol("expression",4, ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.elementAt(CUP$SMPLParser$top-2)), ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.peek()), RESULT);
            }
          return CUP$SMPLParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 6: // definition ::= VAR ASSIGN expression 
            {
              StmtDefinition RESULT =null;
		int vleft = ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.elementAt(CUP$SMPLParser$top-2)).left;
		int vright = ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.elementAt(CUP$SMPLParser$top-2)).right;
		String v = (String)((java_cup.runtime.Symbol) CUP$SMPLParser$stack.elementAt(CUP$SMPLParser$top-2)).value;
		int eleft = ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.peek()).left;
		int eright = ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.peek()).right;
		Exp e = (Exp)((java_cup.runtime.Symbol) CUP$SMPLParser$stack.peek()).value;
		
		   			RESULT = new StmtDefinition(v, e);
				
              CUP$SMPLParser$result = parser.getSymbolFactory().newSymbol("definition",3, ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.elementAt(CUP$SMPLParser$top-2)), ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.peek()), RESULT);
            }
          return CUP$SMPLParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 5: // stmt ::= expression 
            {
              Statement RESULT =null;
		int eleft = ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.peek()).left;
		int eright = ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.peek()).right;
		Exp e = (Exp)((java_cup.runtime.Symbol) CUP$SMPLParser$stack.peek()).value;
		 RESULT = new Statement(e); 
              CUP$SMPLParser$result = parser.getSymbolFactory().newSymbol("stmt",2, ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.peek()), ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.peek()), RESULT);
            }
          return CUP$SMPLParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 4: // stmt ::= definition 
            {
              Statement RESULT =null;
		int dleft = ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.peek()).left;
		int dright = ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.peek()).right;
		StmtDefinition d = (StmtDefinition)((java_cup.runtime.Symbol) CUP$SMPLParser$stack.peek()).value;
		 RESULT = d; 
              CUP$SMPLParser$result = parser.getSymbolFactory().newSymbol("stmt",2, ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.peek()), ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.peek()), RESULT);
            }
          return CUP$SMPLParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 3: // stmtList ::= stmt 
            {
              StmtSequence RESULT =null;
		int sleft = ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.peek()).left;
		int sright = ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.peek()).right;
		Statement s = (Statement)((java_cup.runtime.Symbol) CUP$SMPLParser$stack.peek()).value;
		
					RESULT = new StmtSequence(s);
				
              CUP$SMPLParser$result = parser.getSymbolFactory().newSymbol("stmtList",1, ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.peek()), ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.peek()), RESULT);
            }
          return CUP$SMPLParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 2: // stmtList ::= stmtList stmt 
            {
              StmtSequence RESULT =null;
		int lstleft = ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.elementAt(CUP$SMPLParser$top-1)).left;
		int lstright = ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.elementAt(CUP$SMPLParser$top-1)).right;
		StmtSequence lst = (StmtSequence)((java_cup.runtime.Symbol) CUP$SMPLParser$stack.elementAt(CUP$SMPLParser$top-1)).value;
		int sleft = ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.peek()).left;
		int sright = ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.peek()).right;
		Statement s = (Statement)((java_cup.runtime.Symbol) CUP$SMPLParser$stack.peek()).value;
		
					lst.add(s); 
					RESULT = lst;
				
              CUP$SMPLParser$result = parser.getSymbolFactory().newSymbol("stmtList",1, ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.elementAt(CUP$SMPLParser$top-1)), ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.peek()), RESULT);
            }
          return CUP$SMPLParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 1: // $START ::= program EOF 
            {
              Object RESULT =null;
		int start_valleft = ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.elementAt(CUP$SMPLParser$top-1)).left;
		int start_valright = ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.elementAt(CUP$SMPLParser$top-1)).right;
		SMPLProgram start_val = (SMPLProgram)((java_cup.runtime.Symbol) CUP$SMPLParser$stack.elementAt(CUP$SMPLParser$top-1)).value;
		RESULT = start_val;
              CUP$SMPLParser$result = parser.getSymbolFactory().newSymbol("$START",0, ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.elementAt(CUP$SMPLParser$top-1)), ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.peek()), RESULT);
            }
          /* ACCEPT */
          CUP$SMPLParser$parser.done_parsing();
          return CUP$SMPLParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 0: // program ::= stmtList 
            {
              SMPLProgram RESULT =null;
		int sleft = ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.peek()).left;
		int sright = ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.peek()).right;
		StmtSequence s = (StmtSequence)((java_cup.runtime.Symbol) CUP$SMPLParser$stack.peek()).value;
		 RESULT = new SMPLProgram(s); 
              CUP$SMPLParser$result = parser.getSymbolFactory().newSymbol("program",0, ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.peek()), ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.peek()), RESULT);
            }
          return CUP$SMPLParser$result;

          /* . . . . . .*/
          default:
            throw new Exception(
               "Invalid action number found in internal parse table");

        }
    }
}

