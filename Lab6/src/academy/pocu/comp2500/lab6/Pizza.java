package academy.pocu.comp2500.lab6;

import java.util.ArrayList;

public class Pizza extends Menu {
    protected ArrayList<Topping> toppings = new ArrayList<>();
    protected Pizza() {
    }

    public ArrayList<Topping> getToppings() {
        return this.toppings;
    }

}
