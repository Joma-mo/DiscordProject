package exceptions;

/**
 * Throws an exception when data is already exists.
 */
public class DataHasAlreadyExistException extends Exceptions{
     public DataHasAlreadyExistException() {
         super("Data Has Already Exist");
     }

     public DataHasAlreadyExistException(String message) {
         super(message);
     }
}
