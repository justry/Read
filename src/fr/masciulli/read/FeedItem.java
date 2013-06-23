package fr.masciulli.read;

public class FeedItem {
    private String mTitle;
    private int mUnreadItems;

    public FeedItem(String title, int unreadItems) {
        mTitle = title;
        mUnreadItems = unreadItems;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public int getUnreadItems() {
        return mUnreadItems;
    }
}
