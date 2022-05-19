package academy.pocu.comp2500.assignment1;

import java.util.ArrayList;


public class Blog {
    private User user;
    private ArrayList<Post> posts;
    private User filterAuthorOrNull;
    private ArrayList<String> filterTags;
    private SortingType filterSortingType = SortingType.SORT_BY_CREATED_DESC;

    public Blog(User user) {
        this.user = user;
        this.posts = new ArrayList<>();
        this.filterTags = new ArrayList<>();
    }

    public User getUser() {
        return user;
    }

    public ArrayList<Post> getPosts() {
        for (int i = 0; i < posts.size(); i++) {
            for (int j = 0; j < posts.size() - i; j++) {
                Post post00 = posts.get(i);
                Post post01 = posts.get(j + i);
                int compare = 0;
                switch (filterSortingType) {
                    case SORT_BY_CREATED_DESC:
                        compare = post01.getCreatedAt().compareTo(post00.getCreatedAt());
                        break;
                    case SORT_BY_CREATED_ASC:
                        compare = post00.getCreatedAt().compareTo(post01.getCreatedAt());
                        break;
                    case SORT_BY_MODIFIED_DESC:
                        compare = post01.getModifiedAt().compareTo(post00.getModifiedAt());
                        break;
                    case SORT_BY_MODIFIED_ASC:
                        compare = post00.getModifiedAt().compareTo(post01.getModifiedAt());
                        break;
                    case SORT_BY_TITLE_ASC:
                        compare = post00.getTitle().compareTo(post01.getTitle());
                        break;
                }
                if (compare > 0) {
                    posts.remove(i);
                    posts.add(i, post01);
                    posts.remove(j + i);
                    posts.add(j + i, post00);
                }
            }
        }

        ArrayList<Post> result = null;

        if (filterTags.size() > 0 || filterAuthorOrNull != null) {
            result = new ArrayList<>();
            for (int i = 0; i < posts.size(); i++) {
                Post post = posts.get(i);
                if (filterTags.size() > 0 && filterAuthorOrNull != null) {
                    if (post.hasTag(filterTags) && post.getAuthor().isSame(filterAuthorOrNull)) {
                        result.add(post);
                    }
                } else if (post.hasTag(filterTags) || post.getAuthor().isSame(filterAuthorOrNull)) {
                    result.add(post);
                }
            }
        } else {
            result = posts;
        }

        return result;
    }

    public User getFilterAuthorOrNull() {
        return filterAuthorOrNull;
    }

    public ArrayList<String> getFilterTags() {
        return filterTags;
    }

    public SortingType getFilterSortingType() {
        return filterSortingType;
    }

    public void registerPost(Post post) {
        posts.add(post);
    }
    public void tagsFilterSetter(ArrayList<String> tags) {
        filterTags = tags;
    }
    public void authorFilterSetter(User authorOrNull) {
        filterAuthorOrNull = authorOrNull;
    }
    public void orderFilterSetter(SortingType sortingType) {
        this.filterSortingType = sortingType;
    }
}
