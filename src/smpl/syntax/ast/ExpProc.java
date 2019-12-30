package smpl.syntax.ast;

import smpl.exceptions.VisitException;
import smpl.semantics.Visitor;
import smpl.syntax.ast.core.Exp;
import java.util.ArrayList;

public class ExpProc extends Exp {

    ArrayList<String> params;
    Exp body;

    public ExpProc(ArrayList<String> params, Exp body) {
        this.params = params;
        this.body = body;
    }

    public ArrayList<String> getParams() {
        return this.params;
    }

    public Exp getBody() {
        return this.body;
    }

    @Override
    public <S, T> T visit(Visitor<S, T> v, S arg) throws VisitException {
        return v.visitExpProcDefn(this, arg);
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return null;
    }

}