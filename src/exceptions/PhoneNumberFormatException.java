package exceptions;

public class PhoneNumberFormatException extends Exceptions{
    public PhoneNumberFormatException() {
        super("Invalid phoneNumber");
    }

    public PhoneNumberFormatException(String message) {
        super(message);
    }
}
