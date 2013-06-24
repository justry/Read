package fr.masciulli.read;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.*;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;

public class FeedListFragment extends Fragment implements AdapterView.OnItemClickListener{
    private ListView mFeedListView;
    private FeedListAdapter mFeedListAdapter;

    private static final Callbacks sDummyCallbacks = new Callbacks() {
        @Override
        public void onItemSelected(FeedItem feedItem) {

        }
    };
    private Callbacks mCallbacks = sDummyCallbacks;
    private boolean mTwoPane;

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

        mTwoPane = getArguments().getBoolean("twoPane");

        mFeedListView = (ListView) rootView.findViewById(R.id.feedlist);
        mFeedListView.setOnItemClickListener(this);
        mFeedListAdapter = new FeedListAdapter(getActivity());
        mFeedListView.setAdapter(mFeedListAdapter);

        if(mTwoPane) {
            mFeedListView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
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

    public static Fragment newInstance(boolean twoPane) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("twoPane", twoPane);
        FeedListFragment f = new FeedListFragment();
        f.setArguments(bundle);
        return f;
    }

    public interface Callbacks {

        public void onItemSelected(FeedItem feedItem);
    }

}
