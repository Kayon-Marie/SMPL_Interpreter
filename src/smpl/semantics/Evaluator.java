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
import smpl.syntax.ast.ExpLogOp;
import smpl.syntax.ast.ExpVar;
import smpl.syntax.ast.ExpAdd;
import smpl.syntax.ast.ExpAnd;
import smpl.syntax.ast.ExpBool;
import smpl.syntax.ast.ExpSub;
import smpl.syntax.ast.ExpMul;
import smpl.syntax.ast.ExpNeg;
import smpl.syntax.ast.ExpNot;
import smpl.syntax.ast.ExpOr;
import smpl.syntax.ast.ExpDiv;
import smpl.syntax.ast.ExpMod;
import smpl.syntax.ast.ExpPow;
import smpl.syntax.ast.ExpRelOp;
import smpl.syntax.ast.ExpRelOps;

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

    @Override
    public SMPLValue<?> visitExpBool(ExpBool exp, Environment arg) throws VisitException {
        return exp.getBool();
    }
    
    public SMPLValue<?> visitExpNeg(ExpNeg exp, Environment env) throws VisitException {
        SMPLValue<?> numval = exp.getExp().visit(this, env);
        return numval.neg();
    }

    public SMPLValue<?> visitExpPow(ExpPow exp, Environment arg)
	throws VisitException {
        SMPLValue<?> val, pow;
        val = exp.getExp().visit(this, arg);
        pow = exp.getPower().visit(this, arg);
        return val.pow(pow);
    }

    @Override
    public SMPLValue<?> visitExpRelOp(ExpRelOp exp, Environment arg) throws VisitException {
        SMPLValue<?> left, right;
        left = exp.getLeft().visit(this, arg);
        right = exp.getRight().visit(this, arg);
        String sign = exp.getSign();
        return left.cmp(right, sign);
    }

    @Override
    public SMPLValue<?> visitExpRelOps(ExpRelOps exp, Environment arg) throws VisitException {
        Boolean status = true;
        /*
        ArrayList<ExpRelOp> operations = exp.getOps();
        ExpLogOps logops = new ExpLogOps(operations, "and");
        return logops.visit(this, arg); */
        return null;
    }

    @Override
    public SMPLValue<?> visitExpAnd(ExpAnd exp, Environment arg) throws VisitException {
        SMPLValue<?> left, right;
        left = exp.getLeft().visit(this, arg);
        right = exp.getRight().visit(this, arg);
        return left.and(right);
    }

    @Override
    public SMPLValue<?> visitExpOr(ExpOr exp, Environment arg) throws VisitException {
        SMPLValue<?> left, right;
        left = exp.getLeft().visit(this, arg);
        right = exp.getRight().visit(this, arg);
        return left.or(right);
    }

    @Override
    public SMPLValue<?> visitExpNot(ExpNot exp, Environment arg) throws VisitException {
        SMPLValue<?> left;
        left = exp.getExp().visit(this, arg);
        return left.not();
    }

    @Override
    public SMPLValue<?> visitExpLogOp(ExpLogOp exp, Environment arg) throws VisitException {
        SMPLValue<?> left = exp.getLeft().visit(this, arg);
        SMPLValue<?> right = exp.getRight().visit(this, arg);
        SMPLValue<?> result;
        switch(exp.getOp()) {
            case "and":
                result = left.and(right);
                break;
            case "or":
                result = left.or(right);
                break;
            case "not":
                result = left.not();
                break;
            default:
                result = null;
        }
        return result;   
    }
}
