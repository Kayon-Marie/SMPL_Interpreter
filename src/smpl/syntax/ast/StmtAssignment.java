package smpl.syntax.ast;

import smpl.syntax.ast.core.Statement;
import smpl.exceptions.VisitException;
import smpl.semantics.Visitor;
import smpl.syntax.ast.core.Exp;


public class StmtAssignment extends Statement {

    String var;
    Exp exp;

    public StmtAssignment(String id, Exp exp) {
        this.var = id;
        this.exp = exp;
    }

    public Exp getExp() {
        return this.exp;
    }

    public String getVar() {
        return this.var;
    }

    @Override
    public <S, T> T visit(Visitor<S, T> v, S arg) throws VisitException {
        return v.visitStmtAssignment(this, arg);
    }

    @Override
    public String toString() {
        return var + " := " + exp.toString();
    }


}