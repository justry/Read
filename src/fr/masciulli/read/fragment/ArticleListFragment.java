package fr.masciulli.read.fragment;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.view.*;
import android.widget.AdapterView;
import android.widget.ListView;

import android.widget.Toast;

import fr.masciulli.read.BusProvider;
import fr.masciulli.read.OpenArticleEvent;
import fr.masciulli.read.adapter.ArticleListAdapter;
import fr.masciulli.read.data.ArticleItem;
import fr.masciulli.read.data.FeedItem;
import fr.masciulli.read.R;

public class ArticleListFragment extends Fragment implements AdapterView.OnItemClickListener {
    private FeedItem mFeedItem;
    private ListView mArticleListView;
    private ArticleListAdapter mArticleListAdapter;
    private MenuItem mRefreshMenuItem;

    public static Fragment newInstance(FeedItem feedItem) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("item", feedItem);
        ArticleListFragment f = new ArticleListFragment();
        f.setArguments(bundle);
        return f;
    }

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		if (savedInstanceState == null) {
			final FragmentManager fm = getFragmentManager();
			if (fm.findFragmentByTag(ControllerFragment.FRAGMENT_TAG) == null) {
				fm.beginTransaction().add(new ControllerFragment(), ControllerFragment.FRAGMENT_TAG).commit();
			}
		}
	}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        mFeedItem = (FeedItem) getArguments().getParcelable("item");

        final View rootView = inflater.inflate(R.layout.fragment_articlelist, container, false);

        mArticleListView = (ListView) rootView.findViewById(R.id.articlelist);
        mArticleListAdapter = new ArticleListAdapter(getActivity(), mFeedItem);
        mArticleListView.setAdapter(mArticleListAdapter);

        mArticleListView.setOnItemClickListener(this);

        setHasOptionsMenu(true);

        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
        BusProvider.getInstance().register(this);
    }

    @Override
    public void onPause() {
        super.onPause();
        BusProvider.getInstance().unregister(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        // Notify the active callbacks interface (the activity, if the
        // fragment is attached to one) that an item has been selected.
        ArticleItem item = mArticleListAdapter.getItem(position);
        if (item != null) {
            BusProvider.getInstance().post(new OpenArticleEvent(item));

        }
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.detail, menu);
        mRefreshMenuItem = menu.findItem(R.id.menu_refresh_uvdetail);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_refresh_uvdetail:
                Toast.makeText(getActivity(), "Refreshing...", Toast.LENGTH_LONG).show();
                return true;
        }

        return false;
    }
}
