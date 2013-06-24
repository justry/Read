package fr.masciulli.read.data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ArticleItemProvider {
    private static List<ArticleItem> mArticleItems = new ArrayList<ArticleItem>(Arrays.asList(new ArticleItem[]{
            new ArticleItem("Title of my article"),
            new ArticleItem("Title of my article"),
            new ArticleItem("Title of my article"),
            new ArticleItem("Title of my article"),
            new ArticleItem("Title of my article"),
            new ArticleItem("Title of my article"),
            new ArticleItem("Title of my article"),
            new ArticleItem("Title of my article"),
            new ArticleItem("Title of my article")
    }));

    public static List<ArticleItem> getItems() {
        return mArticleItems;
    }
}
