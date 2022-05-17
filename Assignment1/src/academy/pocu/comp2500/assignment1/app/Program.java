package academy.pocu.comp2500.assignment1.app;

import academy.pocu.comp2500.assignment1.*;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;

public class Program {

    public static void main(String[] args) {
	    // write your code here
        User user01 = new User("123");
        User user02 = new User("1234");

        Blog blog01 = new Blog(user01);

        Post post01 = new Post(user01, "title01", "content 01", OffsetDateTime.of(2020, 1, 1, 0, 0, 0, 0, ZoneOffset.UTC));

        Comment comment01 = new Comment(user02, "comment01");
        Comment comment02 = new Comment(user02, "comment02");
        Comment comment03 = new Comment(user02, "comment03");

        post01.registerComment(comment01);
        post01.registerComment(comment02);
        post01.registerComment(comment03);

        comment01.increaseUpVote();
        comment01.increaseUpVote();
        comment01.increaseUpVote();

        comment03.increaseUpVote();

        ArrayList<Comment> comments = post01.readComments();






        System.out.printf("fin\n");

    }
}
