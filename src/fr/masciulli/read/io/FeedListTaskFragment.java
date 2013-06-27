package fr.masciulli.read.io;

import android.app.FragmentManager;
import android.os.SystemClock;

import java.util.List;

import fr.masciulli.read.data.FeedItem;
import fr.masciulli.read.data.FeedItemProvider;
import fr.masciulli.read.fragment.FeedListFragment;

public class FeedListTaskFragment extends BaseTaskFragment {
    private static final String FEED_LIST_TASK_TAG = "FeedListTag";

    @Override
    protected void start() {
        mTask = new FeedListAsyncTask();
        ((FeedListAsyncTask) mTask).execute();
    }

    @Override
    protected void startOnThreadPoolExecutor() {
    }

    public static FeedListTaskFragment get(FragmentManager fragmentManager, Callbacks callbacks) {
        FeedListTaskFragment feedListTaskFragment =
                (FeedListTaskFragment) fragmentManager.findFragmentByTag(FEED_LIST_TASK_TAG);
        if (feedListTaskFragment == null) {
            feedListTaskFragment = new FeedListTaskFragment();
            fragmentManager.beginTransaction().add(feedListTaskFragment, FEED_LIST_TASK_TAG).commit();
        }
        feedListTaskFragment.setCallbacks(callbacks);
        return feedListTaskFragment;
    }

    private class FeedListAsyncTask extends FragmentTask<Void, Void, List<FeedItem>> {

        @Override
        protected List<FeedItem> doInBackground(Void... voids) {
            SystemClock.sleep(5000);
            return FeedItemProvider.getItems();
        }
    }
}
