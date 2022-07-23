package academy.pocu.comp2500.assignment4;

public class FillHorizontalLineCommand implements ICommand {

    private int y;
    private char c;
    private char[] before;
    private Canvas canvasOrNull;

    private boolean isUndoPossible = true;
    private boolean isRedoPossible;
    public FillHorizontalLineCommand(int y, char c) {
        this.y = y;
        this.c = c;
    }

    @Override
    public boolean execute(Canvas canvas) {
        if (canvasOrNull != null || canvas.getPixel(0, y) == Character.MAX_VALUE) {
            return false;
        }
        canvasOrNull = canvas;
        before = new char[canvas.getWidth()];
        for (int i = 0; i < before.length; i++) {
            before[i] = canvas.getPixel(i, y);
        }
        canvas.fillHorizontalLine(y, c);
        return true;
    }

    @Override
    public boolean undo() {
        if (canvasOrNull == null || !isUndoPossible) {
            return false;
        }

        for (int i = 0; i < before.length; i++) {
            canvasOrNull.drawPixel(i, y, before[i]);
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
        canvasOrNull.fillHorizontalLine(y, c);
        isUndoPossible = true;
        isRedoPossible = false;
        return true;
    }
}
