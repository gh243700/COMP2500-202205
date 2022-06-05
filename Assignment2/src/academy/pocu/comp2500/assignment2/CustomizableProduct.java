package academy.pocu.comp2500.assignment2;

import java.util.ArrayList;

public class CustomizableProduct extends Product {
    private ArrayList<Aperture> apertures;
    private OrientationType orientation;
    protected CustomizableProduct(OrientationType orientation, DeliveryMethod deliveryMethod) {
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

    public boolean addAperture(Aperture aperture) {
        if (aperture.getX() < 0 || aperture.getY() < 0 || aperture.getX() + aperture.getWidth() > width || aperture.getY() + aperture.getHeight() > height) {
            return false;
        }
        apertures.add(aperture);
        this.price += 5;
        return true;
    }

}
