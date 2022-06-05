package academy.pocu.comp2500.assignment2;
public class Aperture {
    private int x;
    private int y;
    private int width;
    private int height;
    public Aperture(int x, int y, int width, int height) {
        this.x = Math.max(0, x);
        this.y = Math.max(0, y);
        this.width = Math.max(0, width);
        this.height = Math.max(0, height);
    }
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
