package smpl.syntax.ast;

import smpl.exceptions.VisitException;

import smpl.syntax.ast.core.Exp;

import smpl.semantics.Visitor;

public class ExpPow extends Exp {

    Exp exp1, pow;

    public ExpPow(Exp e1, Exp v) {
        exp1 = e1;
        pow = v;
    }

    public Exp getExp() {
        return exp1;
    }

    public Exp getPower() {
        return pow;
    }

    public <S, T> T visit(Visitor<S,T> v, S arg) throws VisitException {
        return v.visitExpPow(this, arg);
    }

    public String toString() {
        return exp1.toString() + " ^ " + pow.toString();
    }
}

