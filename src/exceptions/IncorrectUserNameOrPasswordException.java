package exceptions;

public class IncorrectUserNameOrPasswordException extends Exceptions{
    public IncorrectUserNameOrPasswordException() {
        super("Incorrect userName or password");
    }

    public IncorrectUserNameOrPasswordException(String message) {
        super(message);
    }
}
