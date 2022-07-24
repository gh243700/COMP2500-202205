package academy.pocu.comp2500.assignment4;

public class DrawPixelCommand implements ICommand{
    private int x;
    private int y;
    private char c;
    private Canvas canvasOrNull;
    private boolean isUndoPossible = true;

    private boolean isRedoPossible = true;
    private char cBackup;

    public DrawPixelCommand(int x, int y, char c) {
        this.x = x;
        this.y = y;
        this.c = c;
    }

    @Override
    public boolean execute(Canvas canvas) {
        if (canvasOrNull != null) {
            return false;
        }
        this.canvasOrNull = canvas;
        cBackup = canvas.getPixel(x, y);
        canvas.drawPixel(x, y, c);
        if (canvas.getPixel(x, y) == cBackup) {
            return false;
        }
        return true;
    }

    @Override
    public boolean undo() {
        if (canvasOrNull == null || !isUndoPossible || c != canvasOrNull.getPixel(x, y)) {
            return false;
        }
        canvasOrNull.drawPixel(x , y, cBackup);
        isUndoPossible = false;
        isRedoPossible = true;
        return true;
    }

    @Override
    public boolean redo() {
        if (canvasOrNull == null || !isRedoPossible) {
            return false;
        }

        canvasOrNull.drawPixel(x, y, c);
        isUndoPossible = true;
        isRedoPossible = false;
        return true;
    }
}
