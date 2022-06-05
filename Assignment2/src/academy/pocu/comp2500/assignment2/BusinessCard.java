package academy.pocu.comp2500.assignment2;

public class BusinessCard extends CustomizableProduct{
    private BusinessCardSides businessCardSides;

    private BusinessCardType businessCardType;

    private PaperColor paperColor;

    public BusinessCardSides getBusinessCardSides() {
        return businessCardSides;
    }

    public BusinessCardType getBusinessCardType() {
        return businessCardType;
    }

    public PaperColor getPaperColor() {
        return paperColor;
    }

    public BusinessCard(BusinessCardType businessCardType, OrientationType orientation, BusinessCardSides businessCardSides, PaperColor paperColor, DeliveryMethod deliveryMethod) {
        super(orientation, deliveryMethod);
        this.businessCardType = businessCardType;
        this.paperColor = paperColor;
        switch (businessCardType) {
            case LINEN:
                this.name = "Linen Business Card";
                switch (businessCardSides) {
                    case SINGLE_SIDED:
                        this.price = 110;
                        break;
                    case DOUBLE_SIDED:
                        this.price = 140;
                        break;
                }
                break;
            case LAID:
                this.name = "Laid Business Card";
                switch (businessCardSides) {
                    case SINGLE_SIDED:
                        this.price = 120;
                        break;
                    case DOUBLE_SIDED:
                        this.price = 150;
                        break;
                }
                break;
            case SMOOTH:
                this.name = "Smooth Business Card";
                switch (businessCardSides) {
                    case SINGLE_SIDED:
                        this.price = 100;
                        break;
                    case DOUBLE_SIDED:
                        this.price = 130;
                        break;
                }
                break;

        }
        switch (paperColor) {
            case GREY:
                this.color = new Color(0xE6, 0xE6, 0xE6);
                break;
            case IVORY:
                this.color = new Color(0xFF, 0xFF, 0xF0);
                break;
            case WHITE:
                this.color = new Color(0xFF, 0xFF, 0xFF);
                break;
        }
        this.width = 90;
        this.height = 50;
        this.businessCardSides = businessCardSides;
    }


}
