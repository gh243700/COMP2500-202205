package academy.pocu.comp2500.assignment2;

import java.util.ArrayList;

public class CustomizableProduct extends Product {

    private ArrayList<Aperture> apertures;
    private OrientationType orientation;

    public CustomizableProduct(OrientationType orientation, DeliveryMethod deliveryMethod) {
        super(deliveryMethod);
        apertures = new ArrayList<>();
        this.orientation = orientation;
    }

    public ArrayList<Aperture> getApertures() {
        return apertures;
    }

    public OrientationType getOrientation() {
        return orientation;
    }

    public boolean addImageAperture(ImageAperture imageAperture) {
        if (imageAperture.getX() + imageAperture.getLength() > length || imageAperture.getY() + imageAperture.getHeight() > height) {
            return false;
        }
        this.price += 5;
        return apertures.add(imageAperture);
    }

    public boolean addTextAperture(TextAperture textAperture) {
        if (textAperture.getX() + textAperture.getLength() > length || textAperture.getY() + textAperture.getHeight() > height) {
            return false;
        }
        this.price += 5;
        return apertures.add(textAperture);
    }

}
