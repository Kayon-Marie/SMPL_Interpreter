package smpl.syntax.ast;

import smpl.exceptions.TypeException;
import smpl.exceptions.VisitException;
import smpl.semantics.Visitor;
import smpl.syntax.ast.core.Exp;
import smpl.values.SMPLValue;

public class ExpBool extends Exp {

    SMPLValue<?> bool;

    public ExpBool(boolean val) {
        this.bool = SMPLValue.make(val);
    }

    /**
     * Experimental constructor if we want to implement truthy/falsy data types
     * @param val
     */
    public ExpBool(SMPLValue<?> val) throws TypeException {
        /* suggested pattern:
        To return false (#f):

        Pair - must be empty
        Vecor - must be empty or size == 0
        Int - must be <= 0
        Real - must be <=0.0
        Bool - false
        binary/hex - eq. to 0
         any other value should throw error
        */

    }

    /**
     * @return the bool
     */
    public SMPLValue<?> getBool() {
        return bool;
    }

    @Override
    public <S, T> T visit(Visitor<S, T> v, S arg) throws VisitException {
        return v.visitExpBool(this, arg);
    }

    @Override
    public String toString() {
        return this.bool.toString();
    }
}