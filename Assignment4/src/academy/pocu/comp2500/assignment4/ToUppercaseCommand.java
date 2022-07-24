package academy.pocu.comp2500.assignment4;

public class ToUppercaseCommand implements ICommand {
    private int x;
    private int y;
    private Canvas canvasOrNull;

    private boolean isUndoPossible = true;
    private boolean isRedoPossible;
    private String sBackup;

    private char cBackup;
    public ToUppercaseCommand(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean execute(Canvas canvas) {
        if (canvasOrNull != null || canvas.getPixel(x, y) == Character.MAX_VALUE) {
            return false;
        }

        this.canvasOrNull = canvas;
        cBackup = canvas.getPixel(x, y);
        canvas.toUpper(x, y);
        sBackup = canvas.getDrawing();
        return true;
    }

    @Override
    public boolean undo() {
        if (canvasOrNull == null) {
            return false;
        }
        if(!isUndoPossible || !sBackup.equals(canvasOrNull.getDrawing())) {
            return false;
        }

        isUndoPossible = false;
        isRedoPossible = true;
        canvasOrNull.drawPixel(x, y, cBackup);
        sBackup = canvasOrNull.getDrawing();
        return true;
    }

    @Override
    public boolean redo() {
        if (canvasOrNull == null) {
            return false;
        }

        if (!isRedoPossible || !sBackup.equals(canvasOrNull.getDrawing())) {
            return false;
        }
        isUndoPossible = true;
        isRedoPossible = false;
        cBackup = canvasOrNull.getPixel(x, y);
        canvasOrNull.toUpper(x, y);

        sBackup = canvasOrNull.getDrawing();
        return true;
    }
}
