package academy.pocu.comp2500.lab11;

public class OverflowException extends RuntimeException {
    @Override
    public String getMessage() {
        return super.getMessage();
    }

    public OverflowException(String message) {
        super(message);
    }
}
