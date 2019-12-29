package smpl.values;

import smpl.syntax.ast.ExpProc;
import smpl.semantics.Environment;
import java.util.ArrayList;

public class SMPLProc extends SMPLValue<SMPLProc> {

    ExpProc procExp;
    Environment<SMPLValue<?>> closingEnv;

    public SMPLProc(ExpProc exp, Environment<SMPLValue<?>> env) {
        this.procExp = exp;
        this.closingEnv = env;
    }

    /**
     * @return the procExp
     */
    public ExpProc getProcExp() {
        return procExp;
    }

    /**
     * @return the closingEnv
     */
    public Environment<SMPLValue<?>> getClosingEnv() {
        return closingEnv;
    }

    @Override
    public SMPLType getType() {
        return SMPLType.PROCEDURE;
    }

    @Override
    public String toString() {
        String params;
        ArrayList<String> paramList = procExp.getParams();
        int n = paramList.size();
        switch (n) {
            case 0: params = ""; break;
            case 1: params = paramList.get(0); break;
            default: 
                params = paramList.get(0);
                for (int i = 1; i < n; i++) {
                    params += ", " + paramList.get(i);
                }
        }
        String body = procExp.getBody().toString();
        return String.format("\nFunction: (%s) {\n\t %s \n}", params, body);
    }
    
}