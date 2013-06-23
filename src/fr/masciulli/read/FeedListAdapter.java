package fr.masciulli.read;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FeedListAdapter extends BaseAdapter {

    protected final LayoutInflater mLayoutInflater;
    private final Resources mResources;
    private List<FeedItem> mFeedItems = new ArrayList<FeedItem>();

    public FeedListAdapter(Context context) {
        mLayoutInflater = LayoutInflater.from(context);
        mResources = context.getResources();
        for (int i = 0; i < 80; i++) {
            mFeedItems.add(new FeedItem("Titre de mon feed dynamique", i));
        }
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
        unreadItemsView.setText(String.format(mResources.getString(R.string.unreaditemscount),feedItem.getUnreadItems()));

        return convertView;
    }
}
