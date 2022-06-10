package academy.pocu.comp2500.lab6;

public class HousePizza extends Pizza {
    private static final int PRICE = 20;
    private static final int MAX_MEAT_COUNT = 2;
    private int meatCount;


    public HousePizza() {
        price = PRICE;
        toppings.add(Topping.BLACK_OLIVES);
        toppings.add(Topping.RED_ONIONS);
        toppings.add(Topping.GREEN_PEPPERS);
        toppings.add(Topping.MOZZARELLA_CHEESE);
    }

    private void setValid() {
        isValid = this.meatCount == MAX_MEAT_COUNT;
    }

    public boolean addBacon() {
        if (isValid()) {
            return false;
        }

        this.toppings.add(Topping.BACON);
        ++this.meatCount;
        setValid();
        return true;
    }

    public boolean removeBacon() {
        boolean isRemoved = this.toppings.remove(Topping.BACON);

        if (isRemoved) {
            --this.meatCount;
            setValid();
        }

        return isRemoved;
    }

    public boolean addPeperoni() {
        if (isValid()) {
            return false;
        }

        this.toppings.add(Topping.PEPERONI);
        ++this.meatCount;
        setValid();
        return true;
    }

    public boolean removePeperoni() {
        boolean isRemoved = this.toppings.remove(Topping.PEPERONI);

        if (isRemoved) {
            --this.meatCount;
            setValid();
        }

        return isRemoved;
    }

    public boolean addSausages() {
        if (isValid()) {
            return false;
        }

        this.toppings.add(Topping.SAUSAGES);
        ++this.meatCount;
        setValid();
        return true;
    }

    public boolean removeSausages() {
        boolean isRemoved = this.toppings.remove(Topping.SAUSAGES);

        if (isRemoved) {
            --this.meatCount;
            setValid();
        }

        return isRemoved;
    }
}
