package smpl.syntax.ast;

import java.util.ArrayList;

import smpl.exceptions.VisitException;
import smpl.semantics.Environment;
import smpl.semantics.Visitor;
import smpl.syntax.ast.core.Exp;
import smpl.values.SMPLValue;

public class ExpProcSingle extends ExpProc {

    String param;

    public ExpProcSingle(String param, Exp body) {
        super(body);
        this.param = param;
    }

    @Override
    public ArrayList<String> getParams() {
        ArrayList<String> paramList = new ArrayList<>();
        paramList.add(this.param);
        return paramList;
    }

    @Override
    public Environment<SMPLValue<?>> call(Visitor<Environment, SMPLValue<?>> v, ArrayList<Exp> args,
            Environment<SMPLValue<?>> env, Environment<SMPLValue<?>> closingEnv) throws VisitException {
        return v.visitExpProcSingleCall(this, args, env, closingEnv);
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return null;
    }

}