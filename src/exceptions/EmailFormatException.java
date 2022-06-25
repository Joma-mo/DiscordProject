package exceptions;

public class EmailFormatException extends Exceptions{
    public EmailFormatException(String message) {
        super(message);
    }
    public EmailFormatException() {
        super("Invalid email");
    }
}
