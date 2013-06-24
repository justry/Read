package fr.masciulli.read.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import fr.masciulli.read.data.FeedItem;
import fr.masciulli.read.R;

public class ArticleListFragment extends Fragment {
    private FeedItem mFeedItem;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        mFeedItem = (FeedItem)getArguments().getParcelable("item");
        return inflater.inflate(R.layout.fragment_articlelist, container, false);
    }

    public static Fragment newInstance(FeedItem feedItem) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("item", feedItem);
        ArticleListFragment f = new ArticleListFragment();
        f.setArguments(bundle);
        return f;
    }
}
