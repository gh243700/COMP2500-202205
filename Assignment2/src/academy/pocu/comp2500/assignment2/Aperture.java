package academy.pocu.comp2500.assignment2;
public class Aperture {
    private int x;
    private int y;
    private int length;
    private int height;
    public Aperture(int x, int y, int length, int height) {
        this.x = x;
        this.y = y;
        this.length = length;
        this.height = height;
    }
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getLength() {
        return length;
    }

    public int getHeight() {
        return height;
    }
}
