package smpl.values;

import smpl.exceptions.SMPLException;

public class SMPLBool extends SMPLValue<SMPLBool>{

    boolean value;
    String rep;

    public SMPLBool() {this(false);}

    public SMPLBool(Boolean value) {
        this.value = value;
        if (this.value) this.rep = "#t";
        else this.rep = "#f";
    }

    @Override
    public SMPLValue<?> neg() throws SMPLException {
        return make(!this.value);
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
            
            default:
                break;
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
    public SMPLType getType() {
        return SMPLType.BOOLEAN;
    }

    @Override
    public String toString() {
        return new String(getType().toString() + this.rep + "(" + this.value + ")");
    }

}