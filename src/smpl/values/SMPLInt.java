package smpl.values;

import smpl.exceptions.RuntimeException;
import smpl.exceptions.TypeException;

public class SMPLInt extends SMPLValue<SMPLInt> {

    int value;

    public SMPLInt() { this(0); }

    public  SMPLInt(Integer value) {
        this.value = value;
    }

    @Override
    public SMPLType getType() {
        return SMPLType.INTEGER;
    }

    @Override
    public SMPLValue<?> add(SMPLValue<?> arg) throws RuntimeException {
        if (arg.isReal()) { // SMPLInt + SMPLReal
            return make(this.value + arg.doubleValue());
        } else if (arg.isInteger()) {   // SMPLInt + SMPLInt
            return make(this.value + arg.intValue());
        } else {
            throw new TypeException("Cannot add " + arg + " to " + this);
        }        
    }

    @Override
    public SMPLValue<?> sub(SMPLValue<?> arg) throws RuntimeException {
        if (arg.isReal()) { // SMPLInt - SMPLReal
            return make(this.value - arg.doubleValue());
        } else if (arg.isInteger()) {   // SMPLInt - SMPLInt
            return make(this.value - arg.intValue());
        } else {
            throw new TypeException("Cannot subtract " + arg + " from " + this);
        }     
    }

    @Override
    public SMPLValue<?> neg() throws RuntimeException {
        return make(this.value * -1);
    }

    @Override
    public SMPLValue<?> mul(SMPLValue<?> arg) throws RuntimeException {
        if (arg.isReal()) { // SMPLInt * SMPLReal
            return make(this.value * arg.doubleValue());
        } else if (arg.isInteger()) {   // SMPLInt * SMPLInt
            return make(this.value * arg.intValue());
        } else {
            throw new TypeException("Cannot multiply " + this + " by " + arg);
        }     
    }

    @Override
    public SMPLValue<?> div(SMPLValue<?> arg) throws RuntimeException {
        if (arg.isReal()) { // SMPLInt / SMPLReal
            return make(this.value / arg.doubleValue());
        } else if (arg.isInteger()) {   // SMPLInt / SMPLInt
            return make(this.value / arg.intValue());
        } else {
            throw new TypeException("Cannot divide " + this + " by " + arg);
        }     
    }

    @Override
    public SMPLValue<?> mod(SMPLValue<?> arg) throws RuntimeException {
        if (arg.isReal()) { // SMPLInt % SMPLReal
            return make(this.value % arg.doubleValue());
        } else if (arg.isInteger()) {   // SMPLInt % SMPLInt
            return make(this.value % arg.intValue());
        } else {
            throw new TypeException("Cannot mod " + this + " by " + arg);
        }     
    }

    @Override
    public SMPLValue<?> pow(SMPLValue<?> arg) throws RuntimeException {
        if (arg.isReal()) { // SMPLInt ^ SMPLReal
            return make(Math.pow(this.value, arg.doubleValue()));
        } else if (arg.isInteger()) {   // SMPLInt ^ SMPLInt
            return make(Math.pow(this.value, arg.intValue()));
        } else {
            throw new TypeException("Cannot raise " + this + " to a power: " + arg);
        }     
    }

    /* Comparisons based on sign */
    @Override
    public SMPLBool cmp(SMPLValue<?> arg, String sign) throws RuntimeException {
        SMPLBool result = make(false);
        class Exc { void raise(SMPLValue<?> left, SMPLValue<?> right, String sign) throws RuntimeException{ 
            throw new TypeException("Cannot compare " + left + " and " + right + " using " + sign + " operator"); 
        }}
        
        switch (sign) {
            case "<":
                if (arg.isInteger() | arg.isBool()) result = make(value < arg.intValue());
                else if (arg.isReal())              result = make(value < arg.doubleValue());
                else                                new Exc().raise(this, arg, sign);
                break;

            case "<=":
                if (arg.isInteger() | arg.isBool()) result = make(value <= arg.intValue());
                else if (arg.isReal())              result = make(value <= arg.doubleValue());
                else                                new Exc().raise(this, arg, sign);
                break;

            case ">":
                if (arg.isInteger() | arg.isBool()) result = make(value > arg.intValue());
                else if (arg.isReal())              result = make(value > arg.doubleValue());
                else                                new Exc().raise(this, arg, sign);
                break;

            case ">=":
                if (arg.isInteger() | arg.isBool()) result = make(value > arg.intValue());
                else if (arg.isReal())              result = make(value > arg.doubleValue());
                else                                new Exc().raise(this, arg, sign);
                break;

            case "=":
                if (arg.isInteger() | arg.isBool()) result = make(value == arg.intValue());
                else if (arg.isReal())              result = make(value == arg.doubleValue());
                else                                new Exc().raise(this, arg, sign);
                break;

            case "!=":
                if (arg.isInteger() | arg.isBool()) result = make(value != arg.intValue());
                else if (arg.isReal())              result = make(value != arg.doubleValue());
                else                                new Exc().raise(this, arg, sign);
                break;
            
            default:
                throw new TypeException("Illegal comparison for data types: " + this.getType() + " and " + arg.getType());
        }

        return result;
    }

    @Override
    public SMPLInt BAnd(SMPLValue<?> arg) throws RuntimeException {
        return make(this.value & arg.intValue());
    }

    @Override
    public SMPLInt BOr(SMPLValue<?> arg) throws RuntimeException {
        return make(this.value | arg.intValue());
    }

    @Override
    public int intValue() throws RuntimeException {
        return this.value;
    }

    @Override
    public double doubleValue() throws RuntimeException {
        return (double) this.value;
    }

    @Override
    public String toString() {
        return new String(getType().toString() + this.value);
    }


}