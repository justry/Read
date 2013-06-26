package fr.masciulli.read.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.otto.Subscribe;

import fr.masciulli.read.BusProvider;
import fr.masciulli.read.OpenArticleEvent;
import fr.masciulli.read.R;

/**
 * A UI-less Fragment that acts like an abstract controller layer for Otto bus events.
 */
public class ControllerFragment extends Fragment {
	public static final String FRAGMENT_TAG = "Controller";

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setRetainInstance(true);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		return null;
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

	@Subscribe
	@SuppressWarnings("unused")
	public void onOpenArticle(OpenArticleEvent event) {
		getFragmentManager().beginTransaction()
				.setCustomAnimations(R.animator.slide_in, R.animator.slide_out,
						R.animator.slide_in_back, R.animator.slide_out_back)
				.replace(R.id.articlelistfragmentcontainer, ArticleDetailFragment.newInstance(event.item))
				.addToBackStack(null)
				.commit();

	}
}
