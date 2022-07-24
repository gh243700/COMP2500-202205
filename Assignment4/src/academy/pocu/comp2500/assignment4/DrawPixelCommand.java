package academy.pocu.comp2500.assignment4;

public class DrawPixelCommand implements ICommand{
    private int x;
    private int y;
    private char c;
    private Canvas canvasOrNull;
    private boolean isUndoPossible = true;
    private boolean isRedoPossible;
    private char cBackup;

    private String sBackup;

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
        sBackup = canvas.getDrawing();
        return true;
    }

    @Override
    public boolean undo() {
        if (canvasOrNull == null || c != canvasOrNull.getPixel(x, y)) {
            return false;
        }

        if(!isUndoPossible || !sBackup.equals(canvasOrNull.getDrawing())) {
            return false;
        }
        isUndoPossible = false;
        isRedoPossible = true;
        canvasOrNull.drawPixel(x , y, cBackup);
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

        canvasOrNull.drawPixel(x, y, c);

        sBackup = canvasOrNull.getDrawing();
        return true;
    }
}
