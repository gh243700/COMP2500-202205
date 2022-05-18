package academy.pocu.comp2500.assignment1;

public class User {
    private String userId;
    public String getUserId() {
        return userId;
    }

    public User(String userId) {
        this.userId = userId;
    }

    public boolean isSame(User user) {
        return userId.equals(user.getUserId());
    }

}
