package academy.pocu.comp2500.lab7;

public class Book {
    private String title;
    private Author author;
    private int from;
    private Genre genre;

    public Book(String title, Author author, int from, Genre genre) {
        this.title = title;
        this.author = author;
        this.from = from;
        this.genre = genre;
    }

    @Override
    public String toString() {
        return title + " [" + author.toString() + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || !(obj instanceof Book)){
            return false;
        }

        Book other = (Book) obj;
        return this.title.equals(other.title) && this.author.equals(other.author) && this.from == other.from && this.genre == other.genre;
    }

    @Override
    public int hashCode() {
        return title.hashCode() ^ author.hashCode() ^ from ^ genre.hashCode();
    }
}
