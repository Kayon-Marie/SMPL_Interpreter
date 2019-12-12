package smpl.values;

import smpl.exceptions.SMPLException;

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
    public SMPLValue<?> add(SMPLValue<?> arg) throws SMPLException {
        System.out.println(arg);
        if (arg.isReal()) { // SMPLReal + SMPLReal
            return make(this.value + arg.doubleValue());
        } else if (arg.isInteger()) {   // SMPLReal + SMPLInt
            return make(this.value + arg.intValue());
        } else {
            throw new SMPLException("Cannot add " + arg + " to " + this);
        }        
    }

    @Override
    public SMPLValue<?> sub(SMPLValue<?> arg) throws SMPLException {
        if (arg.isReal()) { // SMPLReal - SMPLReal
            return make(this.value - arg.doubleValue());
        } else if (arg.isInteger()) {   // SMPLReal - SMPLInt
            return make(this.value - arg.intValue());
        } else {
            throw new SMPLException("Cannot subtract " + arg + " from " + this);
        }     
    }

    @Override
    public SMPLValue<?> neg() throws SMPLException {
        return make(this.value * -1);
    }

    @Override
    public SMPLValue<?> mul(SMPLValue<?> arg) throws SMPLException {
        if (arg.isReal()) { // SMPLReal * SMPLReal
            return make(this.value * arg.doubleValue());
        } else if (arg.isInteger()) {   // SMPLReal * SMPLInt
            return make(this.value * arg.intValue());
        } else {
            throw new SMPLException("Cannot multiply " + this + " by " + arg);
        }     
    }

    @Override
    public SMPLValue<?> div(SMPLValue<?> arg) throws SMPLException {
        if (arg.isReal()) { // SMPLReal / SMPLReal
            return make(this.value / arg.doubleValue());
        } else if (arg.isInteger()) {   // SMPLReal / SMPLInt
            return make(this.value / arg.intValue());
        } else {
            throw new SMPLException("Cannot divide " + this + " by " + arg);
        }     
    }

    @Override
    public SMPLValue<?> mod(SMPLValue<?> arg) throws SMPLException {
        if (arg.isReal()) { // SMPLReal % SMPLReal
            return make(this.value % arg.doubleValue());
        } else if (arg.isInteger()) {   // SMPLReal % SMPLInt
            return make(this.value % arg.intValue());
        } else {
            throw new SMPLException("Cannot mod " + this + " by " + arg);
        }     
    }

    @Override
    public SMPLValue<?> pow(SMPLValue<?> arg) throws SMPLException {
        if (arg.isReal()) { // SMPLReal ^ SMPLReal
            return make(Math.pow(this.value, arg.doubleValue()));
        } else if (arg.isInteger()) {   // SMPLReal ^ SMPLInt
            return make(Math.pow(this.value, arg.intValue()));
        } else {
            throw new SMPLException("Cannot raise " + this + " to a power: " + arg);
        }     
    }

    @Override
    public int intValue() throws SMPLException {
        return (int)this.value;
    }

    @Override
    public double doubleValue() throws SMPLException {
        return this.value;
    }

    @Override
    public String toString() {
        return new String(getType().toString() + this.value);
    }
}