package academy.pocu.comp2500.assignment4;

public class Canvas {
    private static final char INITIAL_PIXEL = ' ';
    private char[][] canvas;
    public Canvas(int width, int height) {
        this.canvas = new char[width][height];
        for (int i = 0; i < getHeight(); i++) {
            for (int j = 0; j < getWidth(); j++) {
                canvas[j][i] = INITIAL_PIXEL;
            }
        }
    }
    public int getWidth() {
        return canvas.length;
    }
    public int getHeight() {
        return canvas[0].length;
    }
    public void drawPixel(int x, int y, char c) {
        if (isValidXY(x, y) == false || isValidLetter(c) == false) {
            return;
        }

        canvas[x][y] = c;
    }

    public char getPixel(int x, int y) {
        if (isValidXY(x, y) == false) {
            return Character.MAX_VALUE;
        }

        return canvas[x][y];
    }

    public boolean increasePixel(int x, int y) {
        char pixel = getPixel(x, y);

        if (pixel == Character.MAX_VALUE || isValidLetter((int)pixel + 1) == false) {
            return false;
        }

        pixel = (char)((int)pixel + 1);
        drawPixel(x, y, pixel);
        return true;
    }

    public boolean decreasePixel(int x, int y) {
        char pixel = getPixel(x, y);

        if (pixel == Character.MAX_VALUE || isValidLetter((int)pixel - 1) == false) {
            return false;
        }

        pixel = (char)((int)pixel - 1);
        drawPixel(x, y, pixel);
        return true;
    }

    public void toUpper(int x, int y) {
        if (isValidXY(x, y) == false) {
            return;
        }

        char pixel = getPixel(x , y);
        pixel = (char)(0xDF & (int)pixel);
        if (pixel < 0x61 || pixel > 0x7A) {
            return;
        }

        drawPixel(x, y, pixel);
    }
    public void toLower(int x, int y) {
        if (isValidXY(x, y) == false) {
            return;
        }


        char pixel = getPixel(x, y);

        if (pixel < 0x41 || pixel > 0x5A) {
            return;
        }


        pixel = (char)(0x20 | (int)pixel);
        drawPixel(x, y, pixel);
    }
    public void fillHorizontalLine(int y, char c) {
        if(isValidY(y) == false || isValidLetter(c) == false) {
            return;
        }

        for (int i = 0; i < getWidth(); i++) {
            drawPixel(i , y, c);
        }
    }

    public void fillVerticalLine(int x, char c) {
        if(isValidX(x) == false || isValidLetter(c) == false) {
            return;
        }

        for (int i = 0; i < getHeight(); i++) {
            drawPixel(x, i, c);
        }
    }

    public void clear() {
        for (int i = 0; i < getHeight(); i++) {
            for (int j = 0; j < getWidth(); j++) {
                drawPixel(j, i, INITIAL_PIXEL);
            }
        }
    }

    public String getDrawing() {
        StringBuilder sb = new StringBuilder();
        sb.append('+');
        for (int i = 0; i < getWidth(); i++) {
            sb.append('-');
        }
        sb.append('+');
        sb.append(System.lineSeparator());
        for (int i = 0; i < getHeight(); i++) {
            sb.append('|');
            for (int j = 0; j < getWidth(); j++) {
                sb.append(getPixel(j, i));
            }
            sb.append('|');
            sb.append(System.lineSeparator());
        }
        sb.append('+');
        for (int i = 0; i < getWidth(); i++) {
            sb.append('-');
        }
        sb.append('+');
        sb.append(System.lineSeparator());


        return sb.toString();
    }

    private boolean isValidLetter(int value) {
        if (value >= 32 && value <= 126) {
            return true;
        }
        return false;
    }

    private boolean isValidX(int x) {
        if (x < 0 || x >= getWidth()) {
            return false;
        }
        return true;
    }


    private boolean isValidY(int y) {
        if (y < 0 || y >= getHeight()) {
            return false;
        }
        return true;
    }

    private boolean isValidXY(int x, int y) {
        if (isValidX(x) == false || isValidY(y) == false) {
            return false;
        }

        return true;
    }

}
