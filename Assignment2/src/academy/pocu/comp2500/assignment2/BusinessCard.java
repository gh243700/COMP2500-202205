package academy.pocu.comp2500.assignment2;

public class BusinessCard extends CustomizableProduct{
    private BusinessCardSides businessCardSides;

    private BusinessCardType businessCardType;

    private BusinessCardColor businessCardColor;

    public BusinessCardSides getBusinessCardSides() {
        return businessCardSides;
    }

    public BusinessCardType getBusinessCardType() {
        return businessCardType;
    }

    public BusinessCardColor getBusinessCardColor() {
        return businessCardColor;
    }

    public BusinessCard(BusinessCardType businessCardType, OrientationType orientation, BusinessCardSides businessCardSides, BusinessCardColor businessCardColor, DeliveryMethod deliveryMethod) {
        super(orientation, deliveryMethod);
        this.businessCardType = businessCardType;
        this.businessCardColor = businessCardColor;
        switch (businessCardType) {
            case LINEN:
                this.name = "린넨커버(Linen) 명함";
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
                this.name = "레이드지(Laid) 명함";
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
                this.name = "스노우지(Smooth) 명함";
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
        switch (businessCardColor) {
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
