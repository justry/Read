package fr.masciulli.read.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.view.*;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import fr.masciulli.read.data.FeedItem;
import fr.masciulli.read.adapter.FeedListAdapter;
import fr.masciulli.read.R;
import fr.masciulli.read.io.FeedListTaskFragment;
import fr.masciulli.read.util.ConnectionUtils;

public class FeedListFragment extends ReadFragment implements AdapterView.OnItemClickListener,
        FeedListTaskFragment.Callbacks<List<FeedItem>>{
    private ListView mFeedListView;
    private FeedListAdapter mFeedListAdapter;
    private static final String STATE_FEED_LIST = "feedlist";

    private static final Callbacks sDummyCallbacks = new Callbacks() {
        @Override
        public void onItemSelected(FeedItem feedItem) {

        }
    };
    private Callbacks mCallbacks = sDummyCallbacks;

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if (mFeedListAdapter.hasFeeds()) {
            outState.putParcelableArrayList(STATE_FEED_LIST, (ArrayList) mFeedListAdapter.getFeedItems());
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        if (!(activity instanceof Callbacks)) {
            throw new IllegalStateException("Activity must implement fragment's callbacks.");
        }

        mCallbacks = (Callbacks) activity;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_feedlist, container, false);

        mFeedListView = (ListView) rootView.findViewById(R.id.feedlist);
        mFeedListView.setOnItemClickListener(this);
        mFeedListAdapter = new FeedListAdapter(getActivity());
        mFeedListView.setAdapter(mFeedListAdapter);

        final Activity activity = getActivity();

        final FeedListTaskFragment feedListTaskFragment = FeedListTaskFragment.get(activity.getFragmentManager(), this);
        if (savedInstanceState == null) {
            if (!ConnectionUtils.isOnline(activity)) {
                handleNetworkError(activity);
            } else {
                feedListTaskFragment.startNewTask();
            }
        } else {
            if (savedInstanceState.containsKey(STATE_FEED_LIST)) {
                final List<FeedItem> savedFeeds = savedInstanceState.getParcelableArrayList(STATE_FEED_LIST);
                mFeedListAdapter.setFeedItems(savedFeeds);
            }
            else {
                if(feedListTaskFragment.isRunning()) {
                    onPreExecute();
                }
            }
        }


        return rootView;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        // Notify the active callbacks interface (the activity, if the
        // fragment is attached to one) that an item has been selected.
        FeedItem item = mFeedListAdapter.getItem(position);
        if (item != null) {
            mCallbacks.onItemSelected(item);
        }
    }

    @Override
    public void onPreExecute() {

    }

    @Override
    public void onPostExecute(List<FeedItem> feedItems) {
        mFeedListAdapter.setFeedItems(feedItems);

    }

    @Override
    public void onError() {

    }

    public interface Callbacks {

        public void onItemSelected(FeedItem feedItem);
    }

}
