package academy.pocu.comp2500.assignment4;

public class ToLowercaseCommand implements ICommand {

    private int x;
    private int y;
    private Canvas canvasOrNull;

    private boolean isUndoPossible = true;
    private boolean isRedoPossible;

    private char cBackup;
    private String sBackup;

    public ToLowercaseCommand(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean execute(Canvas canvas) {
        if (canvasOrNull != null || canvas.getPixel(x, y) == Character.MAX_VALUE) {
            return false;
        }

        canvasOrNull = canvas;
        cBackup = canvas.getPixel(x, y);
        canvas.toLower(x, y);
        sBackup = canvas.getDrawing();
        return true;
    }

    @Override
    public boolean undo() {
        if (canvasOrNull == null) {
            return false;
        }
        if (!isUndoPossible || !sBackup.equals(canvasOrNull.getDrawing())) {
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
        canvasOrNull.toLower(x, y);
        sBackup = canvasOrNull.getDrawing();
        return true;
    }

}
