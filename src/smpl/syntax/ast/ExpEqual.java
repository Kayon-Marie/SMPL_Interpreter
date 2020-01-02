package smpl.syntax.ast;

import smpl.exceptions.VisitException;
import smpl.semantics.Visitor;
import smpl.syntax.ast.core.Exp;
import smpl.values.*;

public class ExpEqual extends Exp {

    String exp1, exp2;

    public ExpEqual(String exp1, String exp2) {
        this.exp1 = exp1;
        this.exp2 = exp2;
    }

    public String getArg1(){
        return this.exp1;
    }

    public String getArg2(){
        return this.exp2;
    }

    @Override
    public <S, T> T visit(Visitor<S, T> v, S arg) throws VisitException {
        return v.visitExpEqual(this, arg);
    }

    @Override
    public String toString() {
        return "equal?("+this.exp1+","+this.exp2+")";
    }

}