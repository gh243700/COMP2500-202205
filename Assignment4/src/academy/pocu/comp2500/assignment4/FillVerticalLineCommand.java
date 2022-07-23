package academy.pocu.comp2500.assignment4;

public class FillVerticalLineCommand implements ICommand {

    private int x;
    private char c;
    private Canvas canvasOrNull;
    private char before[];
    private boolean isUndoPossible = true;
    private boolean isRedoPossible;
    public FillVerticalLineCommand(int x, char c) {
        this.x = x;
        this.c = c;
    }

    @Override
    public boolean execute(Canvas canvas) {
        if (canvasOrNull != null || canvas.getPixel(x, 0) == Character.MAX_VALUE) {
            return false;
        }
        canvasOrNull = canvas;
        before = new char[canvas.getHeight()];
        for (int i = 0; i < before.length; i++) {
            before[i] = canvas.getPixel(x, i);
        }
        canvas.fillVerticalLine(x, c);
        return true;
    }

    @Override
    public boolean undo() {
        if (canvasOrNull == null || !isUndoPossible) {
            return false;
        }
        for (int i = 0; i < before.length; i++) {
            canvasOrNull.drawPixel(x, i, before[i]);
        }
        isUndoPossible = false;
        isRedoPossible = true;
        return true;
    }

    @Override
    public boolean redo() {
        if (canvasOrNull == null || !isRedoPossible) {
            return false;
        }
        canvasOrNull.fillVerticalLine(x, c);
        isUndoPossible = true;
        isRedoPossible = false;
        return true;
    }
}
