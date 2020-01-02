package smpl.syntax.ast;

import java.util.List;

import smpl.exceptions.VisitException;
import smpl.semantics.Visitor;
import smpl.syntax.ast.core.Exp;

public class ExpProcCall extends Exp {

    Exp identifier;
    List<Exp> args;

    public ExpProcCall (Exp id, List<Exp> args) {
        this.identifier = id;
        this.args = args;
    }

    /**
     * @return the identifier
     */
    public Exp getIdentifier() {
        return identifier;
    }

    /**
     * @return the args
     */
    public List<Exp> getArgs() {
        return args;
    }

    @Override
    public <S, T> T visit(Visitor<S, T> v, S arg) throws VisitException {
        return v.visitExpProcCall(this, arg);
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return null;
    }
}