package academy.pocu.comp2500.assignment2;

public class ImageAperture extends Aperture{
    private String imagePath;
    public ImageAperture(int x, int y, int length, int height, String imagePath) {
        super(x, y, length, height);
        this.imagePath = imagePath;
    }

}
