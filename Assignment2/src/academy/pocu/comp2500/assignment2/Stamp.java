package academy.pocu.comp2500.assignment2;

public class Stamp extends Product {
    private String text;
    private StampColor stampColor;
    private StampSize stampSize;
    public String getText() {
        return text;
    }
    public StampColor getStampColor() {
        return stampColor;
    }
    public StampSize getStampSize() {
        return stampSize;
    }
    public Stamp(StampColor stampColor, StampSize stampSize, String text, DeliveryMethod deliveryMethod) {
        super(deliveryMethod);
        this.stampColor = stampColor;
        this.text = text;
        this.stampSize = stampSize;
        name = "Stamp";
        switch (stampColor) {
            case RED:
                color = new Color(0xFF, 0x00, 0x00);
                break;
            case BLUE:
                color = new Color(0x00, 0x00, 0xFF);
                break;
            case GREEN:
                color = new Color(0x00, 0x80, 0x00);
                break;
        }

        switch (stampSize) {
            case SIZE_ONE:
                width = 40;
                height = 30;
                price = 2300;
                break;
            case SIZE_TWO:
                width = 50;
                height = 20;
                price = 2300;
                break;
            case SIZE_THREE:
                width = 70;
                height = 40;
                price = 2600;
                break;
        }

    }

}
