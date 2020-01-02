package smpl.values;

import smpl.syntax.ast.core.Exp;
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
        return String.format("\n%s %s", procExp.toString());
    }
    
}