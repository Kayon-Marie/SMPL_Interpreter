package smpl.syntax.ast;

import java.util.ArrayList;

import smpl.exceptions.VisitException;
import smpl.semantics.Visitor;
import smpl.syntax.ast.core.Exp;

public class ExpProcCall extends Exp {

    Exp identifier;
    ArrayList<Exp> args;

    public ExpProcCall (Exp id, ArrayList<Exp> args) {
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
    public ArrayList<Exp> getArgs() {
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