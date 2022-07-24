package academy.pocu.comp2500.assignment4;

import java.util.HashMap;
import java.util.LinkedList;

public class OverdrawAnalyzer extends Canvas {
    private HashMap<Vector, LinkedList<Character>> pixelHistory = new HashMap<>();

    public OverdrawAnalyzer(int width, int height) {
        super(width, height);
    }

    @Override
    public void drawPixel(int x, int y, char c) {
        char pixel = getPixel(x, y);
        if (pixel == c) {
            return;
        }
        super.drawPixel(x, y, c);

        Vector vector = new Vector(x, y);

        LinkedList<Character> linkedList;
        if (!pixelHistory.containsKey(vector)) {
            linkedList = new LinkedList<>();
            pixelHistory.put(vector, linkedList);
        }
        linkedList = pixelHistory.get(vector);
        if (linkedList.size() == 0 || linkedList.getLast() != c) {
            linkedList.add(c);
        }
    }

    public LinkedList<Character> getPixelHistory(int x, int y) {
        Vector vector = new Vector(x, y);
        LinkedList<Character> linkedList;
        if (!pixelHistory.containsKey(vector)) {
            linkedList = new LinkedList<>();
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
        return characters.size();
    }

    public int getOverdrawCount() {
        int result = 0;
        for (LinkedList<Character> linkedList : pixelHistory.values()) {
            result += linkedList.size();
        }

        return result;
    }

}
