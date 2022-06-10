package academy.pocu.comp2500.assignment2;

public class Banner extends CustomizableProduct {

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
                name = "Gloss Banner";
                switch (bannerSize) {
                    case SIZE_ONE:
                        width = 1000;
                        height = 500;
                        price = 5000;
                        break;
                    case SIZE_TWO:
                        width = 1000;
                        height = 1000;
                        price = 5200;
                        break;
                    case SIZE_THREE:
                        width = 2000;
                        height = 500;
                        price = 5300;
                        break;
                    case SIZE_FOUR:
                        width = 3000;
                        height = 1000;
                        price = 6000;
                        break;
                }
                break;
            case SCRIM:
                name = "Scrim Banner";
                switch (bannerSize) {
                    case SIZE_ONE:
                        width = 1000;
                        height = 500;
                        price = 5100;
                        break;
                    case SIZE_TWO:
                        width = 1000;
                        height = 1000;
                        price = 5300;
                        break;
                    case SIZE_THREE:
                        width = 2000;
                        height = 500;
                        price = 5400;
                        break;
                    case SIZE_FOUR:
                        width = 3000;
                        height = 1000;
                        price = 6100;
                        break;
                }
                break;
            case MESH:
                name = "Mesh Banner";
                switch (bannerSize) {
                    case SIZE_ONE:
                        width = 1000;
                        height = 500;
                        price = 5100;
                        break;
                    case SIZE_TWO:
                        width = 1000;
                        height = 1000;
                        price = 5300;
                        break;
                    case SIZE_THREE:
                        width = 2000;
                        height = 500;
                        price = 5400;
                        break;
                    case SIZE_FOUR:
                        width = 3000;
                        height = 1000;
                        price = 6100;
                        break;
                }
                break;
        }

    }

}
