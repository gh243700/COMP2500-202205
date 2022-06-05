package academy.pocu.comp2500.assignment2;

public class TextAperture extends Aperture{
    private String text;

    public String getText() {
        return text;
    }
    public TextAperture(int x, int y, int length, int height, String text) {
        super(x, y, length, height);
        this.text = text;
    }

}
