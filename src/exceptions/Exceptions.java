package exceptions;

public class Exceptions extends Exception{
    public Exceptions(String message) {
        super(message);
    }

    public Exceptions() {
        super("An Error Occur");
    }
}
