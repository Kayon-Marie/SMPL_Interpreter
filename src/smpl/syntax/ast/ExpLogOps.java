package smpl.syntax.ast;

import smpl.exceptions.VisitException;
import smpl.semantics.Visitor;
import smpl.syntax.ast.core.Exp;

public class ExpLogOps extends Exp {

    public ExpLogOps(Exp e) {

    }

    @Override
    public <S, T> T visit(Visitor<S, T> v, S arg) throws VisitException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return null;
    }
}