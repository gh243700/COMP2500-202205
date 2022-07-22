package academy.pocu.comp2500.assignment4;

import academy.pocu.comp2500.assignment4.registry.Registry;

public class App {
    public App(Registry registry) {
        // Register like this
        // registry.registerDrawPixelCommandCreator("Foo");
        // OR
        // registry.registerDrawPixelCommandCreator("Foo", "bar");
        registry.registerDrawPixelCommandCreator(DrawPixelCommand.class.getSimpleName());
        registry.registerIncreasePixelCommandCreator(IncreasePixelCommand.class.getSimpleName());
        registry.registerDecreasePixelCommandCreator(DecreasePixelCommand.class.getSimpleName());
        registry.registerToUppercaseCommandCreator(ToUppercaseCommand.class.getSimpleName());
        registry.registerToLowercaseCommandCreator(ToLowercaseCommand.class.getSimpleName());
        registry.registerFillHorizontalLineCommandCreator(FillHorizontalLineCommand.class.getSimpleName());
        registry.registerFillVerticalLineCommandCreator(FillVerticalLineCommand.class.getSimpleName());
        registry.registerClearCommandCreator(ClearCanvasCommand.class.getSimpleName());
    }
}
