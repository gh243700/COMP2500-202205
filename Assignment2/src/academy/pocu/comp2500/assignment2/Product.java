package academy.pocu.comp2500.assignment2;

public class Product {
    protected String name;
    protected int price;
    protected Color color;
    protected int width;
    protected int height;
    private DeliveryMethod deliveryMethod;
    public String getName() {
        return name;
    }
    public int getPrice() {
        return price;
    }
    public Color getColor() {
        return color;
    }
    public int getWidth() {
        return width;
    }
    public int getHeight() {
        return height;
    }
    public DeliveryMethod getDeliveryMethod() {
        return deliveryMethod;
    }

    public void setDeliveryMethod(DeliveryMethod deliveryMethod) {
        this.deliveryMethod = deliveryMethod;
    }
    protected Product(DeliveryMethod deliveryMethod) {
        this.deliveryMethod = deliveryMethod;
    }
}
