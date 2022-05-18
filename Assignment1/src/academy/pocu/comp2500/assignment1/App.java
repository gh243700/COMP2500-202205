package academy.pocu.comp2500.assignment1;

import academy.pocu.comp2500.assignment1.registry.Registry;

public class App {
    public App(Registry registry) {
        // Register like this
        // registry.registerPostAdder("Foo", "bar");

        registry.registerBlogCreator("Blog");
        registry.registerTagFilterSetter("Blog", "tagsFilterSetter");
        registry.registerAuthorFilterSetter("Blog", "authorFilterSetter");
        registry.registerPostOrderSetter("Blog", "orderFilterSetter");
        registry.registerPostListGetter("Blog", "getPosts");
        registry.registerPostAdder("Blog", "registerPost");

        registry.registerPostTitleUpdater("Post", "changeTitle");
        registry.registerPostBodyUpdater("Post", "changeContent");
        registry.registerPostTagAdder("Post", "addTag");
        registry.registerCommentAdder("Post", "registerComment");

        registry.registerSubcommentAdder("Comment", "registerSubComment");
        registry.registerCommentUpdater("Comment", "changeComment");
        registry.registerSubcommentUpdater("Comment", "changeComment");

        registry.registerReactionAdder("Post" ,"registerReaction");
        registry.registerReactionRemover("Post", "removeReaction");
        registry.registerCommentUpvoter("Comment", "increaseUpVote");
        registry.registerCommentDownvoter("Comment", "increaseDownVote");

        registry.registerCommentListGetter("Post", "getComments");
        registry.registerSubcommentListGetter("Comment", "getSubComments");

        registry.registerSubcommentUpvoter("Comment", "increaseUpVote");
        registry.registerSubcommentDownvoter("Comment", "increaseDownVote");
    }
}
