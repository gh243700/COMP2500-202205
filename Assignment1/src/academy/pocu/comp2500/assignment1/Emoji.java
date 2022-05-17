package academy.pocu.comp2500.assignment1;

public class Emoji {
    private EmojiType type;
    private User user;

    public EmojiType getType() {
        return type;
    }

    public Emoji(EmojiType type, User user) {
        this.type = type;
        this.user = user;
    }

    public User getUser() {
        return user;
    }

}
