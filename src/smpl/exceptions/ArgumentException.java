package smpl.exceptions;

public class ArgumentException extends RuntimeException {

    public ArgumentException(int paramSize, int argSize) {
        super(String.format("Expected %d argument(s) but got %d", paramSize, argSize));
    }
}