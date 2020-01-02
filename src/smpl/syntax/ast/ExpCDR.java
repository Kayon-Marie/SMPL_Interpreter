package smpl.syntax.ast;

import smpl.exceptions.VisitException;
import smpl.semantics.Visitor;
import smpl.syntax.ast.core.Exp;
import smpl.values.SMPLValue;

public class ExpCDR extends Exp {

    Exp pair;

    public ExpCDR(Exp pair) {
        this.pair = pair;
    }

    public Exp getPair(){
        return this.pair;
    }

    @Override
    public <S, T> T visit(Visitor<S, T> v, S arg) throws VisitException {
        return v.visitExpCDR(this, arg);
    }

    @Override
    public String toString() {
        return "cdr("+this.pair.toString()+")";
    }

}