package academy.pocu.comp2500.assignment2;

import academy.pocu.comp2500.assignment2.registry.Registry;

public class App {
    public App(Registry registry) {
        registry.registerRedStampCreator("Stamp");
        registry.registerBlueStampCreator("Stamp");
        registry.registerGreenStampCreator("Stamp");
        registry.registerWallCalendarCreator("Calendar");
        registry.registerMagnetCalendarCreator("Calendar");
        registry.registerDeskCalendarCreator("Calendar");
        registry.registerLandscapeBannerCreator("Banner");
        registry.registerPortraitBannerCreator("Banner");
        registry.registerGlossBannerCreator("Banner");
        registry.registerScrimBannerCreator("Banner");
        registry.registerMeshBannerCreator("Banner");
        registry.registerLandscapeBusinessCardCreator("BusinessCard");
        registry.registerPortraitBusinessCardCreator("BusinessCard");
        registry.registerIvoryBusinessCardCreator("BusinessCard");
        registry.registerGrayBusinessCardCreator("BusinessCard");
        registry.registerWhiteBusinessCardCreator("BusinessCard");
        registry.registerLaidBusinessCardCreator("BusinessCard");
        registry.registerLinenBusinessCardCreator("BusinessCard");
        registry.registerSmoothBusinessCardCreator("BusinessCard");
        registry.registerSingleSidedBusinessCardCreator("BusinessCard");
        registry.registerDoubleSidedBusinessCardCreator("BusinessCard");
        registry.registerCartCreator("ShoppingCart");
        registry.registerProductAdder("ShoppingCart", "addProduct");
        registry.registerProductRemover("ShoppingCart", "removeProduct");
        registry.registerTotalPriceGetter("ShoppingCart", "getTotalPrice");
        registry.registerLandscapeBannerTextApertureAdder("CustomizableProduct", "addTextAperture");
        registry.registerLandscapeBannerImageApertureAdder("CustomizableProduct", "addAperture");
        registry.registerPortraitBannerTextApertureAdder("CustomizableProduct", "addTextAperture");
        registry.registerPortraitBannerImageApertureAdder("CustomizableProduct", "addAperture");
        registry.registerGlossBannerTextApertureAdder("CustomizableProduct", "addTextAperture");
        registry.registerGlossBannerImageApertureAdder("CustomizableProduct", "addAperture");
        registry.registerScrimBannerTextApertureAdder("CustomizableProduct", "addTextAperture");
        registry.registerScrimBannerImageApertureAdder("CustomizableProduct", "addAperture");
        registry.registerMeshBannerTextApertureAdder("CustomizableProduct", "addTextAperture");
        registry.registerMeshBannerImageApertureAdder("CustomizableProduct", "addAperture");
        registry.registerLandscapeBusinessCardTextApertureAdder("CustomizableProduct", "addTextAperture");
        registry.registerLandscapeBusinessCardImageApertureAdder("CustomizableProduct", "addImageAperture");
        registry.registerPortraitBusinessCardTextApertureAdder("CustomizableProduct", "addTextAperture");
        registry.registerPortraitBusinessCardImageApertureAdder("CustomizableProduct", "addImageAperture");
        registry.registerIvoryBusinessCardTextApertureAdder("CustomizableProduct", "addTextAperture");
        registry.registerIvoryBusinessCardImageApertureAdder("CustomizableProduct", "addImageAperture");
        registry.registerGrayBusinessCardTextApertureAdder("CustomizableProduct", "addTextAperture");
        registry.registerGrayBusinessCardImageApertureAdder("CustomizableProduct", "addImageAperture");
        registry.registerWhiteBusinessCardTextApertureAdder("CustomizableProduct", "addTextAperture");
        registry.registerWhiteBusinessCardImageApertureAdder("CustomizableProduct", "addImageAperture");
        registry.registerLaidBusinessCardTextApertureAdder("CustomizableProduct", "addTextAperture");
        registry.registerLaidBusinessCardImageApertureAdder("CustomizableProduct", "addImageAperture");
        registry.registerLinenBusinessCardTextApertureAdder("CustomizableProduct", "addTextAperture");
        registry.registerLinenBusinessCardImageApertureAdder("CustomizableProduct", "addImageAperture");
        registry.registerSmoothBusinessCardTextApertureAdder("CustomizableProduct", "addTextAperture");
        registry.registerSmoothBusinessCardImageApertureAdder("CustomizableProduct", "addImageAperture");
        registry.registerSingleSidedBusinessCardTextApertureAdder("CustomizableProduct", "addTextAperture");
        registry.registerSingleSidedBusinessCardImageApertureAdder("CustomizableProduct", "addImageAperture");
        registry.registerDoubleSidedBusinessCardTextApertureAdder("CustomizableProduct", "addTextAperture");
        registry.registerDoubleSidedBusinessCardImageApertureAdder("CustomizableProduct", "addImageAperture");
    }
}
