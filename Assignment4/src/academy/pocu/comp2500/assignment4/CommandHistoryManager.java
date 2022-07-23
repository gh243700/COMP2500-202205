package academy.pocu.comp2500.assignment4;

import java.util.ArrayList;

public class CommandHistoryManager {
    private Canvas canvas;
    private String sBackup;
    private ArrayList<ICommand> executedCommands = new ArrayList<>();
    private ArrayList<ICommand> undoneCommands = new ArrayList<>();

    public CommandHistoryManager(Canvas canvas)
    {
        this.canvas = canvas;
        sBackup = canvas.getDrawing();
    }
    public boolean execute(ICommand iCommand) {
        if (!sBackup.equals(canvas.getDrawing()) || iCommand.execute(canvas) == false) {
            return false;
        }
        executedCommands.add(iCommand);
        undoneCommands.removeAll(undoneCommands);
        sBackup = canvas.getDrawing();
        return true;
    }

    public boolean canUndo() {
        return executedCommands.size() > 0;
    }

    public boolean canRedo() {
        return undoneCommands.size() > 0;
    }

    public boolean undo() {
        if (!sBackup.equals(canvas.getDrawing()) || canUndo() == false) {
            return false;
        }
        int index = executedCommands.size() - 1;
        ICommand iCommand = executedCommands.get(index);

        if (iCommand.undo() == false) {
            return false;
        }

        executedCommands.remove(index);
        undoneCommands.add(iCommand);
        sBackup = canvas.getDrawing();
        return true;
    }

    public boolean redo() {
        if (!sBackup.equals(canvas.getDrawing()) || canRedo() == false) {
            return false;
        }
        int index = undoneCommands.size() - 1;
        ICommand iCommand = undoneCommands.get(index);

        undoneCommands.remove(index);

        if (!iCommand.redo()) {
            return false;
        }

        executedCommands.add(iCommand);
        sBackup = canvas.getDrawing();
        return true;
    }
}
