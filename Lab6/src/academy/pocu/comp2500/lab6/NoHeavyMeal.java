package academy.pocu.comp2500.lab6;
public class NoHeavyMeal extends Meal {

    private static final int PRICE = 15;

    public NoHeavyMeal() {
        price = PRICE;
    }

    public void setAppetizers(Appetizer appetizer1, Appetizer appetizer2) {
        this.appetizers.clear();

        this.appetizers.add(appetizer1);
        this.appetizers.add(appetizer2);
        isValid = this.appetizers.size() == 2 && this.desserts.size() != 0;
    }

    public void setDessert(Dessert dessert) {
        this.desserts.clear();
        this.desserts.add(dessert);
        isValid = this.appetizers.size() == 2 && this.desserts.size() != 0;
    }

}
