package smpl.exceptions;

public class ArgumentException extends RuntimeException {

    public ArgumentException(int paramSize, int argSize) {
        super(String.format("Expected %d arguments but got %d", paramSize, argSize));
    }
}