package smpl.syntax.ast;

import java.util.ArrayList;

import smpl.syntax.ast.core.Statement;
import smpl.exceptions.VisitException;
import smpl.semantics.Visitor;
import smpl.syntax.ast.core.Exp;

public class StmtCase extends Statement {

    ArrayList<Clause> clauses;

    public StmtCase(ArrayList<Clause> clauses) {
        this.clauses = clauses;
    }

    public ArrayList<Clause> getClauses() {
        return this.clauses;
    }

    @Override
    public <S, T> T visit(Visitor<S, T> v, S arg) throws VisitException {
        return v.visitStmtClause(this, arg);
    }

    @Override
    public String toString() {
        return "";
    }


}