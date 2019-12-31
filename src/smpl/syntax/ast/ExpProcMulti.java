package smpl.syntax.ast;

import java.util.ArrayList;

import smpl.exceptions.VisitException;
import smpl.semantics.Environment;
import smpl.semantics.Visitor;
import smpl.syntax.ast.core.Exp;
import smpl.values.SMPLValue;

public class ExpProcMulti extends ExpProc {

    ArrayList<String> params;
    String rest;

    public ExpProcMulti(ArrayList<String> params, String rest, Exp body) {
        super(body);
        this.params = params;
        this.rest = rest;
    }

    @Override
    public ArrayList<String> getParams() {
        return this.params;
    }

    @Override
    public Environment<SMPLValue<?>> call(Visitor<Environment, SMPLValue<?>> v, ArrayList<Exp> args,
            Environment<SMPLValue<?>> env, Environment<SMPLValue<?>> closingEnv) throws VisitException {
        return v.visitExpProcMulitCall(this, args, env, closingEnv);
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return null;
    }

}