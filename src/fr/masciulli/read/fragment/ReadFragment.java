package fr.masciulli.read.fragment;

import android.app.Activity;
import android.app.Fragment;

import de.keyboardsurfer.android.widget.crouton.Crouton;
import fr.masciulli.read.R;
import fr.masciulli.read.util.ConnectionUtils;

/**
 * Created by Alexandre on 27/06/13.
 */
public class ReadFragment extends Fragment {

        protected void handleNetworkError(Activity activity) {
            Crouton.makeText(activity,
                    activity.getString(R.string.network_error_message),
                    ConnectionUtils.NETWORK_ERROR_STYLE).show();
        }
}
