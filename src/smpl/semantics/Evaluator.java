package smpl.semantics;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Collections;

import smpl.exceptions.*;
import smpl.syntax.ast.core.*;
import smpl.values.*;
import smpl.syntax.ast.*;


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

    public SMPLValue<?> visitStmtExp(StmtExp s, Environment arg)
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

    @Override
    public SMPLValue<?> visitStmtAssignment(StmtAssignment sa, Environment env) throws VisitException {
        ArrayList<String> ids = sa.getVarList();
        ArrayList<Exp> exps = sa.getExpList();
        SMPLValue<?> result = SMPLValue.make(0);
        if(ids.size() != exps.size()){
            throw new VisitException("Error: Number of identifiers do not match number of expressions");
        }
        SMPLValue<?> test;
        for(int i =0; i<ids.size();i++){
            test = env.get(ids.get(i));
        }
        for(int i =0; i<ids.size();i++){
            result = exps.get(i).visit(this,env);
            env.put(ids.get(i),result);
        }
        return result;
    }

    public SMPLValue<?> visitStmtDefinition(StmtDefinition sd, Environment env)
	throws VisitException {
        // Environment env = (Environment) arg;
        result = sd.getExp().visit(this, env);
        env.put(sd.getVar(), result);
        return result;
    }

    @Override
    public SMPLValue<?> visitStmtLet(StmtLet let, Environment env) 
	throws VisitException{
	List<Binding> bindings = let.getBindings();
	Exp body = let.getBody();

	int size = bindings.size();
	String[] vars = new String[size];
	SMPLValue<?>[] vals = new SMPLValue<?>[size];
	Binding b;
	for (int i = 0; i < size; i++) {
	    b = bindings.get(i);
	    vars[i] = b.getVar();
	    // evaluate each expression in bindings
	    result = b.getValExp().visit(this, env);
	    vals[i] = result;
	}
	// create new env as child of current
	Environment newEnv = new Environment<> (vars, vals, env);
	return body.visit(this, newEnv);
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

    public SMPLValue<?> visitExpChar(ExpChar exp, Environment arg) throws VisitException {
        return exp.getChar();
    }

    public SMPLValue<?> visitExpString(ExpString exp, Environment arg) throws VisitException {
        return exp.getString();
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
        SMPLValue<?> status = SMPLValue.make(true);
        List<ExpRelOp> operations = exp.getOps();

        if (operations.size() < 1)
            return exp.getExp().visit(this, arg);

        for (ExpRelOp op: operations) {
            status = op.visit(this, arg);
            if (status.boolValue() == false) 
                break;
        }
        return status;
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
    public SMPLValue<?> visitExpBAnd(ExpBAnd exp, Environment arg) throws VisitException {
        SMPLValue<?> left,right;
        left = exp.getLeft().visit(this,arg);
        right = exp.getRight().visit(this,arg);
        return  left.BAnd(right);
    }

    @Override
    public SMPLValue<?> visitExpBOr(ExpBOr exp, Environment arg) throws VisitException {
        SMPLValue<?> left,right;
        left = exp.getLeft().visit(this,arg);
        right = exp.getRight().visit(this,arg);
        return  left.BOr(right);
    }

    @Override
    public SMPLValue<?> visitExpProcDefn(ExpProc exp, Environment arg) throws VisitException {
        SMPLProc closure = new SMPLProc(exp, arg);
        return closure;
    }

    @Override
    public SMPLValue<?> visitExpProcCall(ExpProcCall exp, Environment env) throws VisitException {
        // deal with id (can be variable or expression)
        SMPLProc proc = (SMPLProc) exp.getIdentifier().visit(this, env);
        ExpProc defn = proc.getProcExp();
        List<Exp> args = exp.getArgs();
        Environment<SMPLValue<?>> procEnv = defn.call(this, args, env, proc.getClosingEnv());
        return defn.getBody().visit(this, procEnv);
    }

    @Override
    public Environment visitExpProcNCall(ExpProcN exp, List<Exp> args, Environment env, Environment closingEnv) 
        throws VisitException {
        ArrayList<String> params = new ArrayList<>(exp.getParams());
        int paramSize = params.size();
        int argSize = args.size();
        List<SMPLValue<?>> values = new ArrayList<>();
        if (paramSize == argSize) {
            for (Exp arg: args) {
                values.add(arg.visit(this, env));
            }
            return new Environment(params, values, closingEnv);

        } else throw new ArgumentException(paramSize, argSize);
    }

    @Override
    public Environment visitExpProcMulitCall(ExpProcMulti exp, List<Exp> args, Environment env,
            Environment closingEnv) throws VisitException {
        List<String> params = new ArrayList<>(exp.getParams());
        int paramSize = params.size();
        int argSize = args.size();
        List<SMPLValue<?>> values = new ArrayList<>();
        SMPLValue<?> restValue;

        if (argSize >= paramSize) {

            // evauate N arguments
            for (int i = 0; i < paramSize; i++) {
                values.add(args.get(i).visit(this, env));
            }

            // excess (P-rest) arguments
            List<Exp> restExps = args.subList(paramSize, argSize);
            System.out.println(restExps);
            restValue = new ExpList(restExps).visit(this, env);
            
            params.add(exp.getRest());
            values.add(restValue);

            return new Environment(params, values, closingEnv);

        } else throw new ArgumentException(paramSize, argSize);
    }

    @Override
    public Environment visitExpProcSingleCall(ExpProcSingle exp, List<Exp> args, Environment env,
            Environment closingEnv) throws VisitException {
        ArrayList<String> params = new ArrayList<>(exp.getParams());
        List<SMPLValue<?>> values = new ArrayList<>();
        SMPLValue<?> restValue;

        restValue = new ExpList(args).visit(this, env);
        values.add(restValue);
        return new Environment(params, values, closingEnv);

    }
    
    public SMPLValue<?> visitExpPair(ExpPair exp, Environment arg) throws VisitException {
        SMPLValue<?> left,right;
        left = exp.getLeft().visit(this,arg);
        right = exp.getRight().visit(this,arg);
        return  new SMPLPair(left,right);
    }

    @Override
    public SMPLValue<?> visitExpCAR(ExpCAR exp, Environment arg) throws VisitException {
        SMPLValue<?> left;
        left =((SMPLPair)exp.getPair()).getLeft();
        return  left;
    }

    @Override
    public SMPLValue<?> visitExpCDR(ExpCDR exp, Environment arg) throws VisitException {
        SMPLValue<?> right;
        right = ((SMPLPair)exp.getPair()).getRight();
        return right;
    }

    @Override
    public SMPLValue<?> visitExpList(ExpList exp, Environment arg) throws VisitException {
        List<Exp> elements = exp.getElements();
        Iterator<Exp> iter = elements.iterator();
        Exp i;
        SMPLPair head = new SMPLPair();
        SMPLPair temp = head;
        SMPLPair next = new SMPLPair();
        while(iter.hasNext()) {
            i = (Exp) iter.next();
            temp.setLeft(i.visit(this,arg));
            temp.setRight(next);
            temp = next;
            next = new SMPLPair();
        }
        return head;
    }

    @Override
    public SMPLValue<?> visitExpVector(ExpVector exp, Environment arg) throws VisitException {
        SMPLVector vector = new SMPLVector();
        SMPLValue<?> value;
        for (Exp e: exp.getExpList()) {
            value = e.visit(this, arg);
            vector.add(value);
        }
        return vector;
    }

    @Override
    public SMPLValue<?> visitExpSubVector(ExpSubVector exp, Environment arg) throws VisitException {
        SMPLVector subVector = new SMPLVector();
        SMPLValue<?> value;
        SMPLValue<?> size = exp.getSize().visit(this, arg);
        SMPLValue<?> proc = exp.getProc().visit(this, arg);

        if (size.isInteger()) {
            if (proc.isProcedure()) { 
            // size must be SMPLInteger and proc must be SMPLProcedure
                ExpProc defn = ((SMPLProc)proc).getProcExp();
                int paramSize = defn.getParams().size();    // # of parameters
                List<Exp> args = new ArrayList<>(paramSize);    // arguments to be bound to params
                Environment<SMPLValue<?>> procEnv;
                for (int i = 0; i < size.intValue(); i++) {
                    Collections.fill(args, new ExpLit(i)); // make all arguments the value of i (which should be an Integer)

                    // Proc call code. Using the actual Proc Call visit would create unnecessary processing and repetitive evaluation
                    procEnv = defn.call(this, args, arg, ((SMPLProc)proc).getClosingEnv());
                    value = defn.getBody().visit(this, procEnv);
                    subVector.add(value);
                }
            } throw new TypeException(SMPLType.PROCEDURE, proc.getType());
        } else throw new TypeException(SMPLType.INTEGER, size.getType());
        
    }
}
