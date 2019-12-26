package smpl.semantics;

import java.util.ArrayList;
import java.util.Iterator;

import smpl.exceptions.VisitException;

import smpl.syntax.ast.core.SMPLProgram;
import smpl.syntax.ast.*;

public class ToScheme implements Visitor<Void, String> {

    String result;

    public ToScheme() {
	    result = "";
    }

    public String getResult() {
	    return result;
    }

    public Void getDefaultState() {
	    return null;
    }

    // program
    public String visitSMPLProgram(SMPLProgram p, Void arg)
	throws VisitException {
        result = (String) p.getSeq().visit(this, arg);
        return result;
    }

    // statements
    public String visitStatement(Statement stmt, Void arg)
	throws VisitException {
	    return stmt.getExp().visit(this, arg);
    }

    public String visitStmtSequence(StmtSequence exp, Void arg)
	throws VisitException {
        ArrayList stmts = exp.getSeq();
        if (stmts.size() == 1)
            return ((Statement) stmts.get(0)).visit(this,
                                arg);
        else {
            Iterator iter = stmts.iterator();
            String result = "(begin ";
            Statement stmt;
            while (iter.hasNext()) {
                stmt = (Statement) iter.next();
                result += (String) stmt.visit(this, arg) +
                    "\n";
            }
            result += ")";
            return result;
        }
    }

    public String visitStmtDefinition(StmtDefinition sd, Void arg)
	throws VisitException {
        String valExp = (String) sd.getExp().visit(this,
                            arg);
        return "(define " + sd.getVar() + " " +
            valExp + ")";
    }

    // expressions
    public String visitExpAdd(ExpAdd exp, Void arg)
	throws VisitException {
        String left = exp.getExpL().visit(this, arg);
        String right = exp.getExpR().visit(this, arg);
        return "(+ " + left + " " + right + ")";
    }
    public String visitExpSub(ExpSub exp, Void arg)
	throws VisitException {
        String left = exp.getExpL().visit(this, arg);
        String right = exp.getExpR().visit(this, arg);
        return "(- " + left + " " + right + ")";
    }

    public String visitExpMul(ExpMul exp, Void arg)
	throws VisitException {
        String left = exp.getExpL().visit(this, arg);
        String right = exp.getExpR().visit(this, arg);
        return "(* " + left + " " + right + ")";
    }

    public String visitExpDiv(ExpDiv exp, Void arg)
	throws VisitException {
        String left = exp.getExpL().visit(this, arg);
        String right = exp.getExpR().visit(this, arg);
        return "(/ " + left + " " + right + ")";
    }

    public String visitExpMod(ExpMod exp, Void arg)
	throws VisitException {
        String left = exp.getExpL().visit(this, arg);
        String right = exp.getExpR().visit(this, arg);
        return "(mod " + left + " " + right + ")";
    }

    public String visitExpNeg(ExpNeg exp, Void arg)
	throws VisitException {
	    return "(-" + exp.getExp();
    }

    public String visitExpLit(ExpLit exp, Void arg)
	throws VisitException {
	    return "" + exp.getVal();
    }

    public String visitExpVar(ExpVar exp, Void arg)
	throws VisitException {
	    return exp.getVar();
    }

    @Override
    public String visitExpBool(ExpBool exp, Void arg) throws VisitException {
        return "" + exp.getBool();
    }

    public String visitExpPow(ExpPow exp, Void arg) throws VisitException {
        String left = exp.getExp().visit(this, arg);
        String right = exp.getPower().visit(this, arg);
        return "(^ " + left + " " + right + ")";
    }

    @Override
    public String visitExpRelOp(ExpRelOp exp, Void arg) throws VisitException {
        String left = exp.getLeft().visit(this, arg);
        String right = exp.getRight().visit(this, arg);
        String sign = exp.getSign();
        return "(" + sign + " " + left + " " + right + ")";
    }

    @Override
    public String visitExpAnd(ExpAnd exp, Void arg) throws VisitException {
        String left = exp.getLeft().visit(this, arg);
        String right = exp.getRight().visit(this, arg);
        return "(" + "and" + " " + left + " " + right + ")";
    }

    @Override
    public String visitExpOr(ExpOr exp, Void arg) throws VisitException {
        String left = exp.getLeft().visit(this, arg);
        String right = exp.getRight().visit(this, arg);
        return "(" + "or" + " " + left + " " + right + ")";
    }

    @Override
    public String visitExpNot(ExpNot exp, Void arg) throws VisitException {
        String left = exp.getExp().visit(this, arg);
        return "(" + "not" + " " + left + ")";
    }

    @Override
    public String visitExpRelOps(ExpRelOps exp, Void arg) throws VisitException {
        return "";
    }

    @Override
    public String visitExpLogOp(ExpLogOp exp, Void arg) throws VisitException {
        String left = exp.getLeft().visit(this, arg);
        String right = exp.getRight().visit(this, arg);
        String op = exp.getOp();
        return "(" + op + " " + left + " " + right + ")";
    }
}
