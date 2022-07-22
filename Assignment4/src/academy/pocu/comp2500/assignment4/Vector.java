package academy.pocu.comp2500.assignment4;

public class Vector {
    private int x;
    private int y;

    public Vector(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || obj instanceof Vector == false) {
            return false;
        }

        Vector other = (Vector) obj;
        if (other.hashCode() != this.hashCode()) {
            return false;
        }

        return x == other.x && y == other.y;
    }

    @Override
    public int hashCode() {
        return x ^ (y << 16);
    }
}
