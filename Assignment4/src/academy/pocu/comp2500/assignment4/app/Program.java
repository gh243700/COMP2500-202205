package academy.pocu.comp2500.assignment4.app;

import academy.pocu.comp2500.assignment4.*;

public class Program {

    public static void main(String[] args) {
	    // write your code here

        Canvas canvas = new Canvas(10, 10);
        ICommand iCommand0 = new FillHorizontalLineCommand(0, 'A');
        ICommand iCommand1 = new FillHorizontalLineCommand(1, 'B');
        ICommand iCommand2 = new FillHorizontalLineCommand(2, 'C');
        ICommand iCommand3 = new FillHorizontalLineCommand(3, 'D');
        ICommand iCommand4 = new FillHorizontalLineCommand(4, 'F');


        CommandHistoryManager cm = new CommandHistoryManager(canvas);
        cm.execute(iCommand0);
        cm.execute(iCommand1);
        cm.execute(iCommand2);
        cm.execute(iCommand3);
        System.out.println(canvas.getDrawing());
        cm.undo();
        System.out.println(canvas.getDrawing());
        cm.undo();
        System.out.println(canvas.getDrawing());
        cm.redo();
        System.out.println(canvas.getDrawing());
        cm.execute(iCommand4);
        System.out.println(canvas.getDrawing());
        assert (cm.redo() == false);
    }
}
