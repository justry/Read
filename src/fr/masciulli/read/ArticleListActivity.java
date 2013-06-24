package fr.masciulli.read;

import android.app.Activity;
import android.os.Bundle;

public class ArticleListActivity extends Activity {
    private FeedItem mFeedItem;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_articlelist);
        mFeedItem = getIntent().getParcelableExtra("item");
        getActionBar().setTitle(mFeedItem.getTitle());
        if(savedInstanceState == null) {
            getFragmentManager()
                    .beginTransaction()
                    .add(R.id.articlelistfragmentcontainer, ArticleListFragment.newInstance(mFeedItem))
                    .commit();
        }
    }
}
