package smpl.syntax.ast;

import smpl.exceptions.VisitException;
import smpl.semantics.Visitor;
import smpl.syntax.ast.core.Exp;

import java.util.ArrayList;

public class ExpVector extends Exp {

    ArrayList<Exp> expList;

    public ExpVector(ArrayList<Exp> expList) {
        this.expList = expList;
    }

    /**
     * @return the expList
     */
    public ArrayList<Exp> getExpList() {
        return expList;
    }

    @Override
    public <S, T> T visit(Visitor<S, T> v, S arg) throws VisitException {
        return v.visitExpVector(this, arg);
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return null;
    }

}