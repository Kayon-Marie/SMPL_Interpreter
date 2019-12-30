package smpl.values;

import smpl.exceptions.SMPLException;

public class SMPLChar extends SMPLValue<SMPLChar>{

    char value;

    public SMPLChar() { this('a'); }

    public SMPLChar(char value) {
        this.value = value;
    }

    @Override
    public SMPLType getType() {
        return SMPLType.CHAR;
    }

    @Override
    public String toString() {
        return new String(getType().toString() + "#c" + String.valueOf(value));
    }

}