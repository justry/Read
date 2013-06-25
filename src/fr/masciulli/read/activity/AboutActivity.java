package fr.masciulli.read.activity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import fr.masciulli.read.R;

import android.text.Html;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class AboutActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        getActionBar().setDisplayHomeAsUpEnabled(true);
        ((TextView) findViewById(R.id.credits))
                .setText(Html.fromHtml(getResources().getString(R.string.credits)));
    }

    public void contact(View v) {
        final Intent sendIntent = new Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:alexandre.masciulli@gmail.com"));
        startActivity(Intent.createChooser(sendIntent, getResources().getString(R.string.intent_chooser_title)));
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
}
