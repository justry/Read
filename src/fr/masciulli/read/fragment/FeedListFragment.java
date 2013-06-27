package fr.masciulli.read.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.*;
import android.widget.AdapterView;
import android.widget.ListView;

import de.keyboardsurfer.android.widget.crouton.Crouton;
import fr.masciulli.read.data.FeedItem;
import fr.masciulli.read.adapter.FeedListAdapter;
import fr.masciulli.read.R;
import fr.masciulli.read.io.FeedListTaskFragment;
import fr.masciulli.read.util.ConnectionUtils;

public class FeedListFragment extends ReadFragment implements AdapterView.OnItemClickListener{
    private ListView mFeedListView;
    private FeedListAdapter mFeedListAdapter;

    private static final Callbacks sDummyCallbacks = new Callbacks() {
        @Override
        public void onItemSelected(FeedItem feedItem) {

        }
    };
    private Callbacks mCallbacks = sDummyCallbacks;

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

        if (!ConnectionUtils.isOnline(activity)) {
            handleNetworkError(activity);
        } else {
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

    public interface Callbacks {

        public void onItemSelected(FeedItem feedItem);
    }

}
