package academy.pocu.comp2500.assignment4;

public class ClearCanvasCommand implements ICommand {
    private char[][] cBackupOrNull;
    private Canvas canvasOrNull;

    private boolean isUndoPossible = true;
    private boolean isRedoPossible;

    private String sBackup;

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
        for (int i = 0; i < cBackupOrNull[0].length; i++) {
            for (int j = 0; j < cBackupOrNull.length; j++) {
                canvasOrNull.drawPixel(j, i, cBackupOrNull[j][i]);
            }
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

        canvasOrNull.clear();
        isUndoPossible = true;
        isRedoPossible = false;

        sBackup = canvasOrNull.getDrawing();

        return true;
    }
}
