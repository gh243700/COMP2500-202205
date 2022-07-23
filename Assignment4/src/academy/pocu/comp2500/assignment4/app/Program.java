package academy.pocu.comp2500.assignment4.app;

import academy.pocu.comp2500.assignment4.*;

public class Program {

    public static void main(String[] args) {
	    // write your code here
        System.out.println(ClearCanvasCommand.class.getSimpleName());

        {
            Canvas canvas = new Canvas(10, 5);
            assert (canvas.getWidth() == 10);
            assert (canvas.getHeight() == 5);
            canvas.drawPixel(0, 0, 'a');
            System.out.println(canvas.getDrawing());
            canvas.increasePixel(0, 0);
            System.out.println(canvas.getDrawing());
            assert (canvas.increasePixel(1, 1) == true);
            canvas.toUpper(0,0);
            assert(canvas.getPixel(0,0) == 'B');
            canvas.fillHorizontalLine(0, 'q');
            System.out.println(canvas.getDrawing());
        }

        Canvas canvas = new Canvas(10, 10);
        ICommand iCommand0 = new DrawPixelCommand(0, 0, '*');
        ICommand iCommand1 = new DrawPixelCommand(1, 2, '$');
        ICommand iCommand2 = new DrawPixelCommand(0, 1, '&');

        CommandHistoryManager cm = new CommandHistoryManager(canvas);

        cm.execute(iCommand0);
        assert (cm.redo() == false);
        assert(cm.undo() == true);
        System.out.println(canvas.getDrawing());
        cm.execute(iCommand1);
        System.out.println(canvas.getDrawing());
        cm.execute(iCommand2);
        System.out.println(canvas.getDrawing());

        assert(cm.canUndo() == true);
        cm.undo();
        System.out.println(canvas.getDrawing());
        assert (cm.canRedo() == true);
        cm.redo();
        System.out.println(canvas.getDrawing());

        ICommand iCommand3 = new DrawPixelCommand(1, 0, '^');
        cm.undo();
        cm.undo();
        cm.execute(iCommand3);
        assert(cm.canRedo() == false);
        System.out.println(canvas.getDrawing());
        cm.undo();
        System.out.println(canvas.getDrawing());
        cm.redo();
        System.out.println(canvas.getDrawing());


        OverdrawAnalyzer oa = new OverdrawAnalyzer(10, 10);
        oa.fillHorizontalLine(0, 'p');
        oa.clear();
    }
}
