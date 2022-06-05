package academy.pocu.comp2500.assignment2;

public class Color {
    private int red;
    private int green;
    private int blue;

    public Color(int red, int green ,int blue) {
        if (red < 0x00) {
            this.red = 0x00;
        } else if (red > 0xFF) {
            this.red = 0xFF;
        } else {
            this.red = red;
        }

        if (green < 0x00) {
            this.green = 0x00;
        } else if (green > 0xFF) {
            this.green = 0xFF;
        } else {
            this.green = green;
        }

        if (blue < 0x00) {
            this.blue = 0x00;
        } else if (blue > 0xFF) {
            this.blue = 0xFF;
        } else {
            this.blue = blue;
        }
    }

    public int getRed() {
        return red;
    }

    public int getGreen() {
        return green;
    }

    public int getBlue() {
        return blue;
    }
}
