package academy.pocu.comp2500.lab11;

public class OverflowException extends RuntimeException {
    private static final long serialVersionUID = 12l;
    @Override
    public String getMessage() {
        return super.getMessage();
    }
    public OverflowException(String message) {
        super(message);
    }


}
