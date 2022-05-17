package academy.pocu.comp2500.assignment1;

import academy.pocu.comp2500.assignment1.registry.Registry;

public class App {
    public App(Registry registry) {
        // Register like this
        // registry.registerPostAdder("Foo", "bar");

        registry.registerBlogCreator("Blog");
        registry.registerTagFilterSetter("Blog", "tagsFilterSetter");
        registry.registerAuthorFilterSetter("Blog", "registerAuthorFilterSetter");
        registry.registerPostOrderSetter("Blog", "orderFilterSetter");
        registry.registerPostListGetter("Blog", "readArticles");
        registry.registerPostAdder("Blog", "registerArticle");

        registry.registerPostTitleUpdater("Article", "changeTitle");
        registry.registerPostBodyUpdater("Article", "changeContent");
        registry.registerPostTagAdder("Article", "addTag");
        registry.registerCommentAdder("Article", "registerComment");

        registry.registerSubcommentAdder("Comment", "registerSubComment");
        registry.registerCommentUpdater("Comment", "changeComment");
        registry.registerSubcommentUpdater("Comment", "changeComment");

        registry.registerReactionAdder("Comment" ,"registerEmoji");
        registry.registerReactionRemover("Comment", "removeEmoji");
        registry.registerCommentUpvoter("Comment", "increaseUpVote");
        registry.registerCommentDownvoter("Comment", "increaseDownVote");

        registry.registerCommentListGetter("Article", "readComments");
        registry.registerSubcommentListGetter("Comment", "readSubComments");

        registry.registerSubcommentUpvoter("Comment", "increaseUpVote");
        registry.registerSubcommentDownvoter("Comment", "increaseDownVote");
    }
}
