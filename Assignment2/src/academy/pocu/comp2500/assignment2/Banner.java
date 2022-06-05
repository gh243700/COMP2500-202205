package academy.pocu.comp2500.assignment2;

public class Banner extends CustomizableProduct{

    private BannerType bannerType;

    private BannerSize bannerSize;

    public BannerType getBannerType() {
        return bannerType;
    }

    public BannerSize getBannerSize() {
        return bannerSize;
    }
    public Banner(Color color, BannerType bannerType, BannerSize bannerSize, OrientationType orientation, DeliveryMethod deliveryMethod) {
        super(orientation, deliveryMethod);
        this.color = color;
        this.bannerType = bannerType;
        this.bannerSize = bannerSize;
        switch (bannerType) {
            case GLOSS:
                name = "반사(Gloss) 배너";
                switch (bannerSize) {
                    case SIZE_ONE:
                        length = 1000;
                        height = 500;
                        price = 5000;
                        break;
                    case SIZE_TWO:
                        length = 1000;
                        height = 1000;
                        price = 5200;
                        break;
                    case SIZE_THREE:
                        length = 2000;
                        height = 500;
                        price = 5300;
                        break;
                    case SIZE_FOUR:
                        length = 3000;
                        height = 1000;
                        price = 6000;
                        break;
                }
                break;
            case SCRIM:
                name = "스크림(Scrim) 배너";
                switch (bannerSize) {
                    case SIZE_ONE:
                        length = 1000;
                        height = 500;
                        price = 5100;
                        break;
                    case SIZE_TWO:
                        length = 1000;
                        height = 1000;
                        price = 5300;
                        break;
                    case SIZE_THREE:
                        length = 2000;
                        height = 500;
                        price = 5400;
                        break;
                    case SIZE_FOUR:
                        length = 3000;
                        height = 1000;
                        price = 6100;
                        break;
                }
                break;
            case MESH:
                name = "메쉬(Mesh) 배너";
                switch (bannerSize) {
                    case SIZE_ONE:
                        length = 1000;
                        height = 500;
                        price = 5100;
                        break;
                    case SIZE_TWO:
                        length = 1000;
                        height = 1000;
                        price = 5300;
                        break;
                    case SIZE_THREE:
                        length = 2000;
                        height = 500;
                        price = 5400;
                        break;
                    case SIZE_FOUR:
                        length = 3000;
                        height = 1000;
                        price = 6100;
                        break;
                }
                break;
        }

    }

}
