package smpl.values;

import smpl.exceptions.RuntimeException;

/**
 *
 * @author newts
 */
public class TypeSMPLException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public TypeSMPLException() {
        super("Type Error");
    }
    
    public TypeSMPLException(String message) {
        super(message);
    }
    
    public TypeSMPLException(SMPLType expected, SMPLType received) {
        super("Type Error: Expected " + expected + " but got " + received);
    }
    
    public TypeSMPLException(String message, Throwable cause) {
        super(message, cause);
    }
    
}