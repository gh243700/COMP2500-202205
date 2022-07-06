package academy.pocu.comp2500.lab7;

import java.util.ArrayList;

public class ReadingList {
    private String name;
    private ArrayList<Book> books = new ArrayList<>();

    public ReadingList(String name) {
        this.name = name;
    }

    public boolean add(Book book) {
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
    public String toString() {
        StringBuilder sb = new StringBuilder();

        int i = 1;
        for (Book b : books) {
            sb.append(i).append('.').append(' ').append(b.toString()).append("\n");
            i++;
        }

        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || !(obj instanceof ReadingList)) {
            return false;
        }

        ReadingList other = (ReadingList) obj;

        if (!this.name.equals(other.name) || this.books.size() != other.books.size()) {
            return false;
        }

        for (int i = 0; i < this.books.size(); i++) {
            if (!books.get(i).equals(other.books.get(i))) {
                return false;
            }
        }

        return true;
    }

    @Override
    public int hashCode() {
        int hash = name.hashCode();
        for (Book b : books) {
            hash = 65599 * hash + b.hashCode();
        }

        return hash ^ (hash >> 16);
    }
}
