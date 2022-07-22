package academy.pocu.comp2500.assignment4;

public class DrawPixelCommand implements ICommand{
    private final char INITIAL_PIXEL = ' ';
    private int x;
    private int y;
    private char c;
    private Canvas canvasOrNull;

    public DrawPixelCommand(int x, int y, char c) {
        this.x = x;
        this.y = y;
        this.c = c;
    }

    @Override
    public boolean execute(Canvas canvas) {
        this.canvasOrNull = canvas;
        canvas.drawPixel(x, y, c);
        return true;
    }

    @Override
    public boolean undo() {
        canvasOrNull.drawPixel(x , y, INITIAL_PIXEL);
        return true;
    }

    @Override
    public boolean redo() {
        canvasOrNull.drawPixel(x, y, c);
        return true;
    }
}
