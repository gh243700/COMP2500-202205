package academy.pocu.comp2500.assignment4;

public class ToLowercaseCommand implements ICommand {

    private int x;
    private int y;
    private Canvas canvasOrNull;

    private boolean isUndoPossible = true;
    private boolean isRedoPossible;

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
        char pixel = canvas.getPixel(x, y);
        if ((pixel < 0x61 || pixel > 0x7A) && (pixel < 0x41 || pixel > 0x5A)) {
            return false;
        }

        canvasOrNull = canvas;
        canvas.toLower(x, y);
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
        canvasOrNull.toUpper(x, y);
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
