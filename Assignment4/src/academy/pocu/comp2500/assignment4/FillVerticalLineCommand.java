package academy.pocu.comp2500.assignment4;

public class FillVerticalLineCommand implements ICommand {

    private int x;
    private char c;
    private Canvas canvasOrNull;
    private char before[];
    private String sBackup;
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
        sBackup = canvas.getDrawing();
        return true;
    }

    @Override
    public boolean undo() {
        if (canvasOrNull == null) {
            return false;
        }
        if(!isUndoPossible || !sBackup.equals(canvasOrNull.getDrawing())) {
            return false;
        }
        for (int i = 0; i < before.length; i++) {
            canvasOrNull.drawPixel(x, i, before[i]);
        }

        isUndoPossible = false;
        isRedoPossible = true;
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

        canvasOrNull.fillVerticalLine(x, c);
        sBackup = canvasOrNull.getDrawing();
        return true;
    }
}
