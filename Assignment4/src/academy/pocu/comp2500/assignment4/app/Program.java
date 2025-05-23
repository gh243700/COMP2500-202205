package academy.pocu.comp2500.assignment4.app;

import academy.pocu.comp2500.assignment4.*;

import java.util.ArrayList;
import java.util.LinkedList;


public class Program {

    public static void main(String[] args) {
	    // write your code here

        {
            LinkedList<Character> linkedList = new LinkedList<>();



        }
        Canvas canvas = new Canvas(10, 10);
        CommandHistoryManager cm = new CommandHistoryManager(canvas);

        ICommand iCommand0 = new DrawPixelCommand(0, 0, 'A');
        cm.execute(iCommand0);
        ICommand iCommand1 = new ToLowercaseCommand(0, 0);
        cm.execute(iCommand1);
        assert (canvas.getPixel(0, 0) == 'a');

        ICommand iCommand2 = new DrawPixelCommand(0, 1, 'a');
        cm.execute(iCommand2);
        ICommand iCommand3 = new ToUppercaseCommand(0, 1);
        cm.execute(iCommand3);
        assert (canvas.getPixel(0, 1) == 'A');
        assert (cm.execute(iCommand3) == false);


        {
            OverdrawAnalyzer analyzer = new OverdrawAnalyzer(6, 6);
            CommandHistoryManager manager = new CommandHistoryManager((Canvas) analyzer);

            ArrayList<ICommand> commands = new ArrayList<>();
            commands.add(new ClearCanvasCommand());
            commands.add(new FillHorizontalLineCommand(1, '.'));
            commands.add(new IncreasePixelCommand(0, 3));
            commands.add(new ToUppercaseCommand(1, 0));
            commands.add(new FillHorizontalLineCommand(4, 'X'));
            commands.add(new FillHorizontalLineCommand(4, 'V'));
            commands.add(new FillVerticalLineCommand(4, 't'));
            commands.add(new IncreasePixelCommand(4, 2));
            commands.add(new ToLowercaseCommand(2, 3));
            commands.add(new IncreasePixelCommand(0, 0));
            commands.add(new FillVerticalLineCommand(2, 'm'));
            commands.add(new ToLowercaseCommand(0, 4));
            commands.add(new ToLowercaseCommand(1, 0));
            commands.add(new DrawPixelCommand(3, 1, 'o'));
            commands.add(new FillVerticalLineCommand(2, 'y'));
            commands.add(new FillHorizontalLineCommand(1, 'A'));


            for (int i = 0; i < 8; i++) {
                manager.execute(commands.get(i));
            }

            manager.redo();

            for (int i = 8; i < 10; i++) {
                manager.execute(commands.get(i));
            }

            manager.redo();

            manager.execute(commands.get(10));

            manager.undo();

            for (int i = 11; i < 14; i++) {
                manager.execute(commands.get(i));
            }

            manager.undo();

            for (int i = 14; i < 16; i++) {
                manager.execute(commands.get(i));
            }



            System.out.print(analyzer.getDrawing());
            System.out.println(analyzer.getPixelHistory(0, 1)); // 오류 생기는 부분 직접 입력
        }


        {
            canvas = new Canvas(20, 10);
            CommandHistoryManager chm = new CommandHistoryManager(canvas);
            ArrayList<ICommand> commandList = new ArrayList<>();
            commandList.add(new DrawPixelCommand(1, 2, '3'));
            commandList.add(new DecreasePixelCommand(1, 2));
            commandList.add(new IncreasePixelCommand(1, 2));
            commandList.add(new FillHorizontalLineCommand(3, 'h'));
            commandList.add(new FillVerticalLineCommand(3, 'h'));
            commandList.add(new ToUppercaseCommand(3, 2));
            commandList.add(new ToLowercaseCommand(3, 2));
            commandList.add(new ClearCanvasCommand());
            int i = 0;
            for (ICommand command : commandList) {
                System.out.println(i);
                i++;
                assert (chm.execute(command) == true);
                assert (chm.undo() == true);
                assert (chm.redo() == true);
                canvas.drawPixel(9, 9, '5');
                assert (chm.undo() == false);
                canvas.drawPixel(9, 9, ' ');
                assert (chm.undo() == true);
                canvas.drawPixel(9, 9, '5');
                assert (chm.redo() == false);
                canvas.drawPixel(9, 9, ' ');
                assert (chm.redo() == true);
            }
        }
    }
}
