package smpl.syntax.ast;

import smpl.exceptions.VisitException;
import smpl.semantics.Visitor;
import smpl.syntax.ast.core.Exp;
import smpl.values.*;

public class ExpSize extends Exp {

    String exp1;

    public ExpSize(){

    }
    
    public ExpSize(String exp1) {
        this.exp1 = exp1;
    }

    public String getArg(){
        return this.exp1;
    }

    @Override
    public <S, T> T visit(Visitor<S, T> v, S arg) throws VisitException {
        return v.visitExpSize(this, arg);
    }

    @Override
    public String toString() {
        return "size("+this.exp1+")";
    }

}