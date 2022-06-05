package academy.pocu.comp2500.assignment2;

public class TextAperture extends Aperture{

    private String print;

    public TextAperture(int x, int y, int length, int height, String print) {
        super(x, y, length, height);
        this.print = print;
    }

    public String getPrint() {
        return print;
    }

}
