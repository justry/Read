package fr.masciulli.read.data;

import org.joda.time.DateTime;

public class ArticleItem {
    private String mTitle;
    private String mAuthor;
    private DateTime mDate;
    private String content;

    public ArticleItem(String title, String author, DateTime date, String content) {
        mTitle = title;
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
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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
