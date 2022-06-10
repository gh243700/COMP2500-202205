package academy.pocu.comp2500.lab6;

import java.util.ArrayList;

public class Meal extends SetMenu{

    protected ArrayList<Appetizer> appetizers = new ArrayList<>();

    protected Meal() {

    }

    public ArrayList<Appetizer> getAppetizers() {
        return this.appetizers;
    }


}
