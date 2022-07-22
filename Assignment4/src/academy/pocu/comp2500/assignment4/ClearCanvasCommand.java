package academy.pocu.comp2500.assignment4;

public class ClearCanvasCommand implements ICommand {
    private char[][] cBackupOrNull;
    private Canvas canvasOrNull;
    @Override
    public boolean execute(Canvas canvas) {
        if (canvasOrNull != null) {
            return false;
        }

        canvasOrNull = canvas;
        cBackupOrNull = new char[canvas.getWidth()][canvas.getHeight()];
        for (int i = 0; i < cBackupOrNull.length; i++) {
            for (int j = 0; j < cBackupOrNull[0].length; j++) {
                cBackupOrNull[j][i] = canvas.getPixel(j, i);
            }
        }
        canvas.clear();
        return true;
    }

    @Override
    public boolean undo() {
        if (canvasOrNull == null) {
            return false;
        }

        for (int i = 0; i < cBackupOrNull.length; i++) {
            for (int j = 0; j < cBackupOrNull[0].length; j++) {
                canvasOrNull.drawPixel(j, i, cBackupOrNull[j][i]);
            }
        }
        return true;
    }

    @Override
    public boolean redo() {
        if (canvasOrNull == null) {
            return false;
        }

        canvasOrNull.clear();
        return true;
    }
}
