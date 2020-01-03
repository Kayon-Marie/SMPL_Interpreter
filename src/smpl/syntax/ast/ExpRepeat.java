package smpl.syntax.ast;

import smpl.exceptions.VisitException;

import smpl.syntax.ast.core.Exp;

import smpl.semantics.Visitor;

public class ExpRepeat extends Exp {

    Exp size, body;

    public ExpRepeat(Exp size, Exp body) {
        this.size = size;
        this.body = body;
    }

    public Exp getSize(){
        return size;
    }

    public Exp getBody(){
        return body;
    }


    public <S, T> T visit(Visitor<S,T> v, S arg) throws VisitException {
	    return v.visitExpRepeat(this, arg);
    }

  public String toString() {
    return "repeat("+this.size.toString() + ") " + this.body.toString();
  }
}

