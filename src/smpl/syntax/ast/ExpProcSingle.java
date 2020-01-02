package smpl.syntax.ast;

import java.util.ArrayList;
import java.util.List;

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
    public List<String> getParams() {
        List<String> paramList = new ArrayList<>();
        paramList.add(this.param);
        return paramList;
    }

    @Override
    public Environment<SMPLValue<?>> call(Visitor<Environment, SMPLValue<?>> v, List<Exp> args,
            Environment<SMPLValue<?>> env, Environment<SMPLValue<?>> closingEnv) throws VisitException {
        return v.visitExpProcSingleCall(this, args, env, closingEnv);
    }

    @Override
    public String toString() {
        return String.format(" %s {\n%s}", param, body.toString());
    }

}