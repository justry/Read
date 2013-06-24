package fr.masciulli.read.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import fr.masciulli.read.R;
import fr.masciulli.read.data.ArticleItem;
import fr.masciulli.read.data.ArticleItemProvider;
import fr.masciulli.read.data.FeedItem;
import fr.masciulli.read.data.FeedItemProvider;

import java.util.List;

public class ArticleListAdapter extends BaseAdapter{
    protected final LayoutInflater mLayoutInflater;
    private final Resources mResources;
    private List<ArticleItem> mArticleItems;

    public ArticleListAdapter(Context context) {
        mLayoutInflater = LayoutInflater.from(context);
        mResources = context.getResources();
        mArticleItems = ArticleItemProvider.getItems();
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return mArticleItems.size();
    }

    @Override
    public ArticleItem getItem(int position) {
        return mArticleItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = mLayoutInflater.inflate(R.layout.articleitem, parent, false);
        }

        final TextView titleView = ReadHolder.get(convertView, R.id.articletitle);

        final ArticleItem articleItem = getItem(position);

        titleView.setText(articleItem.getTitle());

        return convertView;
    }
}
