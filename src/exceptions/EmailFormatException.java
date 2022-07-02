package exceptions;

/**
 * Throws exception when email format has no @ in it.
 */
public class EmailFormatException extends Exceptions{
    public EmailFormatException(String message) {
        super(message);
    }
    public EmailFormatException() {
        super("Invalid email");
    }
}
