package academy.pocu.comp2500.assignment4;

public class ClearCanvasCommand implements ICommand {
    private char[][] cBackupOrNull;
    private Canvas canvasOrNull;
    private boolean isUndoPossible = true;
    private boolean isRedoPossible;
    @Override
    public boolean execute(Canvas canvas) {
        if (canvasOrNull != null) {
            return false;
        }

        canvasOrNull = canvas;
        cBackupOrNull = new char[canvas.getWidth()][canvas.getHeight()];
        for (int i = 0; i < cBackupOrNull[0].length; i++) {
            for (int j = 0; j < cBackupOrNull.length; j++) {
                cBackupOrNull[j][i] = canvas.getPixel(j, i);
            }
        }
        canvas.clear();
        return true;
    }

    @Override
    public boolean undo() {
        if (canvasOrNull == null || !isUndoPossible) {
            return false;
        }

        for (int i = 0; i < cBackupOrNull[0].length; i++) {
            for (int j = 0; j < cBackupOrNull.length; j++) {
                canvasOrNull.drawPixel(j, i, cBackupOrNull[j][i]);
            }
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

        canvasOrNull.clear();

        isUndoPossible = true;
        isRedoPossible = false;
        return true;
    }
}
