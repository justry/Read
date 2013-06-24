package fr.masciulli.read;

import android.os.Parcel;
import android.os.Parcelable;

public class FeedItem implements Parcelable{
    public static final Creator<FeedItem> CREATOR = new Creator<FeedItem>() {

        @Override
        public FeedItem createFromParcel(Parcel parcel) {
            return new FeedItem(parcel);
        }

        @Override
        public FeedItem[] newArray(int i) {
            return new FeedItem[0];
        }
    };
    private String mTitle;
    private int mUnreadItems;

    public FeedItem(String title, int unreadItems) {
        mTitle = title;
        mUnreadItems = unreadItems;
    }

    public FeedItem(Parcel parcel) {
        mTitle = parcel.readString();
        mUnreadItems = parcel.readInt();
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(mTitle);
        parcel.writeInt(mUnreadItems);
    }
}
