package exceptions;

/**
 * Throws exception when data is invalid.
 */
public class InvalidDataException extends Exceptions{
    public InvalidDataException(String message) {
        super(message);
    }

    public InvalidDataException() {
        super("Invalid data");
    }
}
