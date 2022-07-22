package academy.pocu.comp2500.assignment4;

public class IncreasePixelCommand implements ICommand {

    private int x;
    private int y;
    private Canvas canvasOrNull;

    public IncreasePixelCommand(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean execute(Canvas canvas) {
        this.canvasOrNull = canvas;
        return canvas.increasePixel(x, y);
    }

    @Override
    public boolean undo() {
        return canvasOrNull.decreasePixel(x, y);
    }

    @Override
    public boolean redo() {
        return canvasOrNull.increasePixel(x, y);
    }
}
