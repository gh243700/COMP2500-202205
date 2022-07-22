package academy.pocu.comp2500.assignment4;

public interface ICommand {
    //no more methods allowed
    boolean execute(Canvas canvas);
    boolean undo();
    boolean redo();
}
