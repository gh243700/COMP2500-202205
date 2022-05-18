package academy.pocu.comp2500.assignment1;

import java.util.ArrayList;

public class Comment {
    private User user;
    private String text;
    private int upVote;
    private int downVote;
    private ArrayList<Comment> subComments;



    public Comment(User user, String text) {
        this.user = user;
        this.text = text;
        this.subComments = new ArrayList<>();
    }

    public User getUser() {
        return user;
    }

    public String getText() {
        return text;
    }

    public int getUpVote() {
        return upVote;
    }

    public int getDownVote() {
        return downVote;
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




}
