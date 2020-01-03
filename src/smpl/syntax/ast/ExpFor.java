package smpl.syntax.ast;

import smpl.exceptions.VisitException;

import smpl.syntax.ast.core.Exp;

import smpl.semantics.Visitor;

public class ExpFor extends Exp {

    Exp size, body;
    String var;

    public ExpFor(String var, Exp size, Exp body) {
        this.var = var;
        this.size = size;
        this.body = body;
    }

    public String getVar(){
      return var;
    }

    public Exp getSize(){
        return size;
    }

    public Exp getBody(){
        return body;
    }

    public <S, T> T visit(Visitor<S,T> v, S arg) throws VisitException {
	    return v.visitExpFor(this, arg);
    }

  public String toString() {
    return "for("+this.size.toString() + ") " + this.body.toString();
  }
}

