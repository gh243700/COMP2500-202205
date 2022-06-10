package academy.pocu.comp2500.lab6;

public class Menu {
    private int price;
    protected boolean isValid;

    public boolean isValid() {
        return isValid;
    }

    public int getPrice() {
        return this.price;
    }

    protected Menu(int price) {
        this.price = price;
    }


}
