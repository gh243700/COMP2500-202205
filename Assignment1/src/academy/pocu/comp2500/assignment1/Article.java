package academy.pocu.comp2500.assignment1;

import java.time.OffsetDateTime;
import java.util.ArrayList;
public class Article {
    private String title;
    private String content;
    private User author;
    private ArrayList<String> tags;
    private OffsetDateTime createdAt;
    private OffsetDateTime modifiedAt;
    private ArrayList<Comment> comments;

    public Article(User user, String title, String content) {
        this.author = user;
        this.title = title;
        this.content = content;
        this.tags = new ArrayList<>();
        this.createdAt = OffsetDateTime.now();
        this.comments = new ArrayList<>();
    }

    public Article(User user, String title, String content, OffsetDateTime offsetDateTime) {
        this(user, title, content);
        this.createdAt = offsetDateTime;
    }

    public boolean changeTitle(String title, User user) {
        if (!user.equals(this.author)) {
            return false;
        }

        modifiedAt = OffsetDateTime.now();
        this.title = title;
        return true;
    }

    public String getTitle() {
        return title;
    }

    public boolean changeContent(String content, User user) {
        if (!user.equals(this.author)) {
            return false;
        }


        modifiedAt = OffsetDateTime.now();
        this.content = content;
        return true;
    }

    public String getContent() {
        return content;
    }

    public void addTag(String tag) {
        tags.add(tag);
    }

    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    public OffsetDateTime getModifiedAt() {
        return modifiedAt;
    }

    public boolean hasTag(ArrayList<String> tagsOrNull) {
        if (tagsOrNull == null) {
            return false;
        }

         for(int i = 0; i < tags.size(); i++) {
             String t = this.tags.get(i);
             if(tagsOrNull.contains(t)) {
                 return true;
             }
         }

         return false;
    }

    public boolean hasSameAuthor(User author) {
        return this.author.equals(author);
    }

    public void registerComment(Comment comment) {
        comments.add(comment);
    }

    public ArrayList<Comment> readComments() {
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

}
