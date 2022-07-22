package academy.pocu.comp2500.assignment4;

import java.util.HashMap;
import java.util.LinkedList;
public class OverdrawAnalyzer extends Canvas{
    private HashMap<Vector, LinkedList<Character>> pixelHistory = new HashMap<>();
    public OverdrawAnalyzer(int width, int height) {
        super(width, height);
    }
    @Override
    public void drawPixel(int x, int y, char c) {
        if (isValidXY(x, y) == false || isValidPixel(c) == false) {
            return;
        }

        if(canvas[x][y] == c) {
            return;
        }

        Vector vector = new Vector(x, y);

        LinkedList<Character> linkedList;
        if (!pixelHistory.containsKey(vector)) {
            linkedList = new LinkedList<>();
            pixelHistory.put(vector, linkedList);
        }
        linkedList = pixelHistory.get(vector);
        linkedList.add(c);

        canvas[x][y] = c;
    }

    public LinkedList<Character> getPixelHistory(int x, int y) {
        Vector vector = new Vector(x, y);
        LinkedList linkedList;
        if(!pixelHistory.containsKey(vector)) {
            linkedList = new LinkedList();
            return linkedList;
        }

        return pixelHistory.get(vector);
    }

    public int getOverdrawCount(int x, int y) {
        Vector vector = new Vector(x, y);
        if (!pixelHistory.containsKey(vector)) {
            return 0;
        }

        LinkedList<Character> characters = pixelHistory.get(vector);
        return characters.size() - 1;
    }

}
