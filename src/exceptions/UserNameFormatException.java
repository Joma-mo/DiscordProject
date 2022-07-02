package exceptions;

/**
 * Throws exception when username is invalid.
 */
public class UserNameFormatException extends Exceptions{
    public UserNameFormatException(String message) {
        super(message);
    }

    public UserNameFormatException() {
        super("Invalid userName");
    }
}
