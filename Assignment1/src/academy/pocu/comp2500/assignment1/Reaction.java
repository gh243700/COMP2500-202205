package academy.pocu.comp2500.assignment1;

public class Reaction {
    private ReactionType type;
    private User user;
    public ReactionType getType() {
        return type;
    }
    public Reaction(ReactionType type, User user) {
        this.type = type;
        this.user = user;
    }

    public User getUser() {
        return user;
    }

}
