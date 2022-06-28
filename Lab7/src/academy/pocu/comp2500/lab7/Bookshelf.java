package academy.pocu.comp2500.lab7;

import java.util.ArrayList;

public class Bookshelf {
    private int numberOfBooks;
    private ArrayList<Book> books = new ArrayList<>();

    public Bookshelf(int numberOfBooks) {
        this.numberOfBooks = numberOfBooks;
    }

    public boolean add(Book book) {
        if (books.size() >= numberOfBooks) {
            return false;
        }
        return books.add(book);
    }

    public boolean remove(Book book) {
        for(Book b : books) {
            if (b.equals(book)) {
                return books.remove(b);
            }
        }

        return false;
    }
}
