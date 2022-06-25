package exceptions;

public class UserNameFormatException extends Exceptions{
    public UserNameFormatException(String message) {
        super(message);
    }

    public UserNameFormatException() {
        super("Invalid userName");
    }
}
