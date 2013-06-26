package fr.masciulli.read.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import fr.masciulli.read.data.ArticleItem;

public class ArticleDetailFragment extends Fragment {
    public static Fragment newInstance(ArticleItem item) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("articleitem", item);
        ArticleDetailFragment f = new ArticleDetailFragment();
        f.setArguments(bundle);
        return f;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final String articleTitle = ((ArticleItem) getArguments().getParcelable("articleitem")).getTitle();
        TextView tv = new TextView(getActivity());
        tv.setText(articleTitle);
        return tv;
    }
}
