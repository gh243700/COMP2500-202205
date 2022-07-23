package academy.pocu.comp2500.assignment4;

public class DecreasePixelCommand implements ICommand {
    private Canvas canvasOrNull;
    private int x;
    private int y;
    private boolean isUndoPossible = true;
    private boolean isRedoPossible;
    public DecreasePixelCommand(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean execute(Canvas canvas) {
        if (canvasOrNull != null || !canvas.decreasePixel(x, y)) {
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
        canvasOrNull.increasePixel(x, y);
        isUndoPossible = false;
        isRedoPossible = true;
        return true;
    }

    @Override
    public boolean redo() {
        if (canvasOrNull == null || !isRedoPossible) {
            return false;
        }
        canvasOrNull.decreasePixel(x, y);
        isUndoPossible = true;
        isRedoPossible = false;
        return true;
    }
}
