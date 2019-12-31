package smpl.syntax.ast;

import smpl.exceptions.VisitException;
import smpl.semantics.Environment;
import smpl.semantics.Visitor;
import smpl.syntax.ast.core.Exp;
import smpl.values.SMPLValue;

import java.util.ArrayList;

public abstract class ExpProc extends Exp {

    protected Exp body;

    public ExpProc(Exp body) {
        this.body = body;
    }

    public Exp getBody() {
        return this.body;
    }

    public abstract ArrayList<String> getParams();

    public abstract Environment<SMPLValue<?>> call(Visitor<Environment, SMPLValue<?>> v, ArrayList<Exp> args, 
        Environment<SMPLValue<?>> env, Environment<SMPLValue<?>> closingEnv) throws VisitException;

    @Override
    public <S, T> T visit(Visitor<S, T> v, S arg) throws VisitException {
        return v.visitExpProcDefn(this, arg);
    }
}   