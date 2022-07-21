package academy.pocu.comp2500.lab10;

import academy.pocu.comp2500.lab10.pocuflix.User;

public class Request {
    private String movieName;
    private User userOrNull;

    public String getMovieName() {
        return movieName;
    }

    public User getUserOrNull() {
        return userOrNull;
    }

    public Request(String movieName) {
        this.movieName = movieName;
    }

    public void setUser(User user) {
        this.userOrNull = user;
    }

    @Override
    public int hashCode() {
        if (userOrNull == null) {
            return getMovieName().hashCode();
        }

        return getMovieName().hashCode() ^ (getUserOrNull().hashCode() << 16);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (obj instanceof Request == false) {
            return false;
        }

        Request request = (Request) obj;
        return this.hashCode() == request.hashCode();
    }
}
