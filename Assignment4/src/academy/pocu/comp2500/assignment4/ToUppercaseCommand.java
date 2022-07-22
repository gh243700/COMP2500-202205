package academy.pocu.comp2500.assignment4;

public class ToUppercaseCommand implements ICommand {

    private int x;
    private int y;
    private Canvas canvasOrNull;

    public ToUppercaseCommand(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean execute(Canvas canvas) {
        if (canvasOrNull != null) {
            return false;
        }
        this.canvasOrNull = canvas;
        canvas.toUpper(x, y);
        return true;
    }

    @Override
    public boolean undo() {
        if (canvasOrNull == null) {
            return false;
        }
        canvasOrNull.toLower(x, y);
        return true;
    }

    @Override
    public boolean redo() {
        if (canvasOrNull == null) {
            return false;
        }
        canvasOrNull.toUpper(x, y);
        return true;
    }
}
