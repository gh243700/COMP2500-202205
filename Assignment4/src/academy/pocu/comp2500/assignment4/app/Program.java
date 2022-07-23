package academy.pocu.comp2500.assignment4.app;

import academy.pocu.comp2500.assignment4.*;

import java.util.ArrayList;


public class Program {

    public static void main(String[] args) {
	    // write your code here
        {
            {

                Canvas canvas = new Canvas(20, 10);
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
                for (ICommand command : commandList) {
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


            {
                Canvas canvas = new Canvas(20, 10);
                CommandHistoryManager chm = new CommandHistoryManager(canvas);
                DrawPixelCommand c1 = new DrawPixelCommand(1, 2, '1');
                DrawPixelCommand c2 = new DrawPixelCommand(3, 5, '2');

                assert (chm.execute(c1) == true);
                assert (chm.execute(c2) == true);

                assert (chm.undo() == true);
                assert (chm.redo() == true);

                assert (chm.undo() == true);

                canvas.drawPixel(1, 2, '5');

                assert (chm.undo() == false);
                //assert (chm.redo() == true);
            }


            {
                OverdrawAnalyzer analyzer = new OverdrawAnalyzer(6, 6);
                CommandHistoryManager manager = new CommandHistoryManager((Canvas) analyzer);

                ArrayList<ICommand> commands = new ArrayList<>();
                commands.add(new ClearCanvasCommand());
                commands.add(new FillVerticalLineCommand(1, '.'));
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



        }


        {
            OverdrawAnalyzer canvas = new OverdrawAnalyzer(5, 5);
            CommandHistoryManager cm = new CommandHistoryManager(canvas);

            ICommand command0 = new DrawPixelCommand(0, 0, 'A');
            cm.execute(command0);
            assert (canvas.getPixel(0, 0) == 'A');

            ICommand command1 = new ToLowercaseCommand(0, 0);
            assert(cm.execute(command1) == true);
            assert (canvas.getPixel(0, 0) == 'a');

            ICommand command2 = new ToUppercaseCommand(0, 0);
            assert (cm.execute(command2) == true);
            assert (canvas.getPixel(0, 0) == 'A');


            ICommand command3 = new DrawPixelCommand(0, 0, '-');
            assert (cm.execute(command3) == true);
            assert (canvas.getPixel(0, 0) == '-');

            ICommand command4 = new ToLowercaseCommand(0, 0);
            //assert (cm.execute(command4) == true);
            System.out.println(canvas.getDrawing());
            ICommand command5 = new FillVerticalLineCommand(0, 'B');
            cm.execute(command5);
            System.out.println(canvas.getDrawing());
            ICommand command6 = new DecreasePixelCommand(1, 1);
            assert(cm.execute(command6) == false);
            System.out.println(canvas.getDrawing());
            cm.undo();
            System.out.println(canvas.getDrawing());

            cm.execute(command5);



            System.out.println("----------------------------------------------------");



        }
/*
        {
            OverdrawAnalyzer canvas = new OverdrawAnalyzer(5, 5);
            CommandHistoryManager cm = new CommandHistoryManager(canvas);

            ICommand iCommand0 = new ToUppercaseCommand(2, 0);
            cm.execute(iCommand0);
            assert (canvas.getOverdrawCount() == 0);

            ICommand iCommand1 = new ToUppercaseCommand(0, 1);
            cm.execute(iCommand1);
            assert (canvas.getOverdrawCount() == 0);

            ICommand iCommand2 = new ToLowercaseCommand(4, 3);
            cm.execute(iCommand2);
            assert (canvas.getOverdrawCount() == 0);

            ICommand iCommand3 = new FillHorizontalLineCommand(0, 'e');
            cm.execute(iCommand3);
            assert (canvas.getOverdrawCount() == 5);

            ICommand iCommand4 = new DecreasePixelCommand(4, 4);
            cm.execute(iCommand4);
            assert (canvas.getOverdrawCount() == 5);

            ICommand iCommand5 = new DecreasePixelCommand(0, 1);
            cm.execute(iCommand5);
            assert (canvas.getOverdrawCount() == 5);

            ICommand iCommand6 = new ToLowercaseCommand(0, 0);
            cm.execute(iCommand6);
            assert (canvas.getOverdrawCount() == 5);

            ICommand iCommand7 = new DrawPixelCommand(3, 2, 'Z');
            cm.execute(iCommand7);
            assert (canvas.getOverdrawCount() == 6);

            ICommand iCommand8 = new IncreasePixelCommand(3, 4);
            cm.execute(iCommand8);
            assert (canvas.getOverdrawCount() == 7);

            ICommand iCommand9 = new ToUppercaseCommand(4, 4);
            cm.execute(iCommand9);
            assert (canvas.getOverdrawCount() == 7);

            ICommand iCommand10 = new DrawPixelCommand(4, 0, '+');
            cm.execute(iCommand10);
            assert (canvas.getOverdrawCount() == 8);

            ICommand iCommand11 = new FillVerticalLineCommand(4, '^');
            cm.execute(iCommand11);
            assert (canvas.getOverdrawCount() == 13);

            ICommand iCommand12 = new ToLowercaseCommand(0, 3);
            cm.execute(iCommand12);
            assert (canvas.getOverdrawCount() == 13);

            ICommand iCommand13 = new ToLowercaseCommand(1, 0);
            cm.execute(iCommand13);
            assert (canvas.getOverdrawCount() == 13);

            cm.redo();
            assert (canvas.getOverdrawCount() == 13);

            cm.undo();
            assert (canvas.getOverdrawCount() == 18);

            ICommand iCommand14 = new ToLowercaseCommand(1, 3);
            cm.execute(iCommand14);
            assert (canvas.getOverdrawCount() == 18);

            ICommand iCommand15 = new FillVerticalLineCommand(3, 'I');
            cm.execute(iCommand15);
            assert (canvas.getOverdrawCount() == 23);

            ICommand iCommand16 = new IncreasePixelCommand(4, 4);
            cm.execute(iCommand16);
            assert (canvas.getOverdrawCount() == 24);

            cm.redo();
            assert (canvas.getOverdrawCount() == 24);
        }
*/
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
            Canvas canvas = new OverdrawAnalyzer(30, 25);
            CommandHistoryManager cm = new CommandHistoryManager(canvas);

            ICommand iCommand1 = new FillHorizontalLineCommand(10, 't');
            cm.execute(iCommand1);

            ICommand iCommand2 = new FillHorizontalLineCommand(2, 'k');
            cm.execute(iCommand2);

            ICommand iCommand3 = new DrawPixelCommand(8, 6, 'O');
            cm.execute(iCommand3);

            ICommand iCommand4 = new ClearCanvasCommand();

            cm.execute(iCommand4);

            cm.undo();

            cm.undo();

            ICommand iCommand7 = new ClearCanvasCommand();
            cm.execute(iCommand7);

            ICommand iCommand8 = new DrawPixelCommand(22, 18, 'K');
            cm.execute(iCommand8);

            ICommand iCommand9 = new ClearCanvasCommand();
            cm.execute(iCommand9);

            cm.undo();

            ICommand iCommand11 = new FillHorizontalLineCommand(12, 'B');
            cm.execute(iCommand11);


            System.out.println(canvas.getDrawing());

            ICommand iCommand12 = new DecreasePixelCommand(27, 7);
            assert(cm.execute(iCommand12) == false);

            cm.undo();
            System.out.println(canvas.getDrawing());

            ICommand iCommand14 = new DecreasePixelCommand(26, 12);
            cm.execute(iCommand14);


            ICommand iCommand15 = new ToUppercaseCommand(14, 14);
            cm.execute(iCommand15);

            ICommand iCommand16 = new ToUppercaseCommand(3, 18);
            cm.execute(iCommand16);

            cm.redo();


            System.out.println(canvas.getDrawing());
            System.out.println("--------------------------------------------------------------");


        }

        {
            Canvas canvas = new OverdrawAnalyzer(30, 25);
            CommandHistoryManager cm = new CommandHistoryManager(canvas);

            ICommand iCommand1 = new FillVerticalLineCommand(21, '8');
            cm.execute(iCommand1);
            ICommand iCommand2 = new FillHorizontalLineCommand(10, '#');
            cm.execute(iCommand2);
            System.out.println(canvas.getDrawing());
            ICommand iCommand3 = new ToLowercaseCommand(5,1);
            cm.execute(iCommand3);
            System.out.println(canvas.getDrawing());
            assert(cm.redo() == false);
            assert(cm.undo() == true);

            System.out.println(canvas.getDrawing());




        }


    }
}
