package academy.pocu.comp2500.assignment4;

public class ToLowercaseCommand implements ICommand {

    private int x;
    private int y;
    private Canvas canvasOrNull;

    private boolean isUndoCalled;

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
        canvas.toLower(x, y);
        return true;
    }

    @Override
    public boolean undo() {
        if (canvasOrNull == null) {
            return false;
        }
        isUndoCalled = true;
        canvasOrNull.toUpper(x, y);
        return true;
    }

    @Override
    public boolean redo() {
        if (canvasOrNull == null || !isUndoCalled) {
            return false;
        }
        canvasOrNull.toUpper(x, y);
        return true;
    }

}
