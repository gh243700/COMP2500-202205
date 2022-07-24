package academy.pocu.comp2500.assignment4;

import java.util.ArrayList;

public class CommandHistoryManager {
    private Canvas canvas;
    private ArrayList<ICommand> executedCommands = new ArrayList<>();
    private ArrayList<ICommand> undoneCommands = new ArrayList<>();

    public CommandHistoryManager(Canvas canvas) {
        this.canvas = canvas;
    }

    public boolean execute(ICommand iCommand) {
        if (iCommand.execute(canvas) == false) {
            return false;
        }
        undoneCommands.removeAll(undoneCommands);
        executedCommands.add(iCommand);
        return true;
    }

    public boolean canUndo() {
        return executedCommands.size() > 0;
    }

    public boolean canRedo() {
        return undoneCommands.size() > 0;
    }

    public boolean undo() {
        if (canUndo() == false) {
            return false;
        }
        int index = executedCommands.size() - 1;
        ICommand iCommand = executedCommands.get(index);

        if (iCommand.undo() == false) {
            return false;
        }
        executedCommands.remove(index);
        undoneCommands.add(iCommand);
        return true;
    }

    public boolean redo() {
        if (canRedo() == false) {
            return false;
        }
        int index = undoneCommands.size() - 1;
        ICommand iCommand = undoneCommands.get(index);

        if (iCommand.redo() == false) {
            return false;
        }

        undoneCommands.remove(index);
        executedCommands.add(iCommand);
        return true;
    }
}
