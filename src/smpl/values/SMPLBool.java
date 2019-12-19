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