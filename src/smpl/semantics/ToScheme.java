package smpl.semantics;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

import smpl.exceptions.VisitException;
import smpl.syntax.ast.core.Exp;
import smpl.syntax.ast.core.SMPLProgram;
import smpl.syntax.ast.core.Statement;
import smpl.syntax.ast.core.Exp;
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
    public String visitStmtExp(StmtExp stmt, Void arg)
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

    @Override
    public String visitStmtAssignment(StmtAssignment sa, Void arg) throws VisitException {
        ArrayList<String> ids = sa.getVarList();
        ArrayList<Exp> exps = sa.getExpList();
        result = "(assignment";
        String x = "";
        String y = "";
        if(ids.size() != exps.size()){
            throw new VisitException("Error: Number of identifiers do not match number of expressions");
        }
        for(int i =0; i<ids.size();i++){
            if(i!=0){
                y+=",";
                x+=",";
            }
            x += (String)exps.get(i).visit(this,arg);
            y += ids.get(i); 
        }
        result = "(assignment" + y + " " + x + ")";
        return result;
    }

    public String visitStmtLet(StmtLet sl, Void arg)
	throws VisitException {
        ArrayList<Binding> bindings = sl.getBindings();
        Exp body = sl.getBody();
        String x = "";
        for (int i =0; i< bindings.size();i++){
            x += bindings.get(i).getVar();
            x += " = ";
            x += (String) bindings.get(i).getValExp().visit(this,arg);
        }
        return "(let " + x + " " +
            body.visit(this,arg).toString() + ")";
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

    public String visitExpChar(ExpChar exp, Void arg) throws VisitException {
        return "#c" + exp.getChar();
    }

    public String visitExpString(ExpString exp, Void arg) throws VisitException {
        return "\"" + exp.getString() + "\"";
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
    public String visitExpBOr(ExpBOr exp, Void arg) throws VisitException {
        String left = exp.getLeft().visit(this, arg);
        String right = exp.getRight().visit(this, arg);
        return "(" + "|" + " " + left + " " + right + ")";
    }

    @Override
    public String visitExpBAnd(ExpBAnd exp, Void arg) throws VisitException {
        String left = exp.getLeft().visit(this, arg);
        String right = exp.getRight().visit(this, arg);
        return "(" + "&" + " " + left + " " + right + ")";
    }

    @Override
    public String visitExpPair(ExpPair exp, Void arg) throws VisitException {
        String left = exp.getLeft().visit(this, arg);
        String right = exp.getRight().visit(this, arg);
        return "(" + "pair" + " " + left + " " + right + ")";
    }

    @Override
    public String visitExpCAR(ExpCAR exp, Void arg) throws VisitException {
        String left = exp.getPair().getLeft().toString();
        String right = exp.getPair().getRight().toString();
        return "(" + "CAR" + " " + left + " " + right + ")";
    }
    
    @Override
    public String visitExpCDR(ExpCDR exp, Void arg) throws VisitException {
        String left = exp.getPair().getLeft().toString();
        String right = exp.getPair().getRight().toString();
        return "(" + "CDR" + " " + left + " " + right + ")";
    }

    @Override
    public String visitExpList(ExpList exp, Void arg) throws VisitException {
        // ArrayList elements = exp.getElements();
        // if (elements.size() == 1)
        //     return ((Exp) elements.get(0)).visit(this,
        //                         arg);
        // else {
        //     Iterator iter = elements.iterator();
        //     String result = "(begin ";
        //     Exp e;
        //     while (iter.hasNext()) {
        //         e = (Exp) iter.next();
        //         result += (String) e.visit(this, arg) +
        //             ", ";
        //     }
        //     result += ")";
        //     return result;
        // }
        return "";
    }

    @Override
    public String visitExpVector(ExpVector exp, Void arg) throws VisitException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String visitExpSubVector(ExpSubVector exp, Void arg) throws VisitException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String visitExpProcDefn(ExpProc exp, Void arg) throws VisitException {
        return "";
    }

    @Override
    public String visitExpProcCall(ExpProcCall exp, Void env) throws VisitException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Void visitExpProcMulitCall(ExpProcMulti exp, List<Exp> args, Void env, Void env2)
            throws VisitException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Void visitExpProcNCall(ExpProcN exp, List<Exp> args, Void env, Void env2) throws VisitException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Void visitExpProcSingleCall(ExpProcSingle exp, List<Exp> args, Void env, Void env2)
            throws VisitException {
        // TODO Auto-generated method stub
        return null;
    }

    // @Override
    // public String visitExpLogOp(ExpLogOp exp, Void arg) throws VisitException {
    //     String left = exp.getLeft().visit(this, arg);
    //     String right = exp.getRight().visit(this, arg);
    //     String op = exp.getOp();
    //     return "(" + op + " " + left + " " + right + ")";
    // }
}
