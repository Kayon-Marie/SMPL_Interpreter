package smpl.syntax.ast;

import smpl.syntax.ast.core.Exp;
import smpl.exceptions.VisitException;
import smpl.semantics.Visitor;

public class ExpNeg extends Exp {

    Exp exp;

    public ExpNeg(Exp e) {
        this.exp = e;
    }

    /**
     * @return the exp
     */
    public Exp getExp() {
        return exp;
    }

    public <S, T> T visit(Visitor<S,T> v, S arg) throws VisitException {
	    return v.visitExpNeg(this, arg);
    }

    @Override
    public String toString() {
        return "Negated Exp: - " + this.exp; 
    }
}

