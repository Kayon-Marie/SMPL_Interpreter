package smpl.exceptions;

public class SMPLException extends VisitException {

    private static final long serialVersionUID = 1L;

    public SMPLException() {
        super("SMPL Exception");
    }

    public SMPLException(String msg) {
        super(msg);
    }
    
    public SMPLException(String message, Throwable cause) {
        super(message, cause);
    }
}