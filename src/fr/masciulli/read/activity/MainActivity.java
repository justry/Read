package fr.masciulli.read.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import fr.masciulli.read.data.FeedItem;
import fr.masciulli.read.R;
import fr.masciulli.read.fragment.ArticleListFragment;
import fr.masciulli.read.fragment.DefaultDetailFragment;
import fr.masciulli.read.fragment.FeedListFragment;

public class MainActivity extends Activity implements FeedListFragment.Callbacks {
    private boolean mTwoPane;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTwoPane = getResources().getBoolean(R.bool.two_pane);



        if (savedInstanceState == null) {
            if(mTwoPane) {
                getFragmentManager().beginTransaction()
                        .add(R.id.articlelistfragmentcontainer, new DefaultDetailFragment())
                        .commit();
            }
            getFragmentManager().beginTransaction()
                    .add(R.id.feedlistfragmentcontainer, FeedListFragment.newInstance(mTwoPane))
                    .commit();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.about:
                startActivity(new Intent(this, AboutActivity.class));
                break;

            case R.id.settings:
                // TODO implement settings Activity
                break;
        }
        return true;
    }

    @Override
    public void onItemSelected(FeedItem feedItem) {
        if (mTwoPane) {
            getFragmentManager().beginTransaction()
                    .replace(R.id.articlelistfragmentcontainer, ArticleListFragment.newInstance(feedItem))
                    .commit();
        } else {
            Intent intent = new Intent(this, ArticleListActivity.class);
            intent.putExtra("item", feedItem);
            startActivity(intent);
        }
    }
}
