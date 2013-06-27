package fr.masciulli.read.data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import fr.masciulli.read.data.FeedItem;

public class FeedItemProvider {
    private static List<FeedItem> mFeedItems = new ArrayList<FeedItem>(Arrays.asList(new FeedItem[]{
            new FeedItem("", "Codedependent", 12, "http://masciulli.fr"),
            new FeedItem("", "Pushing Pixels", 2, "http://masciulli.fr"),
            new FeedItem("", "The Verge - Android", 0, "http://masciulli.fr"),
            new FeedItem("", "Curious Creature", 0, "http://masciulli.fr"),
            new FeedItem("", "Aurélien Meunier", 3, "http://masciulli.fr"),
            new FeedItem("","Korben RSS", 75, "http://masciulli.fr"),
            new FeedItem("", "Cyril Mottier", 0, "http://masciulli.fr")
    }));

    public static List<FeedItem> getItems() {
        return mFeedItems;
    }
}
