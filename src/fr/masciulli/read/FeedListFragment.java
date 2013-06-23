package fr.masciulli.read;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;

public class FeedListFragment extends Fragment {
    private ListView mFeedListView;
    private FeedListAdapter mFeedListAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_feedlist, container, false);

        mFeedListView = (ListView) rootView.findViewById(R.id.feedlist);

        mFeedListAdapter = new FeedListAdapter(getActivity());
        mFeedListView.setAdapter(mFeedListAdapter);


        return rootView;
    }
}
