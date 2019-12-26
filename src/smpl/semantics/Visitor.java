package smpl.semantics;

import smpl.exceptions.VisitException;
import smpl.syntax.ast.core.SMPLProgram;
import smpl.syntax.ast.*;

/**
 * The generic Visitor interface for the Arithmetic parser
 * example.
 * @param <S> The type of the information needed by the visitor
 * @param <T> The type of result returned by the visitor 
 */
public interface Visitor<S, T> {

    // to facilitate generic constructors
    public S getDefaultState();

    // program
    public T visitSMPLProgram(SMPLProgram p, S arg) throws VisitException;

    // statements
    public T visitStatement(Statement exp, S arg) throws VisitException ;
    public T visitStmtSequence(StmtSequence exp, S arg) throws VisitException ;
    public T visitStmtDefinition(StmtDefinition sd, S arg) throws VisitException;

    // expressions

    //arithmetic
    public T visitExpAdd(ExpAdd exp, S arg) throws VisitException;
    public T visitExpSub(ExpSub exp, S arg) throws VisitException;
    public T visitExpMul(ExpMul exp, S arg) throws VisitException;
    public T visitExpDiv(ExpDiv exp, S arg) throws VisitException;
    public T visitExpMod(ExpMod exp, S arg) throws VisitException;
    public T visitExpNeg(ExpNeg exp, S arg) throws VisitException;
    public T visitExpPow(ExpPow exp, S ard) throws VisitException;  

    // iterals and variables
    public T visitExpLit(ExpLit exp, S arg) throws VisitException;
    public T visitExpVar(ExpVar exp, S arg) throws VisitException;
    public T visitExpBool(ExpBool exp, S arg) throws VisitException;
    
    //relational and logic expressions
    public T visitExpAnd(ExpAnd exp, S arg) throws VisitException;
    public T visitExpOr(ExpOr exp, S arg) throws VisitException;
    public T visitExpNot(ExpNot exp, S arg) throws VisitException;
    public T visitExpRelOp(ExpRelOp exp, S arg) throws VisitException;
    public T visitExpRelOps(ExpRelOps exp, S arg) throws VisitException;
    public T visitExpLogOp(ExpLogOp exp, S arg) throws VisitException;
}
