package smpl.syntax.ast;

import java.util.ArrayList;

import smpl.exceptions.VisitException;
import smpl.semantics.Visitor;
import smpl.syntax.ast.core.Exp;

public class ExpRelOps extends Exp {

    Exp exp;
    ArrayList<ExpRelOp> ops;

    public ExpRelOps(Exp exp) {
        this.exp = exp;
    }

    public ExpRelOps(ArrayList<ExpRelOp> ops) {
        this.ops = ops;
    }
    
    /**
     * @return the initial expresstion at the head of the list of relational operations
     */
    public Exp getExp() {
        return exp;
    }

    /**
     * @return the relational operations
     */
    public ArrayList<ExpRelOp> getOps() {
        return ops;
    }

    public void add(Exp right, String sign) {
        this.ops.add(new ExpRelOp(this.exp, right, sign));
    }
    

    @Override
    public <S, T> T visit(Visitor<S, T> v, S arg) throws VisitException {
        return v.visitExpRelOps(this, arg);
    }

    @Override
    public String toString() {
        return "";
    }



}