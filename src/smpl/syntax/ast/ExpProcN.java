package smpl.syntax.ast;

import java.util.ArrayList;

import smpl.semantics.Environment;
import smpl.exceptions.ArgumentException;
import smpl.exceptions.VisitException;
import smpl.semantics.Visitor;
import smpl.syntax.ast.core.Exp;
import smpl.values.SMPLValue;

public class ExpProcN extends ExpProc {

    ArrayList<String> params;

    public ExpProcN(ArrayList<String> params, Exp body) {
        super(body);
        this.params = params;
    }

    /**
     * @return the params
     */
    public ArrayList<String> getParams() {
        return params;
    }

    @Override
    public Environment<SMPLValue<?>> call(Visitor<Environment, SMPLValue<?>> v, ArrayList<Exp> args,
            Environment<SMPLValue<?>> env, Environment<SMPLValue<?>> closingEnv) throws VisitException {
        return v.visitExpProcNCall(this, args, env, closingEnv);
    }

    @Override
    public String toString() {
        String paramstr;
        ArrayList<String> paramList = params;
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
        
        return String.format("(%s) {\n\t %s \n}", paramstr, body.toString());
    }

}