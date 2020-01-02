package smpl.syntax.ast;

import smpl.exceptions.VisitException;
import smpl.semantics.Visitor;
import smpl.syntax.ast.core.Exp;
import smpl.values.SMPLPair;
import smpl.values.SMPLValue;

public class ExpCAR extends Exp {

    Exp pair;

    public ExpCAR(Exp pair) {
        this.pair = pair;
    }

    public Exp getPair(){
        return this.pair;
    }

    @Override
    public <S, T> T visit(Visitor<S, T> v, S arg) throws VisitException {
        return v.visitExpCAR(this, arg);
    }

    @Override
    public String toString() {
        return "car("+this.pair.toString()+")";
    }

}