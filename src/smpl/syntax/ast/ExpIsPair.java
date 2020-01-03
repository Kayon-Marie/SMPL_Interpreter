package smpl.syntax.ast;

import smpl.exceptions.VisitException;
import smpl.semantics.Visitor;
import smpl.syntax.ast.core.Exp;
import smpl.exceptions.SMPLException;
import smpl.values.SMPLValue;


public class ExpIsPair extends Exp {

    Exp pair;

    public ExpIsPair(Exp pair) {
        this.pair = pair;
    }

    public Exp getPair() {
        return this.pair;
    }

    @Override
    public <S, T> T visit(Visitor<S, T> v, S arg) throws VisitException {
        return v.visitExpIsPair(this, arg);
    }

    @Override
    public String toString() {
        return "pair?("+pair.toString()+")";
    }

}