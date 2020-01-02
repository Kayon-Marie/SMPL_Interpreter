package smpl.values;

import smpl.exceptions.SMPLException;
import smpl.exceptions.TypeException;

public class SMPLBool extends SMPLValue<SMPLBool>{

    boolean value;
    String rep;

    public SMPLBool() {this(false);}

    public SMPLBool(Boolean value) {
        this.value = value;
        if (this.value) this.rep = "#t";
        else            this.rep = "#f";
    }

    public SMPLBool(SMPLValue<?> value) throws SMPLException{
        this.value = value.boolValue();
    }

    @Override
    public SMPLValue<?> neg() throws SMPLException {
        return make(-1 * intValue());
    }

    @Override
    public SMPLValue<?> and(SMPLValue<?> arg) throws SMPLException {
        if (arg.isBool()) 
            return SMPLValue.make(boolValue() && arg.boolValue());
        throw new TypeException("and", this, arg);
    }

    @Override
    public SMPLValue<?> or(SMPLValue<?> arg) throws SMPLException {
        if (arg.isBool())
            return SMPLValue.make(boolValue() || arg.boolValue());
        throw new TypeException("or", this, arg);
    }

    @Override
    public SMPLValue<?> not() throws SMPLException {
        return SMPLValue.make(! boolValue());
    }

    /* Comparisons based on sign */
    @Override
    public SMPLBool cmp(SMPLValue<?> arg, String sign) throws SMPLException {
        SMPLBool result = make(false);
        class Exc { void raise(SMPLValue<?> left, SMPLValue<?> right, String sign) throws SMPLException{ 
            throw new SMPLException("Cannot compare " + left + " and " + right + " using " + sign + " operator"); 
        }}
        
        switch (sign) {
            case "<":
                if (arg.isInteger() | arg.isBool()) result = make(intValue() < arg.intValue());
                else if (arg.isReal())              result = make(intValue() < arg.doubleValue());
                else                                new Exc().raise(this, arg, sign);
                break;

            case "<=":
                if (arg.isInteger() | arg.isBool()) result = make(intValue() <= arg.intValue());
                else if (arg.isReal())              result = make(intValue() <= arg.doubleValue());
                else                                new Exc().raise(this, arg, sign);
                break;

            case ">":
                if (arg.isInteger() | arg.isBool()) result = make(intValue() > arg.intValue());
                else if (arg.isReal())              result = make(intValue() > arg.doubleValue());
                else                                new Exc().raise(this, arg, sign);
                break;

            case ">=":
                if (arg.isInteger() | arg.isBool()) result = make(intValue() > arg.intValue());
                else if (arg.isReal())              result = make(intValue() > arg.doubleValue());
                else                                new Exc().raise(this, arg, sign);
                break;

            case "=":
                if (arg.isInteger() | arg.isBool()) result = make(intValue() == arg.intValue());
                else if (arg.isReal())              result = make(intValue() == arg.doubleValue());
                else                                new Exc().raise(this, arg, sign);
                break;

            case "!=":
                if (arg.isInteger() | arg.isBool()) result = make(intValue() != arg.intValue());
                else if (arg.isReal())              result = make(intValue() != arg.doubleValue());
                else                                new Exc().raise(this, arg, sign);
                break;

            case "and":
                if (arg.isBool())   result = make(boolValue() && arg.boolValue());
                else                new Exc().raise(this, arg, sign);   
                break;

            case "or":
                if (arg.isBool())   result = make(boolValue() || arg.boolValue());
                else                new Exc().raise(this, arg, sign); 

            case "not":
                result = (SMPLBool) this.neg();
                break;

            default:
                throw new SMPLException("Illegal operator: " + sign);
        }

        return result;
    }

    @Override
    public int intValue() throws SMPLException {
        if (this.value)
            return 1;
        return 0;
    }

    @Override
    public boolean boolValue() throws SMPLException {
        return this.value;
    }

    @Override
    public SMPLType getType() {
        return SMPLType.BOOLEAN;
    }

    @Override
    public String toString() {
        return new String(this.rep + "(" + this.value + ")");
    }

}