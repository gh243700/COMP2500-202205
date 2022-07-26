package academy.pocu.comp2500.lab11;

public class OverflowException extends RuntimeException {
    private String message;

    @Override
    public String getMessage() {
        return message;
    }

    public OverflowException(String message) {
        this.message = message;
    }
}
