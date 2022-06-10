package academy.pocu.comp2500.lab6;

public class MeatLoverPizza extends Pizza {
    private static final int PRICE = 21;

    public MeatLoverPizza() {
        price = PRICE;
        toppings.add(Topping.BACON);
        toppings.add(Topping.PEPERONI);
        toppings.add(Topping.HAM);
        toppings.add(Topping.SAUSAGES);
        toppings.add(Topping.CHEDDAR_CHEESE);
    }

    public boolean addBlackOlives() {
        if (isValid()) {
            return false;
        }

        this.toppings.add(Topping.BLACK_OLIVES);
        isValid = true;
        return true;
    }

    public boolean removeBlackOlives() {
        boolean isRemoved = this.toppings.remove(Topping.BLACK_OLIVES);

        if (isRemoved) {
            isValid = false;
        }

        return isRemoved;
    }

    public boolean addRedOnions() {
        if (isValid()) {
            return false;
        }

        this.toppings.add(Topping.RED_ONIONS);
        isValid = true;
        return true;
    }

    public boolean removeRedOnions() {
        boolean isRemoved = this.toppings.remove(Topping.RED_ONIONS);

        if (isRemoved) {
            isValid = false;
        }

        return isRemoved;
    }

    public boolean addGreenPeppers() {
        if (isValid()) {
            return false;
        }

        this.toppings.add(Topping.GREEN_PEPPERS);
        isValid = true;
        return true;
    }

    public boolean removeGreenPeppers() {
        boolean isRemoved = this.toppings.remove(Topping.GREEN_PEPPERS);

        if (isRemoved) {
            isValid = false;
        }

        return isRemoved;
    }


}
