package smpl.exceptions;

import smpl.values.SMPLType;
import smpl.values.SMPLValue;

public class TypeException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public TypeException() {
        super("Type Error");
    }

    public TypeException(String msg) {
        super(msg);
    }

    public TypeException(SMPLType expected, SMPLType received) {
        super("Type Error: Expected " + expected + " but got " + received);
    }

    public TypeException(String op, SMPLValue<?> left, SMPLValue<?> right) {
        super("Operation " + op + "not allowed between types " + left.getType() + " and " + right.getType());
    }
    
    public TypeException(String message, Throwable cause) {
        super(message, cause);
    }

}