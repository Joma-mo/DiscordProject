package exceptions;

public class InvalidDataException extends Exceptions{
    public InvalidDataException(String message) {
        super(message);
    }

    public InvalidDataException() {
        super("Invalid data");
    }
}
