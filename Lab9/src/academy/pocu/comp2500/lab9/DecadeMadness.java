package academy.pocu.comp2500.lab9;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class DecadeMadness implements IGetPrice {

    @Override
    public int getTotalPrice(Collection<Book> books) {

        HashMap<Integer, Integer> kYearVPrice = new HashMap<>();
        HashSet<Integer> kYearVExists = new HashSet<>();
        double totalPrice = 0.0f;

        for (Book book : books) {
            int year = book.getPublishedYear() - book.getPublishedYear() % 10;
            if (kYearVPrice.containsKey(year)) {
                int price = kYearVPrice.get(year) + book.getPrice();
                kYearVPrice.remove(year);
                kYearVPrice.put(year, price);
                kYearVExists.add(year);
            } else {
                kYearVPrice.put(year, book.getPrice());
            }
        }

        for (Map.Entry<Integer, Integer> entry : kYearVPrice.entrySet()) {
            if (kYearVExists.contains(entry.getKey())) {
                totalPrice += entry.getValue() * 0.8f;
            } else {
                totalPrice += entry.getValue();
            }

        }

        return (int) totalPrice;
    }

}
