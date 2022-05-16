package academy.pocu.comp2500.assignment1;

import java.util.ArrayList;

public class Comment {
    private User user;
    private String comment;
    private int upVote;
    private int downVote;
    private ArrayList<Comment> subComments;

    public Comment(User user, String comment) {
        this.user = user;
        this.comment = comment = comment;
    }

    public String getComment() {
        return comment;
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

}
