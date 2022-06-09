package academy.pocu.comp2500.lab6;
import java.util.ArrayList;
public class NoHeavyMeal extends Meal {
    private static final int PRICE = 15;

    private ArrayList<Appetizer> appetizers = new ArrayList<>();

    public NoHeavyMeal() {
        price = PRICE;
    }

    public boolean isValid() {
        return this.appetizers.size() == 2 && this.desserts.size() != 0;
    }

    public ArrayList<Appetizer> getAppetizers() {
        return this.appetizers;
    }

    public void setAppetizers(Appetizer appetizer1, Appetizer appetizer2) {
        this.appetizers.clear();

        this.appetizers.add(appetizer1);
        this.appetizers.add(appetizer2);
    }

}
