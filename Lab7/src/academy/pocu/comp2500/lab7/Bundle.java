package academy.pocu.comp2500.lab7;

import java.util.ArrayList;
import java.util.stream.Stream;

public class Bundle {
    private String name;
    private ArrayList<Book> books = new ArrayList<>();

    public Bundle(String name) {
        this.name = name;
    }


    public boolean add(Book book) {
        for (Book b : books) {
            if(b.equals(book)) {
                return false;
            }
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

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || !(obj instanceof Bundle)) {
            return false;
        }
        Bundle other = (Bundle) obj;

        if (this.books.size() != other.books.size()) {
            return false;
        }

        int count = 0;
        for (Book a : books) {
            for (Book b : other.books) {
                if (a.equals(b)) {
                    count++;
                    continue;
                }
            }
        }

        return this.name.equals(other.name) && count == books.size();
    }

    @Override
    public int hashCode() {
        int hash = 0;
        for (Book b : books) {
            hash = 65599 * hash + b.hashCode();
        }
        return name.hashCode() ^ (hash ^ (hash >> 16) << 16);
    }
}
