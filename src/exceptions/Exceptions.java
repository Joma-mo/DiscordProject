package exceptions;

/**
 * Father of all exceptions we used in our project.
 */
public class Exceptions extends Exception{
    public Exceptions(String message) {
        super(message);
    }

    public Exceptions() {
        super("An Error Occur");
    }
}
