package academy.pocu.comp2500.assignment1;

import java.time.OffsetDateTime;
import java.util.ArrayList;
public class Post {
    private String title;
    private String content;
    private User author;
    private ArrayList<String> tags;
    private OffsetDateTime createdAt;
    private OffsetDateTime modifiedAt;
    private ArrayList<Comment> comments;

    private ArrayList<Reaction> reactions;
    public Post(User author, String title, String content) {
        this.author = author;
        this.title = title;
        this.content = content;
        this.tags = new ArrayList<>();
        this.createdAt = OffsetDateTime.now();
        this.modifiedAt = createdAt;
        this.comments = new ArrayList<>();
        this.reactions = new ArrayList<>();
    }
    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public User getAuthor() {
        return author;
    }

    public ArrayList<String> getTags() {
        return tags;
    }

    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    public OffsetDateTime getModifiedAt() {
        return modifiedAt;
    }

    public ArrayList<Comment> getComments() {
        for (int i = 0; i < comments.size(); i++) {
            for(int j = 0; j < comments.size() - i; j++) {
                Comment comment00 = comments.get(i);
                Comment comment01 = comments.get(j + i);
                if (comment00.getUpVote() - comment00.getDownVote() < comment01.getUpVote() - comment01.getDownVote()) {
                    comments.remove(i);
                    comments.add(i, comment01);
                    comments.remove(j + i);
                    comments.add(j + i, comment00);
                }
            }

        }

        return comments;
    }

    public int getReactions(Reaction reactionType) {
        int count = 0;
        for(int i = 0; i < reactions.size(); i++) {
            if (reactions.get(i) == reactionType) {
                count++;
            }
        }
        return count;
    }

    public boolean changeTitle(String title, User user) {
        if (!user.isSame(this.author)) {
            return false;
        }

        modifiedAt = OffsetDateTime.now();
        this.title = title;
        return true;
    }

    public boolean changeContent(String content, User user) {
        if (!user.isSame(this.author)) {
            return false;
        }

        modifiedAt = OffsetDateTime.now();
        this.content = content;
        return true;
    }

    public void addTag(String tag) {
        if(tags.contains(tag)) {
            return;
        }
        tags.add(tag);
    }

    public boolean hasTag(ArrayList<String> tags) {

         for(int i = 0; i < this.tags.size(); i++) {
             String t = this.tags.get(i);
             if(tags.contains(t)) {
                 return true;
             }
         }

         return false;
    }

    public void registerComment(Comment comment) {
        comments.add(comment);
    }


    public void registerReaction(Reaction reaction) {
        reactions.add(reaction);
    }


    public void removeReaction(Reaction reaction) {
        if (reactions.contains(reaction)) {
            reactions.remove(reaction);
        }

    }




}
