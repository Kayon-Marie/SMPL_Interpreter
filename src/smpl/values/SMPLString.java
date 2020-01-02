package smpl.values;

import smpl.exceptions.SMPLException;

public class SMPLString extends SMPLValue<SMPLString>{

    String value;

    public SMPLString() { this("a"); }

    public SMPLString(String value) {
        this.value = value;
    }

    @Override
    public String strValue() throws RuntimeException {
        return this.value;
    }

    @Override
    public SMPLType getType() {
        return SMPLType.STRING;
    }

    @Override
    public String toString() {
        return new String(getType().toString() + String.valueOf(value));
    }

}