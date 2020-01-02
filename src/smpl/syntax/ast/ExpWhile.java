package smpl.syntax.ast;

import smpl.exceptions.VisitException;

import smpl.syntax.ast.core.Exp;

import smpl.semantics.Visitor;

public class ExpWhile extends Exp {

    Exp cond, body;

    public ExpWhile(Exp cond, Exp body) {
        this.cond = cond;
        this.body = body;
    }

    public Exp getCond(){
        return cond;
    }

    public Exp getBody(){
        return body;
    }


    public <S, T> T visit(Visitor<S,T> v, S arg) throws VisitException {
	    return v.visitExpWhile(this, arg);
    }

  public String toString() {
    return "while("+this.cond.toString() + ") " + this.body.toString();
  }
}

