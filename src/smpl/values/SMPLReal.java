package smpl.values;

import smpl.exceptions.RuntimeException;
import smpl.exceptions.TypeException;

public class SMPLReal extends SMPLValue<SMPLReal> {

    double value;

    public SMPLReal() { this(0D); }

    public SMPLReal(Double value) {
        this.value = value;
    }

    @Override
    public SMPLType getType() {
        return SMPLType.REAL;
    }

    @Override
    public SMPLValue<?> add(SMPLValue<?> arg) throws RuntimeException {
        System.out.println(arg);
        if (arg.isReal()) { // SMPLReal + SMPLReal
            return make(this.value + arg.doubleValue());
        } else if (arg.isInteger()) {   // SMPLReal + SMPLInt
            return make(this.value + arg.intValue());
        } else {
            throw new TypeException("Cannot add " + arg + " to " + this);
        }        
    }

    @Override
    public SMPLValue<?> sub(SMPLValue<?> arg) throws RuntimeException {
        if (arg.isReal()) { // SMPLReal - SMPLReal
            return make(this.value - arg.doubleValue());
        } else if (arg.isInteger()) {   // SMPLReal - SMPLInt
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
        if (arg.isReal()) { // SMPLReal * SMPLReal
            return make(this.value * arg.doubleValue());
        } else if (arg.isInteger()) {   // SMPLReal * SMPLInt
            return make(this.value * arg.intValue());
        } else {
            throw new TypeException("Cannot multiply " + this + " by " + arg);
        }     
    }

    @Override
    public SMPLValue<?> div(SMPLValue<?> arg) throws RuntimeException {
        if (arg.isReal()) { // SMPLReal / SMPLReal
            return make(this.value / arg.doubleValue());
        } else if (arg.isInteger()) {   // SMPLReal / SMPLInt
            return make(this.value / arg.intValue());
        } else {
            throw new TypeException("Cannot divide " + this + " by " + arg);
        }     
    }

    @Override
    public SMPLValue<?> mod(SMPLValue<?> arg) throws RuntimeException {
        if (arg.isReal()) { // SMPLReal % SMPLReal
            return make(this.value % arg.doubleValue());
        } else if (arg.isInteger()) {   // SMPLReal % SMPLInt
            return make(this.value % arg.intValue());
        } else {
            throw new TypeException("Cannot mod " + this + " by " + arg);
        }     
    }

    @Override
    public SMPLValue<?> pow(SMPLValue<?> arg) throws RuntimeException {
        if (arg.isReal()) { // SMPLReal ^ SMPLReal
            return make(Math.pow(this.value, arg.doubleValue()));
        } else if (arg.isInteger()) {   // SMPLReal ^ SMPLInt
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
    public int intValue() throws RuntimeException {
        return (int)this.value;
    }

    @Override
    public double doubleValue() throws RuntimeException {
        return this.value;
    }

    @Override
    public String toString() {
        return String.valueOf(this.value);
    }
}