
//----------------------------------------------------
// The following code was generated by CUP v0.11a beta 20060608
// Wed Dec 25 17:43:41 EST 2019
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
  * @version Wed Dec 25 17:43:41 EST 2019
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
    "\000\041\000\002\002\003\000\002\002\004\000\002\003" +
    "\004\000\002\003\003\000\002\004\003\000\002\004\003" +
    "\000\002\005\005\000\002\006\003\000\002\015\005\000" +
    "\002\015\005\000\002\015\003\000\002\013\004\000\002" +
    "\013\003\000\002\012\005\000\002\012\005\000\002\012" +
    "\003\000\002\007\005\000\002\007\005\000\002\007\005" +
    "\000\002\007\006\000\002\007\003\000\002\010\005\000" +
    "\002\010\003\000\002\010\003\000\002\016\003\000\002" +
    "\016\003\000\002\011\003\000\002\011\003\000\002\011" +
    "\003\000\002\011\005\000\002\014\003\000\002\014\003" +
    "\000\002\017\002" });

  /** Access to production table. */
  public short[][] production_table() {return _production_table;}

  /** Parse-action table. */
  protected static final short[][] _action_table = 
    unpackFromStrings(new String[] {
    "\000\060\000\020\004\012\016\010\017\006\020\025\021" +
    "\023\022\011\023\022\001\002\000\034\002\ufff5\004\ufff5" +
    "\005\ufff5\006\053\007\054\014\ufff5\015\ufff5\016\ufff5\017" +
    "\ufff5\020\ufff5\021\ufff5\022\ufff5\023\ufff5\001\002\000\030" +
    "\002\ufffa\004\ufffa\005\ufffa\014\057\015\060\016\ufffa\017" +
    "\ufffa\020\ufffa\021\ufffa\022\ufffa\023\ufffa\001\002\000\044" +
    "\002\uffe7\004\uffe7\005\uffe7\006\uffe7\007\uffe7\010\uffe7\011" +
    "\uffe7\012\uffe7\013\uffe7\014\uffe7\015\uffe7\016\uffe7\017\uffe7" +
    "\020\uffe7\021\uffe7\022\uffe7\023\uffe7\001\002\000\022\002" +
    "\ufffd\004\ufffd\016\ufffd\017\ufffd\020\ufffd\021\ufffd\022\ufffd" +
    "\023\ufffd\001\002\000\016\004\012\017\006\020\031\021" +
    "\023\022\011\023\022\001\002\000\044\002\uffe9\004\uffe9" +
    "\005\uffe9\006\uffe9\007\uffe9\010\uffe9\011\uffe9\012\uffe9\013" +
    "\uffe9\014\uffe9\015\uffe9\016\uffe9\017\uffe9\020\uffe9\021\uffe9" +
    "\022\uffe9\023\uffe9\001\002\000\022\004\012\007\047\016" +
    "\010\017\006\020\031\021\023\022\011\023\022\001\002" +
    "\000\004\002\046\001\002\000\044\002\uffeb\004\uffeb\005" +
    "\uffeb\006\uffeb\007\uffeb\010\uffeb\011\uffeb\012\uffeb\013\uffeb" +
    "\014\uffeb\015\uffeb\016\uffeb\017\uffeb\020\uffeb\021\uffeb\022" +
    "\uffeb\023\uffeb\001\002\000\030\002\ufff7\004\ufff7\005\ufff7" +
    "\014\ufff7\015\ufff7\016\ufff7\017\ufff7\020\ufff7\021\ufff7\022" +
    "\ufff7\023\ufff7\001\002\000\022\002\ufffc\004\ufffc\016\ufffc" +
    "\017\ufffc\020\ufffc\021\ufffc\022\ufffc\023\ufffc\001\002\000" +
    "\044\002\uffed\004\uffed\005\uffed\006\uffed\007\uffed\010\uffed" +
    "\011\uffed\012\uffed\013\042\014\uffed\015\uffed\016\uffed\017" +
    "\uffed\020\uffed\021\uffed\022\uffed\023\uffed\001\002\000\042" +
    "\002\ufff2\004\ufff2\005\ufff2\006\ufff2\007\ufff2\010\034\011" +
    "\035\012\033\014\ufff2\015\ufff2\016\ufff2\017\ufff2\020\ufff2" +
    "\021\ufff2\022\ufff2\023\ufff2\001\002\000\044\002\uffea\004" +
    "\uffea\005\uffea\006\uffea\007\uffea\010\uffea\011\uffea\012\uffea" +
    "\013\uffea\014\uffea\015\uffea\016\uffea\017\uffea\020\uffea\021" +
    "\uffea\022\uffea\023\uffea\001\002\000\044\002\uffe8\004\uffe8" +
    "\005\uffe8\006\uffe8\007\uffe8\010\uffe8\011\uffe8\012\uffe8\013" +
    "\uffe8\014\uffe8\015\uffe8\016\uffe8\017\uffe8\020\uffe8\021\uffe8" +
    "\022\uffe8\023\uffe8\001\002\000\044\002\uffe6\004\uffe6\005" +
    "\uffe6\006\uffe6\007\uffe6\010\uffe6\011\uffe6\012\uffe6\013\uffe6" +
    "\014\uffe6\015\uffe6\016\uffe6\017\uffe6\020\uffe6\021\uffe6\022" +
    "\uffe6\023\uffe6\001\002\000\022\002\ufffe\004\ufffe\016\ufffe" +
    "\017\ufffe\020\ufffe\021\ufffe\022\ufffe\023\ufffe\001\002\000" +
    "\044\002\uffe5\004\uffe5\006\uffe5\007\uffe5\010\uffe5\011\uffe5" +
    "\012\uffe5\013\uffe5\014\uffe5\015\uffe5\016\uffe5\017\uffe5\020" +
    "\uffe5\021\uffe5\022\uffe5\023\uffe5\025\030\001\002\000\022" +
    "\002\001\004\012\016\010\017\006\020\025\021\023\022" +
    "\011\023\022\001\002\000\022\002\uffff\004\uffff\016\uffff" +
    "\017\uffff\020\uffff\021\uffff\022\uffff\023\uffff\001\002\000" +
    "\020\004\012\016\010\017\006\020\031\021\023\022\011" +
    "\023\022\001\002\000\044\002\uffe5\004\uffe5\005\uffe5\006" +
    "\uffe5\007\uffe5\010\uffe5\011\uffe5\012\uffe5\013\uffe5\014\uffe5" +
    "\015\uffe5\016\uffe5\017\uffe5\020\uffe5\021\uffe5\022\uffe5\023" +
    "\uffe5\001\002\000\022\002\ufffb\004\ufffb\016\ufffb\017\ufffb" +
    "\020\ufffb\021\ufffb\022\ufffb\023\ufffb\001\002\000\016\004" +
    "\037\017\006\020\031\021\023\022\011\023\022\001\002" +
    "\000\016\004\037\017\006\020\031\021\023\022\011\023" +
    "\022\001\002\000\016\004\037\017\006\020\031\021\023" +
    "\022\011\023\022\001\002\000\044\002\ufff0\004\ufff0\005" +
    "\ufff0\006\ufff0\007\ufff0\010\ufff0\011\ufff0\012\ufff0\013\042" +
    "\014\ufff0\015\ufff0\016\ufff0\017\ufff0\020\ufff0\021\ufff0\022" +
    "\ufff0\023\ufff0\001\002\000\020\004\012\016\010\017\006" +
    "\020\031\021\023\022\011\023\022\001\002\000\004\005" +
    "\041\001\002\000\044\002\uffe4\004\uffe4\005\uffe4\006\uffe4" +
    "\007\uffe4\010\uffe4\011\uffe4\012\uffe4\013\uffe4\014\uffe4\015" +
    "\uffe4\016\uffe4\017\uffe4\020\uffe4\021\uffe4\022\uffe4\023\uffe4" +
    "\001\002\000\012\004\037\017\006\020\031\021\023\001" +
    "\002\000\044\002\uffec\004\uffec\005\uffec\006\uffec\007\uffec" +
    "\010\uffec\011\uffec\012\uffec\013\uffec\014\uffec\015\uffec\016" +
    "\uffec\017\uffec\020\uffec\021\uffec\022\uffec\023\uffec\001\002" +
    "\000\044\002\ufff1\004\ufff1\005\ufff1\006\ufff1\007\ufff1\010" +
    "\ufff1\011\ufff1\012\ufff1\013\042\014\ufff1\015\ufff1\016\ufff1" +
    "\017\ufff1\020\ufff1\021\ufff1\022\ufff1\023\ufff1\001\002\000" +
    "\044\002\uffef\004\uffef\005\uffef\006\uffef\007\uffef\010\uffef" +
    "\011\uffef\012\uffef\013\042\014\uffef\015\uffef\016\uffef\017" +
    "\uffef\020\uffef\021\uffef\022\uffef\023\uffef\001\002\000\004" +
    "\002\000\001\002\000\016\004\037\017\006\020\031\021" +
    "\023\022\011\023\022\001\002\000\006\005\051\013\042" +
    "\001\002\000\042\002\uffee\004\uffee\005\uffee\006\uffee\007" +
    "\uffee\010\uffee\011\uffee\012\uffee\014\uffee\015\uffee\016\uffee" +
    "\017\uffee\020\uffee\021\uffee\022\uffee\023\uffee\001\002\000" +
    "\034\002\ufff6\004\ufff6\005\ufff6\006\053\007\054\014\ufff6" +
    "\015\ufff6\016\ufff6\017\ufff6\020\ufff6\021\ufff6\022\ufff6\023" +
    "\ufff6\001\002\000\016\004\012\017\006\020\031\021\023" +
    "\022\011\023\022\001\002\000\016\004\012\017\006\020" +
    "\031\021\023\022\011\023\022\001\002\000\042\002\ufff3" +
    "\004\ufff3\005\ufff3\006\ufff3\007\ufff3\010\034\011\035\012" +
    "\033\014\ufff3\015\ufff3\016\ufff3\017\ufff3\020\ufff3\021\ufff3" +
    "\022\ufff3\023\ufff3\001\002\000\042\002\ufff4\004\ufff4\005" +
    "\ufff4\006\ufff4\007\ufff4\010\034\011\035\012\033\014\ufff4" +
    "\015\ufff4\016\ufff4\017\ufff4\020\ufff4\021\ufff4\022\ufff4\023" +
    "\ufff4\001\002\000\020\004\012\016\010\017\006\020\031" +
    "\021\023\022\011\023\022\001\002\000\020\004\012\016" +
    "\010\017\006\020\031\021\023\022\011\023\022\001\002" +
    "\000\030\002\ufff8\004\ufff8\005\ufff8\014\ufff8\015\ufff8\016" +
    "\ufff8\017\ufff8\020\ufff8\021\ufff8\022\ufff8\023\ufff8\001\002" +
    "\000\030\002\ufff9\004\ufff9\005\ufff9\014\ufff9\015\ufff9\016" +
    "\ufff9\017\ufff9\020\ufff9\021\ufff9\022\ufff9\023\ufff9\001\002" +
    "" });

  /** Access to parse-action table. */
  public short[][] action_table() {return _action_table;}

  /** <code>reduce_goto</code> table. */
  protected static final short[][] _reduce_table = 
    unpackFromStrings(new String[] {
    "\000\060\000\032\002\012\003\025\004\023\005\006\006" +
    "\015\007\017\010\016\011\020\012\003\013\014\015\004" +
    "\016\013\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\014\007\017\010\016" +
    "\011\020\012\051\016\013\001\001\000\002\001\001\000" +
    "\022\006\037\007\017\010\016\011\020\012\003\013\014" +
    "\015\004\016\013\001\001\000\002\001\001\000\002\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\026" +
    "\004\026\005\006\006\015\007\017\010\016\011\020\012" +
    "\003\013\014\015\004\016\013\001\001\000\002\001\001" +
    "\000\022\006\031\007\017\010\016\011\020\012\003\013" +
    "\014\015\004\016\013\001\001\000\002\001\001\000\002" +
    "\001\001\000\010\010\044\011\020\016\013\001\001\000" +
    "\010\010\043\011\020\016\013\001\001\000\010\010\035" +
    "\011\020\016\013\001\001\000\002\001\001\000\022\006" +
    "\037\007\017\010\016\011\020\012\003\013\014\015\004" +
    "\016\013\001\001\000\002\001\001\000\002\001\001\000" +
    "\004\011\042\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\010\010\047\011" +
    "\020\016\013\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\012\007\055\010\016\011\020\016" +
    "\013\001\001\000\012\007\054\010\016\011\020\016\013" +
    "\001\001\000\002\001\001\000\002\001\001\000\016\007" +
    "\017\010\016\011\020\012\003\013\061\016\013\001\001" +
    "\000\016\007\017\010\016\011\020\012\003\013\060\016" +
    "\013\001\001\000\002\001\001\000\002\001\001" });

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
          case 32: // empty ::= 
            {
              Object RESULT =null;

              CUP$SMPLParser$result = parser.getSymbolFactory().newSymbol("empty",13, ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.peek()), ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.peek()), RESULT);
            }
          return CUP$SMPLParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 31: // relsign ::= ASSIGN 
            {
              String RESULT =null;
		int signleft = ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.peek()).left;
		int signright = ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.peek()).right;
		String sign = (String)((java_cup.runtime.Symbol) CUP$SMPLParser$stack.peek()).value;
		 RESULT = sign; 
              CUP$SMPLParser$result = parser.getSymbolFactory().newSymbol("relsign",10, ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.peek()), ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.peek()), RESULT);
            }
          return CUP$SMPLParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 30: // relsign ::= RELOP 
            {
              String RESULT =null;
		int signleft = ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.peek()).left;
		int signright = ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.peek()).right;
		String sign = (String)((java_cup.runtime.Symbol) CUP$SMPLParser$stack.peek()).value;
		 RESULT = sign; 
              CUP$SMPLParser$result = parser.getSymbolFactory().newSymbol("relsign",10, ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.peek()), ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.peek()), RESULT);
            }
          return CUP$SMPLParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 29: // value ::= LPAREN expression RPAREN 
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
          case 28: // value ::= VAR 
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
          case 27: // value ::= REAL 
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
          case 26: // value ::= INT 
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
          case 25: // bool ::= FALSE 
            {
              Exp RESULT =null;
		int fleft = ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.peek()).left;
		int fright = ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.peek()).right;
		Boolean f = (Boolean)((java_cup.runtime.Symbol) CUP$SMPLParser$stack.peek()).value;
		 RESULT = new ExpBool(f); 
              CUP$SMPLParser$result = parser.getSymbolFactory().newSymbol("bool",12, ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.peek()), ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.peek()), RESULT);
            }
          return CUP$SMPLParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 24: // bool ::= TRUE 
            {
              Exp RESULT =null;
		int tleft = ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.peek()).left;
		int tright = ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.peek()).right;
		Boolean t = (Boolean)((java_cup.runtime.Symbol) CUP$SMPLParser$stack.peek()).value;
		 RESULT = new ExpBool(t); 
              CUP$SMPLParser$result = parser.getSymbolFactory().newSymbol("bool",12, ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.peek()), ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.peek()), RESULT);
            }
          return CUP$SMPLParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 23: // factor ::= value 
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
          case 22: // factor ::= bool 
            {
              Exp RESULT =null;
		int bleft = ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.peek()).left;
		int bright = ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.peek()).right;
		Exp b = (Exp)((java_cup.runtime.Symbol) CUP$SMPLParser$stack.peek()).value;
		 RESULT = b; 
              CUP$SMPLParser$result = parser.getSymbolFactory().newSymbol("factor",6, ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.peek()), ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.peek()), RESULT);
            }
          return CUP$SMPLParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 21: // factor ::= factor POWER value 
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
          case 20: // term ::= factor 
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
          case 19: // term ::= LPAREN MINUS factor RPAREN 
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
          case 18: // term ::= term MOD factor 
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
          case 17: // term ::= term DIV factor 
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
          case 16: // term ::= term MUL factor 
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
          case 15: // arithExp ::= term 
            {
              Exp RESULT =null;
		int tleft = ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.peek()).left;
		int tright = ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.peek()).right;
		Exp t = (Exp)((java_cup.runtime.Symbol) CUP$SMPLParser$stack.peek()).value;
		 RESULT = t; 
              CUP$SMPLParser$result = parser.getSymbolFactory().newSymbol("arithExp",8, ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.peek()), ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.peek()), RESULT);
            }
          return CUP$SMPLParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 14: // arithExp ::= arithExp MINUS term 
            {
              Exp RESULT =null;
		int eleft = ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.elementAt(CUP$SMPLParser$top-2)).left;
		int eright = ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.elementAt(CUP$SMPLParser$top-2)).right;
		Exp e = (Exp)((java_cup.runtime.Symbol) CUP$SMPLParser$stack.elementAt(CUP$SMPLParser$top-2)).value;
		int tleft = ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.peek()).left;
		int tright = ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.peek()).right;
		Exp t = (Exp)((java_cup.runtime.Symbol) CUP$SMPLParser$stack.peek()).value;
		
					RESULT = new ExpSub(e, t); 
              CUP$SMPLParser$result = parser.getSymbolFactory().newSymbol("arithExp",8, ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.elementAt(CUP$SMPLParser$top-2)), ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.peek()), RESULT);
            }
          return CUP$SMPLParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 13: // arithExp ::= arithExp PLUS term 
            {
              Exp RESULT =null;
		int eleft = ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.elementAt(CUP$SMPLParser$top-2)).left;
		int eright = ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.elementAt(CUP$SMPLParser$top-2)).right;
		Exp e = (Exp)((java_cup.runtime.Symbol) CUP$SMPLParser$stack.elementAt(CUP$SMPLParser$top-2)).value;
		int tleft = ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.peek()).left;
		int tright = ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.peek()).right;
		Exp t = (Exp)((java_cup.runtime.Symbol) CUP$SMPLParser$stack.peek()).value;
		
					RESULT = new ExpAdd(e, t); 
              CUP$SMPLParser$result = parser.getSymbolFactory().newSymbol("arithExp",8, ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.elementAt(CUP$SMPLParser$top-2)), ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.peek()), RESULT);
            }
          return CUP$SMPLParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 12: // relops ::= arithExp 
            {
              Exp RESULT =null;
		int aeleft = ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.peek()).left;
		int aeright = ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.peek()).right;
		Exp ae = (Exp)((java_cup.runtime.Symbol) CUP$SMPLParser$stack.peek()).value;
		 RESULT = ae; 
              CUP$SMPLParser$result = parser.getSymbolFactory().newSymbol("relops",9, ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.peek()), ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.peek()), RESULT);
            }
          return CUP$SMPLParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 11: // relops ::= NOT arithExp 
            {
              Exp RESULT =null;
		int aeleft = ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.peek()).left;
		int aeright = ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.peek()).right;
		Exp ae = (Exp)((java_cup.runtime.Symbol) CUP$SMPLParser$stack.peek()).value;
		 RESULT = new ExpNot(ae); 
              CUP$SMPLParser$result = parser.getSymbolFactory().newSymbol("relops",9, ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.elementAt(CUP$SMPLParser$top-1)), ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.peek()), RESULT);
            }
          return CUP$SMPLParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 10: // logops ::= relops 
            {
              Exp RESULT =null;
		int rleft = ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.peek()).left;
		int rright = ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.peek()).right;
		Exp r = (Exp)((java_cup.runtime.Symbol) CUP$SMPLParser$stack.peek()).value;
		 RESULT = r; 
              CUP$SMPLParser$result = parser.getSymbolFactory().newSymbol("logops",11, ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.peek()), ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.peek()), RESULT);
            }
          return CUP$SMPLParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 9: // logops ::= logops OR relops 
            {
              Exp RESULT =null;
		int lleft = ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.elementAt(CUP$SMPLParser$top-2)).left;
		int lright = ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.elementAt(CUP$SMPLParser$top-2)).right;
		Exp l = (Exp)((java_cup.runtime.Symbol) CUP$SMPLParser$stack.elementAt(CUP$SMPLParser$top-2)).value;
		int rleft = ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.peek()).left;
		int rright = ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.peek()).right;
		Exp r = (Exp)((java_cup.runtime.Symbol) CUP$SMPLParser$stack.peek()).value;
		 RESULT = new ExpOr(l, r); 
              CUP$SMPLParser$result = parser.getSymbolFactory().newSymbol("logops",11, ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.elementAt(CUP$SMPLParser$top-2)), ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.peek()), RESULT);
            }
          return CUP$SMPLParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 8: // logops ::= logops AND relops 
            {
              Exp RESULT =null;
		int lleft = ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.elementAt(CUP$SMPLParser$top-2)).left;
		int lright = ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.elementAt(CUP$SMPLParser$top-2)).right;
		Exp l = (Exp)((java_cup.runtime.Symbol) CUP$SMPLParser$stack.elementAt(CUP$SMPLParser$top-2)).value;
		int rleft = ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.peek()).left;
		int rright = ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.peek()).right;
		Exp r = (Exp)((java_cup.runtime.Symbol) CUP$SMPLParser$stack.peek()).value;
		 RESULT = new ExpAnd(l, r); 
              CUP$SMPLParser$result = parser.getSymbolFactory().newSymbol("logops",11, ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.elementAt(CUP$SMPLParser$top-2)), ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.peek()), RESULT);
            }
          return CUP$SMPLParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 7: // expression ::= logops 
            {
              Exp RESULT =null;
		int lleft = ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.peek()).left;
		int lright = ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.peek()).right;
		Exp l = (Exp)((java_cup.runtime.Symbol) CUP$SMPLParser$stack.peek()).value;
		 RESULT = l; 
              CUP$SMPLParser$result = parser.getSymbolFactory().newSymbol("expression",4, ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.peek()), ((java_cup.runtime.Symbol)CUP$SMPLParser$stack.peek()), RESULT);
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

