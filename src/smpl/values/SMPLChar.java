package smpl.values;

import java.io.*;
import smpl.exceptions.SMPLException;

public class SMPLChar extends SMPLValue<SMPLChar>{

    String value;

    public SMPLChar() { this("a"); }

    public SMPLChar(String value) {
        this.value = value;
    }

    @Override
    public SMPLType getType() {
        return SMPLType.CHAR;
    }

    @Override
    public String toString() {
        return new String(getType().toString() + this.value);
    }

}