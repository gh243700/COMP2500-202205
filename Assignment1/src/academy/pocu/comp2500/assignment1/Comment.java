package academy.pocu.comp2500.assignment1;

import java.util.ArrayList;

public class Comment {
    private User user;
    private String text;
    private int upVote;
    private int downVote;
    private ArrayList<Comment> subComments;
    private ArrayList<Emoji> emojis;

    public Comment(User user, String text) {
        this.user = user;
        this.text = text;
        this.subComments = new ArrayList<>();
        this.emojis = new ArrayList<>();
    }

    public String getText() {
        return text;
    }

    public ArrayList<Emoji> getEmojis() {
        return emojis;
    }

    public int getUpVote() {
        return upVote;
    }

    public int getDownVote() {
        return downVote;
    }

    public void increaseUpVote(){
        upVote++;
    }

    public void increaseDownVote(){
        downVote++;
    }

    public void registerSubComment(Comment comment) {
        subComments.add(comment);
    }

    public boolean changeComment(User user, String text) {
        if (!this.user.isSame(user)) {
            return false;
        }

        this.text = text;
        return true;
    }

    public User getUser() {
        return user;
    }

    public boolean registerEmoji(Emoji emoji) {
        for (int i = 0; i < emojis.size(); i++) {
            Emoji emoji0 = emojis.get(i);
            if (emoji0.getUser().isSame(emoji.getUser())) {
                if (emoji0.getType() == emoji.getType()) {
                    return false;
                }
                else {
                    emojis.add(emoji);
                    return true;
                }
            }
        }

        emojis.add(emoji);
        return true;
    }
    public boolean removeEmoji(Emoji emoji) {
        for (int i = 0; i < emojis.size(); i++) {
            Emoji emoji0 = emojis.get(i);
            if (emoji0.getType() == emoji.getType() && emoji.getUser().isSame(emoji0.getUser())) {
                emojis.remove(emoji0);
                return true;
            }
        }

        return false;
    }
    public ArrayList<Comment> getSubComments() {
        for (int i = 0; i < subComments.size(); i++) {
            for(int j = 0; j < subComments.size() - i; j++) {
                Comment comment00 = subComments.get(i);
                Comment comment01 = subComments.get(j + i);
                if (comment00.getUpVote() - comment00.getDownVote() < comment01.getUpVote() - comment01.getDownVote()) {
                    subComments.remove(i);
                    subComments.add(i, comment01);
                    subComments.remove(j + i);
                    subComments.add(j + i, comment00);
                }
            }

        }

        return subComments;
    }

}
