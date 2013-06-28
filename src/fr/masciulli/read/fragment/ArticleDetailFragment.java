package fr.masciulli.read.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import fr.masciulli.read.R;
import fr.masciulli.read.adapter.ArticleListAdapter;
import fr.masciulli.read.data.ArticleItem;

public class ArticleDetailFragment extends ReadFragment {
    public static Fragment newInstance(ArticleItem item) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("articleitem", item);
        ArticleDetailFragment f = new ArticleDetailFragment();
        f.setArguments(bundle);
        return f;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_articledetail, container, false);
        return rootView;
    }
}
