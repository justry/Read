package fr.masciulli.read.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import fr.masciulli.read.data.FeedItem;
import fr.masciulli.read.R;
import fr.masciulli.read.data.FeedItemProvider;

public class FeedListAdapter extends BaseAdapter {

    protected final LayoutInflater mLayoutInflater;
    private final Resources mResources;
    private List<FeedItem> mFeedItems = Collections.emptyList();

    public FeedListAdapter(Context context) {
        mLayoutInflater = LayoutInflater.from(context);
        mResources = context.getResources();
    }

    public void setFeedItems(List<FeedItem> feedItems) {
        mFeedItems = feedItems;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return mFeedItems.size();
    }

    @Override
    public FeedItem getItem(int position) {
        return mFeedItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = mLayoutInflater.inflate(R.layout.feeditem, parent, false);
        }

        final TextView titleView = ReadHolder.get(convertView, R.id.feedtitle);
        final TextView unreadItemsView = ReadHolder.get(convertView, R.id.feedunreaditems);

        final FeedItem feedItem = getItem(position);

        titleView.setText(feedItem.getTitle());

        int typefaceStyle = feedItem.getUnreadItems() == 0 ? Typeface.NORMAL : Typeface.BOLD;
        int textColorRes = feedItem.getUnreadItems() == 0 ? R.color.read : R.color.unread;
        int textColor = mResources.getColor(textColorRes);

        titleView.setTypeface(null, typefaceStyle);
        titleView.setTextColor(textColor);
        unreadItemsView.setTextColor(textColor);

        unreadItemsView.setText(String.format(mResources.getString(R.string.unreaditemscount), feedItem.getUnreadItems()));

        return convertView;
    }

    public boolean hasFeeds() {
        return !mFeedItems.isEmpty();
    }

    public List<FeedItem> getFeedItems() {
        return mFeedItems;
    }
}
