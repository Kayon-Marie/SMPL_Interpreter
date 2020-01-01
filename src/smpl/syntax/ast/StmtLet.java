package smpl.syntax.ast;

import java.util.ArrayList;

import smpl.syntax.ast.core.Statement;
import smpl.exceptions.VisitException;
import smpl.semantics.Visitor;
import smpl.syntax.ast.core.Exp;

/**
 * Class to represent an AST node for a let expression.
 * @author newts
 */
public class StmtLet extends Statement {
    ArrayList<Binding> bindings;
    Exp body;

    public StmtLet(ArrayList<Binding> bs, Exp bod) {
	bindings = bs;
	body = bod;
    }

    public ArrayList<Binding> getBindings() {
	return bindings;
    }

    public Exp getBody() {
	return body;
    }
    
    @Override
    public <S, T> T visit(Visitor<S, T> v, S state) throws VisitException {
        return v.visitStmtLet(this, state);
    }

    @Override
    public String toString() {
	return "let " + bindings + " in " + body;
    }

}
