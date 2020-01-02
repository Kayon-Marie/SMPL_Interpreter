package smpl.syntax.ast;

import smpl.exceptions.VisitException;
import smpl.semantics.Visitor;
import smpl.syntax.ast.core.Exp;
import smpl.values.SMPLString;

public class ExpSubstring extends Exp {

    
    Exp exp1, exp2, exp3;

    public ExpSubstring() {

    }

    public ExpSubstring(Exp exp1, Exp exp2, Exp exp3 ) {
        this.exp1 = exp1;
        this.exp2 = exp2;
        this.exp3 = exp3;
    }

    public Exp getString(){
        return this.exp1;
    }

    public Exp getStart(){
        return this.exp2;
    }

    public Exp getEnd(){
        return this.exp3;
    }

    @Override
    public <S, T> T visit(Visitor<S, T> v, S arg) throws VisitException {
        return v.visitExpSubstring(this, arg);
    }

    @Override
    public String toString() {
        return "substr("+this.exp1.toString()+","+this.exp2.toString()+","+this.exp3.toString()+")";
    }

}