package academy.pocu.comp2500.assignment4;

public class IncreasePixelCommand implements ICommand {

    private int x;
    private int y;
    private Canvas canvasOrNull;

    private boolean isUndoPossible = true;
    private boolean isRedoPossible;
    private String sBackup;

    public IncreasePixelCommand(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean execute(Canvas canvas) {
        if (canvasOrNull != null) {
            return false;
        }
        if (!canvas.increasePixel(x, y)) {
            return false;
        }
        this.canvasOrNull = canvas;
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
        if (!canvasOrNull.decreasePixel(x, y)) {
            return false;
        }

        isUndoPossible = false;
        isRedoPossible = true;
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
        canvasOrNull.increasePixel(x, y);
        sBackup = canvasOrNull.getDrawing();
        return true;
    }
}
