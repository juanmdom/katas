package exception;

public class BadEmailFormatException extends RuntimeException{

    public BadEmailFormatException(String message) {
        super(message);
    }
}
