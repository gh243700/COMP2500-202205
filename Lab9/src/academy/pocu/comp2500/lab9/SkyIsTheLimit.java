package academy.pocu.comp2500.lab9;

import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;

public class SkyIsTheLimit implements IGetPrice {
    private final int MIN_PRICE;
    public SkyIsTheLimit(int price) {
        this.MIN_PRICE = price;
    }
    @Override
    public int getTotalPrice(Collection<Book> collection) {
        ArrayList<Book> books = new ArrayList<>(collection);

        Book max1 = null;
        Book max2 = null;
        double price = 0.0f;

        for (Book book : collection) {
            if (max1 == null || book.getPrice() >= max1.getPrice()) {
                max2 = max1;
                max1 = book;
            } else if (max2 == null || book.getPrice() >= max2.getPrice()) {
                max2 = book;
            }

            price += book.getPrice();
        }

        if (price >= MIN_PRICE && books.size() >= 5) {
            price -= max1.getPrice() * 0.5f + max2.getPrice() * 0.5f;
        }

        return (int) price;
    }

}
