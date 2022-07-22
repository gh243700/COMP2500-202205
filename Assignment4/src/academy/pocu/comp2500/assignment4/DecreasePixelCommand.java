package academy.pocu.comp2500.assignment4;

public class DecreasePixelCommand implements ICommand {

    private Canvas canvasOrNull;
    private int x;
    private int y;

    public DecreasePixelCommand(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean execute(Canvas canvas) {
        this.canvasOrNull = canvas;
        return canvas.decreasePixel(x, y);
    }

    @Override
    public boolean undo() {
        return canvasOrNull.increasePixel(x, y);
    }

    @Override
    public boolean redo() {
        return canvasOrNull.increasePixel(x, y);
    }
}
