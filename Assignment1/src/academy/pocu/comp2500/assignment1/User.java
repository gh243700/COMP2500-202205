package academy.pocu.comp2500.assignment1;

public class User {
    private String userId;

    public String getUserId() {
        return userId;
    }

    public User(String userId) {
        this.userId = userId;
    }
    
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        User tar = (User)obj;

        return userId.equals(tar.getUserId());
    }

}
