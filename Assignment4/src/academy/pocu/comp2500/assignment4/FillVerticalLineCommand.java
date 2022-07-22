package academy.pocu.comp2500.assignment4;

public class FillVerticalLineCommand implements ICommand {

    private int x;
    private char c;
    private Canvas canvasOrNull;
    private char before[];

    public FillVerticalLineCommand(int x, char c) {
        this.x = x;
        this.c = c;
    }

    @Override
    public boolean execute(Canvas canvas) {
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
        for (int i = 0; i < before.length; i++) {
            canvasOrNull.drawPixel(x, i, before[i]);
        }
        return true;
    }

    @Override
    public boolean redo() {
        canvasOrNull.fillVerticalLine(x, c);
        return true;
    }
}
