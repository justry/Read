package fr.masciulli.read.fragment;

import android.app.Fragment;
import android.os.Bundle;

import fr.masciulli.read.data.ArticleItem;

public class ArticleDetailFragment extends Fragment {
    public static Fragment newInstance(ArticleItem item) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("articleitem", item);
        ArticleDetailFragment f = new ArticleDetailFragment();
        f.setArguments(bundle);
        return f;
    }
}
