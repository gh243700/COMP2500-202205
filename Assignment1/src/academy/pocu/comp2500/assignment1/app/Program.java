package academy.pocu.comp2500.assignment1.app;

import academy.pocu.comp2500.assignment1.*;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Timer;

public class Program {

    public static void main(String[] args) {
	    // write your code here
        User user01 = new User("user01");

        User a1 = new User("a1");
        User a2 = new User("a2");

        Blog blog = new Blog(user01);

        Post p1 = new Post(a1,"p1", "body");
        Post p2 = new Post(a1,"p2", "body");
        Post p3 = new Post(a2,"p3", "body");
        Post p4 = new Post(a2,"p4", "body");

        p1.addTag("t1");
        p2.addTag("t2");
        p3.addTag("t1");
        p4.addTag("t2");

        blog.registerPost(p1);
        blog.registerPost(p2);
        blog.registerPost(p3);
        blog.registerPost(p4);

        ArrayList tags = new ArrayList();
        tags.add("t1");
        blog.tagsFilterSetter(tags);

        ArrayList<Post> list = blog.getPosts();

        blog.tagsFilterSetter(new ArrayList<>());

        blog.authorFilterSetter(a1);

        list = blog.getPosts();

        blog.authorFilterSetter(null);

        blog.tagsFilterSetter(tags);
        blog.authorFilterSetter(a2);
        list = blog.getPosts();


        System.out.printf("fin\n");

    }
}
