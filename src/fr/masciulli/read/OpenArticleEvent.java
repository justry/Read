package fr.masciulli.read;

import fr.masciulli.read.data.ArticleItem;

public class OpenArticleEvent {
    public ArticleItem item;

    public OpenArticleEvent(ArticleItem item) {
        this.item = item;
    }
}
