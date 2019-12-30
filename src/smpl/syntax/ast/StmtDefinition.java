package smpl.syntax.ast;

import smpl.exceptions.VisitException;

import smpl.syntax.ast.core.Exp;
import smpl.syntax.ast.core.Statement;

import smpl.semantics.Visitor;

public class StmtDefinition extends Statement {

    String var;
    Exp exp;

    public StmtDefinition(String id, Exp e) {
        var = id;
        exp = e;
    }

    public String getVar(){
	    return var;
    }

    public Exp getExp() {
	    return exp;
    }

    public <S, T> T visit(Visitor<S, T> v, S arg) throws VisitException {
	    return v.visitStmtDefinition(this, arg);
    }

    public String toString() {
	    return String.format("def %s %s", getVar(), getExp().toString());
    }
}
