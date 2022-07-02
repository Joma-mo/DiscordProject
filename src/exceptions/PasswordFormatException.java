package exceptions;

/**
 * Throws exception when password is invalid.
 */
public class PasswordFormatException extends Exceptions{
    public PasswordFormatException() {
        super("Invalid password");
    }

    public PasswordFormatException(String message) {
        super(message);
    }
}
