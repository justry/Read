package fr.masciulli.read.activity;

import android.app.Activity;
import android.os.Bundle;

import android.view.MenuItem;

import com.squareup.otto.Subscribe;

import fr.masciulli.read.fragment.ArticleDetailFragment;
import fr.masciulli.read.fragment.ArticleListFragment;
import fr.masciulli.read.data.FeedItem;
import fr.masciulli.read.R;
import fr.masciulli.read.BusProvider;
import fr.masciulli.read.OpenArticleEvent;

public class ArticleListActivity extends Activity {
    private FeedItem mFeedItem;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_articlelist);
        mFeedItem = getIntent().getParcelableExtra("item");
        getActionBar().setTitle(mFeedItem.getTitle());
        getActionBar().setDisplayHomeAsUpEnabled(true);
        if (savedInstanceState == null) {
            getFragmentManager()
                    .beginTransaction()
                    .add(R.id.articlelistfragmentcontainer, ArticleListFragment.newInstance(mFeedItem))
                    .commit();
        }
    }

    @Override public void onResume() {
        super.onResume();
        BusProvider.getInstance().register(this);
    }

    @Override public void onPause() {
        super.onPause();
        BusProvider.getInstance().unregister(this);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Subscribe
    public void onOpenArticle(OpenArticleEvent event) {
        getFragmentManager().beginTransaction()
                .replace(R.id.articlelistfragmentcontainer, ArticleDetailFragment.newInstance(event.item))
                .commit();

    }
}
