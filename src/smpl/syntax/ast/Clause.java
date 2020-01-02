package smpl.syntax.ast;

import smpl.syntax.ast.core.Exp;

public class Clause extends Exp {

    Exp pred;
    Statement action;

    public Clause(Exp pred, Exp action) {
	    this.pred = pred;
	    this.action = action;
    }

    public Exp getPred() {
	    return pred;
    }

    public Statement getAction() {
	    return action;
    }

}
