package academy.pocu.comp2500.assignment4;

public class FillHorizontalLineCommand implements ICommand {

    private int y;
    private char c;
    private char[] before;
    private Canvas canvasOrNull;

    private String sBackup;
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
        sBackup = canvas.getDrawing();
        return true;
    }

    @Override
    public boolean undo() {
        if (canvasOrNull == null) {
            return false;
        }

        if (!isUndoPossible || !sBackup.equals(canvasOrNull.getDrawing())) {
            return false;
        }
        isUndoPossible = false;
        isRedoPossible = true;
        for (int i = 0; i < before.length; i++) {
            canvasOrNull.drawPixel(i, y, before[i]);
        }
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
        canvasOrNull.fillHorizontalLine(y, c);
        sBackup = canvasOrNull.getDrawing();
        return true;
    }
}
