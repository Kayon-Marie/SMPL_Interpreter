package smpl.exceptions;

import smpl.values.SMPLType;

public class TypeException extends SMPLException {

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
    
    public TypeException(String message, Throwable cause) {
        super(message, cause);
    }

}