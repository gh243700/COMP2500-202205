package academy.pocu.comp2500.assignment2;

public class Stamp extends Product{
    private String text;

    public String getText() {
        return text;
    }

    public void setStampSize(StampSize stampSize) {
        switch (stampSize) {
            case SIZE_ONE:
                length = 40;
                height = 30;
                price = 2300;
                break;
            case SIZE_TWO:
                length = 50;
                height = 20;
                price = 2300;
                break;
            case SIZE_THREE:
                length = 70;
                height = 40;
                price = 2600;
                break;
        }
    }
    public Stamp(StampType stampType, StampSize stampSize, String text, DeliveryMethod deliveryMethod) {
        super(deliveryMethod);
        this.text = text;
        switch (stampType) {
            case RED:
                color = new Color(0xFF, 0x00, 0x00);
                name = "스탬프(잉크: 빨강)";
                break;
            case BLUE:
                color = new Color(0x00, 0x00, 0xFF);
                name = "스탬프(잉크: 파랑)";
                break;
            case GREEN:
                color = new Color(0x00, 0x80, 0x00);
                name = "스탬프(잉크: 녹색)";
                break;
        }

        switch (stampSize) {
            case SIZE_ONE:
                length = 40;
                height = 30;
                price = 2300;
                break;
            case SIZE_TWO:
                length = 50;
                height = 20;
                price = 2300;
                break;
            case SIZE_THREE:
                length = 70;
                height = 40;
                price = 2600;
                break;
        }

    }

}
