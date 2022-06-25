package exceptions;

public class PasswordFormatException extends Exceptions{
    public PasswordFormatException() {
        super("Invalid password");
    }

    public PasswordFormatException(String message) {
        super(message);
    }
}
