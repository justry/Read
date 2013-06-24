package fr.masciulli.read.data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import fr.masciulli.read.data.FeedItem;

public class FeedItemProvider {
    private static List<FeedItem> mFeedItems = new ArrayList<FeedItem>(Arrays.asList(new FeedItem[]{
            new FeedItem("Codedependent", 12),
            new FeedItem("Pushing Pixels", 2),
            new FeedItem("The Verge - Android", 0),
            new FeedItem("Curious Creature", 0),
            new FeedItem("Aurélien Meunier", 3),
            new FeedItem("Korben RSS", 75),
            new FeedItem("Cyril Mottier", 0)
    }));

    public static List<FeedItem> getItems() {
        return mFeedItems;
    }
}
