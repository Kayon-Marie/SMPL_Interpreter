package smpl.syntax.ast;

import java.util.List;

import smpl.syntax.ast.core.Statement;
import smpl.exceptions.VisitException;
import smpl.semantics.Visitor;
import smpl.syntax.ast.core.Exp;

public class StmtIf extends Statement {
    Exp pred;
    Exp clause1;
    Exp clause2;

    public StmtIf(Exp pred,Exp clause1, Exp clause2) {
        this.pred = pred;
        this.clause1 = clause1;
        this.clause2 = clause2;
    }

    public Exp getPredicate() {
	    return pred;
    }

    public Exp getClause1() {
	    return clause1;
    }

    public Exp getClause2() {
        return clause2;
    }
    
    @Override
    public <S, T> T visit(Visitor<S, T> v, S state) throws VisitException {
        return v.visitStmtIf(this, state);
    }

    @Override
    public String toString() {
        if(clause2==null){
            return "if " + pred.toString() + " then " + clause1.toString(); 
        }
	    return "if " + pred.toString() + " then " + clause1.toString() + " else " + clause2.toString();
    }

}
