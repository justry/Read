package fr.masciulli.read.data;

import android.os.Parcel;
import android.os.Parcelable;

import org.joda.time.DateTime;

public class ArticleItem implements Parcelable {
    private String mTitle;
    private String mAuthor;
    private DateTime mDate;
    private String mContent;
    private boolean mRead;

    public static final Creator<ArticleItem> CREATOR = new Creator<ArticleItem>() {

        @Override
        public ArticleItem createFromParcel(Parcel parcel) {
            return new ArticleItem(parcel);
        }

        @Override
        public ArticleItem[] newArray(int i) {
            return new ArticleItem[0];
        }
    };

    public ArticleItem(String title, String author, DateTime date, String content, boolean read) {
        mTitle = title;
        mAuthor = author;
        mDate = date;
        mContent = content;
        mRead = read;
    }

    public ArticleItem() {

    }

    public ArticleItem(Parcel parcel) {
        mTitle = parcel.readString();
        mAuthor = parcel.readString();
        mDate = new DateTime(parcel.readLong());
        mContent = parcel.readString();
        mRead = parcel.readInt() > 0;
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

    public boolean isRead() {
        return mRead;
    }

    public void setRead(boolean read) {
        mRead = read;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(mTitle);
        parcel.writeString(mAuthor);
        parcel.writeLong(mDate.getMillis());
        parcel.writeString(mContent);
        parcel.writeInt(mRead ? 1 : 0);
    }
}
