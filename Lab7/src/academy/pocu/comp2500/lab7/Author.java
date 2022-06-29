package academy.pocu.comp2500.lab7;

public class Author {

    private String firstName;
    private String lastName;

    public Author(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }


    @Override
    public String toString() {
        return firstName + " " + lastName;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || !(obj instanceof Author)) {
            return false;
        }
        Author other = (Author) obj;
        return this.firstName.equals(other.firstName) && this.lastName.equals(other.lastName);
    }

    @Override
    public int hashCode() {
        return this.firstName.hashCode() ^ (this.lastName.hashCode() << 16);
    }

}
