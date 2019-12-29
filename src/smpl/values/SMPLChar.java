package smpl.values;

import smpl.exceptions.SMPLException;

public class SMPLChar extends SMPLValue<SMPLChar>{

    Character value;

    public SMPLChar() { this('a'); }

    public SMPLChar(Character value) {
        this.value = value;
    }

    @Override
    public SMPLType getType() {
        return SMPLType.CHAR;
    }

    @Override
    public String toString() {
        return new String(getType().toString() + "#c" + this.value);
    }

}