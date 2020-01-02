package smpl.syntax.ast;

import java.util.List;

import smpl.exceptions.VisitException;
import smpl.semantics.Environment;
import smpl.semantics.Visitor;
import smpl.syntax.ast.core.Exp;
import smpl.values.SMPLValue;

public class ExpProcMulti extends ExpProc {

    List<String> params;
    String rest;

    public ExpProcMulti(List<String> params, String rest, Exp body) {
        super(body);
        this.params = params;
        this.rest = rest;
    }

    @Override
    public List<String> getParams() {
        return this.params;
    }

    public String getRest() {
        return this.rest;
    }

    @Override
    public Environment<SMPLValue<?>> call(Visitor<Environment, SMPLValue<?>> v, List<Exp> args,
            Environment<SMPLValue<?>> env, Environment<SMPLValue<?>> closingEnv) throws VisitException {
        return v.visitExpProcMulitCall(this, args, env, closingEnv);
    }

    @Override
    public String toString() {
        String paramstr;
        List<String> paramList = params;
        int n = paramList.size();
        switch (n) {
            case 0: paramstr = ""; break;
            case 1: paramstr = paramList.get(0); break;
            default: 
                paramstr = paramList.get(0);
                for (int i = 1; i < n; i++) {
                    paramstr += ", " + paramList.get(i);
                }
        }
        
        return String.format("(%s . %s) {\n%s}", paramstr, rest, body.toString());
    }

}