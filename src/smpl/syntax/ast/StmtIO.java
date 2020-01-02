package smpl.syntax.ast;

import java.util.List;

import smpl.syntax.ast.core.Statement;
import smpl.exceptions.VisitException;
import smpl.semantics.Visitor;
import smpl.syntax.ast.core.Exp;

public class StmtIO extends Statement {
    String operation;
    List<Exp> output;

    public StmtIO(String operation, List<Exp> output) {
        this.operation = operation;
        this.output = output;
    }

    public String getOperation() {
	    return operation;
    }

    public List<Exp> getOutput() {
	    return output;
    }
    
    @Override
    public <S, T> T visit(Visitor<S, T> v, S state) throws VisitException {
        return v.visitStmtIO(this, state);
    }

    @Override
    public String toString() {
	    return operation +"(" + output.toString()+")";
    }

}
