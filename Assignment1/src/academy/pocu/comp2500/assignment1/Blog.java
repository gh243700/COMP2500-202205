package academy.pocu.comp2500.assignment1;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;


public class Blog {
    private User owner;
    private ArrayList<Article> articles;

    private User filter_author;
    private ArrayList<String> filter_tags;
    private Sort filter_sort = Sort.SORT_BY_CREATED_DESC;

    public User getOwner() {
        return owner;
    }

    public Blog(User owner) {
        this.owner = owner;
        this.articles = new ArrayList<>();
    }
    public void registerArticle(Article article) {
        articles.add(article);
    }

    public ArrayList<Article> readArticles() {
        for (int i = 0; i < articles.size(); i++) {
            for (int j = 0; j < articles.size() - i; j++) {
                Article article00 = articles.get(i);
                Article article01 = articles.get(j + i);
                int compare = 0;
                switch (filter_sort) {
                    case SORT_BY_CREATED_DESC:
                        compare = article01.getCreatedAt().compareTo(article00.getCreatedAt());
                        break;
                    case SORT_BY_CREATED_ASC:
                        compare = article00.getCreatedAt().compareTo(article01.getCreatedAt());
                        break;
                    case SORT_BY_MODIFIED_DESC:
                        compare = article01.getModifiedAt().compareTo(article00.getModifiedAt());
                        break;
                    case SORT_BY_MODIFIED_ASC:
                        compare = article00.getModifiedAt().compareTo(article01.getModifiedAt());
                        break;
                    case SORT_BY_TITLE_ASC:
                        compare = article00.getTitle().compareTo(article01.getTitle());
                        break;
                }
                if (compare > 0) {
                    articles.remove(i);
                    articles.add(i, article01);
                    articles.remove(j + i);
                    articles.add(j + i, article00);
                }
            }
        }

        ArrayList<Article> result = null;

        if (filter_tags != null || filter_author != null) {
            result = new ArrayList<>();
            for (int i = 0; i < articles.size(); i++) {
                Article article = articles.get(i);
                if(article.hasTag(filter_tags) || article.hasSameAuthor(filter_author)) {
                    result.add(article);
                }
            }
        } else {
            result = articles;
        }

        return result;
    }

    public void tagsFilterSetter(ArrayList<String> tags) {
        filter_tags = tags;
    }

    public void authorFilterSetter(User author) {
        filter_author = author;
    }

    public void orderFilterSetter(Sort sort) {
        this.filter_sort = sort;
    }
}
