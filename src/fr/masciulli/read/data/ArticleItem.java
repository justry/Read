package fr.masciulli.read.data;

import org.joda.time.DateTime;

public class ArticleItem {
    private String mTitle;
    private String mAuthor;
    private DateTime mDate;
    private String mContent;

    public ArticleItem(String title, String author, DateTime date, String content) {
        mTitle = title;
        mAuthor = author;
        mDate = date;
        mContent = content;
    }

    public ArticleItem() {

    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        this.mTitle = title;
    }

    public String getContent() {
        return mContent;
    }

    public void setContent(String content) {
        this.mContent = content;
    }

    public String getAuthor() {
        return mAuthor;
    }

    public void setAuthor(String author) {
        this.mAuthor = author;
    }

    public DateTime getDate() {
        return mDate;
    }

    public void setDate(DateTime date) {
        this.mDate = date;
    }
}
