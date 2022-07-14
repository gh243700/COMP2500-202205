package academy.pocu.comp2500.lab9;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.UUID;
import java.util.Map;

public class BuyOneGetOneFree implements IGetPrice {
    private HashSet<UUID> skuNumbers;
    public BuyOneGetOneFree(HashSet<UUID> skuNumbers) {
        this.skuNumbers = skuNumbers;
    }
    @Override
    public int getTotalPrice(Collection<Book> collection) {
        HashMap<UUID, Integer> overlap = new HashMap<>();
        HashMap<UUID, Integer> priceBySku = new HashMap<>();
        int price = 0;

        for (Book book : collection) {
            UUID sku = book.getSku();
            if (skuNumbers.contains(sku)) {
                if (overlap.containsKey(sku)) {
                    int num = overlap.get(sku) + 1;
                    overlap.remove(sku);
                    overlap.put(sku, num);
                } else {
                    overlap.put(sku, 1);
                    priceBySku.put(sku, book.getPrice());
                }
            } else {
                price += book.getPrice();
            }
        }

        for (Map.Entry<UUID, Integer> entry : overlap.entrySet()) {
            int number = entry.getValue();
            number = number / 2 + number % 2;
            price += number * priceBySku.get(entry.getKey());
        }

        return price;
    }

}
