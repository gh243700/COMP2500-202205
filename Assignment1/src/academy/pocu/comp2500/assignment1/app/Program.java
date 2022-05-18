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

        Post post01 = new Post(user01, "title01", "content 01");
        Post post02 = new Post(user02, "title02", "content 02");
        Post post03 = new Post(user01, "title03", "content 03");

        blog01.registerPost(post01);
        blog01.registerPost(post02);
        blog01.registerPost(post03);


        ArrayList<Post> list = blog01.getPosts();


        System.out.printf("fin\n");

    }
}
