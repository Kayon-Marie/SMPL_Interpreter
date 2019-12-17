package smpl.semantics;

import java.util.ArrayList;
import java.util.Iterator;

import smpl.exceptions.VisitException;

import smpl.syntax.ast.core.SMPLProgram;
import smpl.values.SMPLValue;
import smpl.syntax.ast.Statement;
import smpl.syntax.ast.StmtSequence;
import smpl.syntax.ast.StmtDefinition;
import smpl.syntax.ast.ExpLit;
import smpl.syntax.ast.ExpVar;
import smpl.syntax.ast.ExpAdd;
import smpl.syntax.ast.ExpSub;
import smpl.syntax.ast.ExpMul;
import smpl.syntax.ast.ExpNeg;
import smpl.syntax.ast.ExpDiv;
import smpl.syntax.ast.ExpMod;

public class Evaluator implements Visitor<Environment, SMPLValue<?>> {
    /* For this visitor, the argument passed to all visit
       methods will be the environment object that used to
       be passed to the eval method in the first style of
       implementation. */

    // allocate state here
    protected SMPLValue<?> result;	// result of evaluation

    public Evaluator() {
        // perform initialisations here
        result = SMPLValue.make(0);
    }

    public Environment getDefaultState() {
	    return Environment.makeGlobalEnv();
    }

    public SMPLValue<?> visitSMPLProgram(SMPLProgram p, Environment arg)
	throws VisitException {
        result = p.getSeq().visit(this, arg);
        return result;
    }

    public SMPLValue<?> visitStatement(Statement s, Environment arg)
    throws VisitException {
	    return s.getExp().visit(this, arg);
    }

    public SMPLValue<?> visitStmtSequence(StmtSequence sseq, Environment arg)
	throws VisitException {
        // remember that arg is the environment
        Statement s;
        ArrayList seq = sseq.getSeq();
        Iterator iter = seq.iterator();
        result = SMPLValue.make(0); // default result
        while(iter.hasNext()) {
            s = (Statement) iter.next();
            result = s.visit(this, arg);
        }
        // return last value evaluated
        return result;
    }

    public SMPLValue<?> visitStmtDefinition(StmtDefinition sd, Environment env)
	throws VisitException {
        // Environment env = (Environment) arg;
        result = sd.getExp().visit(this, env);
        env.put(sd.getVar(), result);
        return result;
    }

    public SMPLValue<?> visitExpAdd(ExpAdd exp, Environment arg)
	throws VisitException {
        SMPLValue<?> val1, val2;
        val1 = exp.getExpL().visit(this, arg);
        val2 = exp.getExpR().visit(this, arg);
        return val1.add(val2);
    }

    public SMPLValue<?> visitExpSub(ExpSub exp, Environment arg)
	throws VisitException {
        SMPLValue<?> val1, val2;
        val1 = exp.getExpL().visit(this, arg);
        val2 = exp.getExpR().visit(this, arg);
        return val1.sub(val2);
    }

    public SMPLValue<?> visitExpMul(ExpMul exp, Environment arg)
	throws VisitException {
	    SMPLValue<?> val1, val2;
        val1 = exp.getExpL().visit(this, arg);
        val2 = exp.getExpR().visit(this, arg);
        return val1.mul(val2);
    }

    public SMPLValue<?> visitExpDiv(ExpDiv exp, Environment arg)
	throws VisitException {
        SMPLValue<?> val1, val2;
        val1 = exp.getExpL().visit(this, arg);
        val2 = exp.getExpR().visit(this, arg);
        return val1.div(val2);
    }

    public SMPLValue<?> visitExpMod(ExpMod exp, Environment arg)
	throws VisitException {
        SMPLValue<?> val1, val2;
        val1 = exp.getExpL().visit(this, arg);
        val2 = exp.getExpR().visit(this, arg);
        return val1.mod(val2);
    }

    public SMPLValue<?> visitExpLit(ExpLit exp, Environment arg)
	throws VisitException {
	    return exp.getVal();
    }

    public SMPLValue<?> visitExpVar(ExpVar exp, Environment env)
	throws VisitException {
        // remember that arg is really the environment
        //	Environment env = (Environment) arg;
        SMPLValue<?> val = env.get(exp.getVar());
        return val;
    }

    public SMPLValue<?> visitExpNeg(ExpNeg exp, Environment env) throws VisitException {
        SMPLValue<?> numval = exp.getExp().visit(this, env);
        return numval.neg();
    }
}
