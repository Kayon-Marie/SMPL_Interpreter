package smpl.syntax.ast;

import smpl.exceptions.VisitException;

import smpl.syntax.ast.core.Exp;
import smpl.values.SMPLValue;
import smpl.semantics.Visitor;

/**
 * Class representing numeric literals in SMPL
 * @author --group name--
 */
public class ExpLit extends Exp {

    SMPLValue<?> val;

    public ExpLit(SMPLValue<?> value) {
        val = value;
    }

    public ExpLit(Integer value) {
	    val = SMPLValue.make(value);
    }

    public ExpLit(Double value) {
	    val = SMPLValue.make(value);
    }

    public SMPLValue<?> getVal() {
	    return val;
    }

    public <S, T> T visit(Visitor<S, T> v, S arg) throws VisitException {
	    return v.visitExpLit(this, arg);
    }

    public String toString() {
	    return val.toString();
    }
}

