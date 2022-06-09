package academy.pocu.comp2500.lab6.app;

import java.util.ArrayList;
import java.util.Set;

public class SetMenu extends Menu{

    protected ArrayList<Dessert> desserts = new ArrayList<>();

    protected SetMenu() {

    }

    public ArrayList<Dessert> getDesserts() {
        return this.desserts;
    }

}
