package academy.pocu.comp2500.assignment4;

public class FillHorizontalLineCommand implements ICommand {

    private int y;
    private char c;
    private char[] before;
    private Canvas canvasOrNull;

    public FillHorizontalLineCommand(int y, char c) {
        this.y = y;
        this.c = c;
    }

    @Override
    public boolean execute(Canvas canvas) {
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
        for (int i = 0; i < before.length; i++) {
            canvasOrNull.drawPixel(i, y, before[i]);
        }
        return true;
    }

    @Override
    public boolean redo() {
        canvasOrNull.fillHorizontalLine(y, c);
        return true;
    }
}
