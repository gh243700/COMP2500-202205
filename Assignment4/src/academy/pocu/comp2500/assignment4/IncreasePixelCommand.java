package academy.pocu.comp2500.assignment4;

public class IncreasePixelCommand implements ICommand {

    private int x;
    private int y;
    private Canvas canvasOrNull;
    private boolean isUndoPossible = true;
    private boolean isRedoPossible;
    public IncreasePixelCommand(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean execute(Canvas canvas) {
        if (canvasOrNull != null || !canvas.increasePixel(x, y)) {
            return false;
        }
        this.canvasOrNull = canvas;
        return true;
    }

    @Override
    public boolean undo() {
        if (canvasOrNull == null || !isUndoPossible) {
            return false;
        }
        canvasOrNull.decreasePixel(x, y);
        isUndoPossible = false;
        isRedoPossible = true;
        return true;
    }

    @Override
    public boolean redo() {
        if (canvasOrNull == null || !isRedoPossible) {
            return false;
        }
        canvasOrNull.increasePixel(x, y);
        isUndoPossible = true;
        isRedoPossible = false;

        return true;
    }
}
