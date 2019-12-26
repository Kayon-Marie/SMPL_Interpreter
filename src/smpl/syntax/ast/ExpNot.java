package smpl.syntax.ast;

import smpl.exceptions.VisitException;
import smpl.semantics.Visitor;
import smpl.syntax.ast.core.Exp;

public class ExpNot extends Exp {

    Exp exp;

    public ExpNot(Exp exp) {
        this.exp = exp;
    }

    public Exp getExp() {
        return this.exp;
    }

    @Override
    public <S, T> T visit(Visitor<S, T> v, S arg) throws VisitException {
        return v.visitExpNot(this, arg);
    }

    @Override
    public String toString() {
        return "not " + exp.toString();
    }

}