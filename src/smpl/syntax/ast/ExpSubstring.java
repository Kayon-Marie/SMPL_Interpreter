package smpl.syntax.ast;

import smpl.exceptions.VisitException;
import smpl.semantics.Visitor;
import smpl.syntax.ast.core.Exp;
import smpl.values.SMPLString;

public class ExpSubstring extends Exp {

    
    String exp1;
    int exp2;
    int exp3;

    public ExpSubstring() {

    }

    public ExpSubstring(String exp1, int exp2, int exp3 ) {
        this.exp1 = exp1;
        this.exp2 = exp2;
        this.exp3 = exp3;
    }

    public String getString(){
        return this.exp1;
    }

    public int getStart(){
        return this.exp2;
    }

    public int getEnd(){
        return this.exp3;
    }

    @Override
    public <S, T> T visit(Visitor<S, T> v, S arg) throws VisitException {
        return v.visitExpSubstring(this, arg);
    }

    @Override
    public String toString() {
        return "substr("+this.exp1+","+this.exp2+","+this.exp3+")";
    }

}