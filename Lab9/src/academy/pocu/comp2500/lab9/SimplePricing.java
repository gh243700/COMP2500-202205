package academy.pocu.comp2500.lab9;

import java.util.Collection;

public class SimplePricing implements IGetPrice {
    @Override
    public int getTotalPrice(Collection<Book> collection) {
        int price = 0;

        for (Book book : collection) {
            price += book.getPrice();
        }

        return price;
    }
}
