package smpl.syntax.ast;

import smpl.exceptions.VisitException;

import smpl.syntax.ast.core.Exp;
import smpl.syntax.ast.core.Statement;

import smpl.semantics.Visitor;

public class StmtExp extends Statement {

    Exp exp;

    public StmtExp(Exp exp) {
        this.exp = exp;
    }

    public Exp getExp() {
        return this.exp;
    }

    public <S, T> T visit(Visitor<S, T> v, S arg) throws VisitException {
	    return v.visitStmtExp(this, arg);
    }

    public String toString() {
	    return exp.toString();
    }
}