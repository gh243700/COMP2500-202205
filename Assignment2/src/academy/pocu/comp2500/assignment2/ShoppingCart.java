package academy.pocu.comp2500.assignment2;

import java.util.ArrayList;

public class ShoppingCart {
    private ArrayList<Product> products;

    private int totalPrice;
    public ArrayList<Product> getProducts() {
        return products;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public ShoppingCart() {
        products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
        totalPrice += product.getPrice();
    }

    public boolean removeProduct(Product product) {
        if (products.remove(product)) {
            totalPrice -= product.getPrice();
            return true;
        }
        return false;
    }
}
