package smpl.syntax.ast;

import smpl.syntax.ast.core.Exp;
import smpl.syntax.ast.core.Statement;

public class Clause{

    Exp pred;
    Exp action;

    public Clause(Exp pred, Exp action) {
	    this.pred = pred;
	    this.action = action;
    }

    public Exp getPred() {
	    return pred;
    }

    public Exp getAction() {
	    return action;
    }

}
