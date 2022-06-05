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

    public boolean addAperture(Aperture aperture) {
        if (aperture.getWidth() == 0 || aperture.getHeight() == 0 || aperture.getX() + aperture.getWidth() > width || aperture.getY() + aperture.getHeight() > height || !apertures.add(aperture)) {
            return false;
        }
        this.price += 5;
        return true;
    }

}
