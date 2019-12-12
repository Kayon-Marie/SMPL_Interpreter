package smpl.values;

import smpl.exceptions.VisitException;

public class TypeException extends VisitException {

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