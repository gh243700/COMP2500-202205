package academy.pocu.comp2500.assignment4;

public class ToUppercaseCommand implements ICommand {
    private int x;
    private int y;
    private Canvas canvasOrNull;
    private boolean isUndoPossible = true;
    private boolean isRedoPossible;

    public ToUppercaseCommand(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean execute(Canvas canvas) {
        if (canvasOrNull != null || canvas.getPixel(x, y) == Character.MAX_VALUE) {
            return false;
        }
        if (canvas.getPixel(x, y) < 0x61 || canvas.getPixel(x, y) > 0x7A) {
            return false;
        }
        canvas.toUpper(x, y);
        this.canvasOrNull = canvas;
        return true;
    }

    @Override
    public boolean undo() {
        if (canvasOrNull == null || !isUndoPossible) {
            return false;
        }
        canvasOrNull.toLower(x, y);
        isUndoPossible = false;
        isRedoPossible = true;
        return true;
    }

    @Override
    public boolean redo() {
        if (canvasOrNull == null || !isRedoPossible) {
            return false;
        }
        canvasOrNull.toUpper(x, y);
        isUndoPossible = true;
        isRedoPossible = false;
        return true;
    }
}
