package fr.masciulli.read.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import fr.masciulli.read.data.FeedItem;
import fr.masciulli.read.R;
import fr.masciulli.read.data.FeedItemProvider;

public class FeedListAdapter extends BaseAdapter {

    protected final LayoutInflater mLayoutInflater;
    private final Resources mResources;
    private List<FeedItem> mFeedItems;

    public FeedListAdapter(Context context) {
        mLayoutInflater = LayoutInflater.from(context);
        mResources = context.getResources();
        mFeedItems = FeedItemProvider.getItems();
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
        if(feedItem.getUnreadItems() != 0) {
            titleView.setTypeface(titleView.getTypeface(), 1);

            int unreadColor = mResources.getColor(android.R.color.black);
            titleView.setTextColor(unreadColor);
            unreadItemsView.setTextColor(unreadColor);
        }

        unreadItemsView.setText(String.format(mResources.getString(R.string.unreaditemscount),feedItem.getUnreadItems()));

        return convertView;
    }
}
