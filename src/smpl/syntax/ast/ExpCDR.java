package smpl.syntax.ast;

import smpl.exceptions.VisitException;
import smpl.semantics.Visitor;
import smpl.syntax.ast.core.Exp;
import smpl.values.SMPLPair;



public class ExpCDR extends Exp {

    SMPLPair pair;

    public ExpCDR(SMPLPair pair) {
        this.pair = pair;
    }

    public SMPLPair getPair(){
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