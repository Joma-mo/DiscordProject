package exceptions;

/**
 * Throws exception when phone number format is invalid.
 */
public class PhoneNumberFormatException extends Exceptions{
    public PhoneNumberFormatException() {
        super("Invalid phoneNumber");
    }

    public PhoneNumberFormatException(String message) {
        super(message);
    }
}
