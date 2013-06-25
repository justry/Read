package fr.masciulli.read.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

import fr.masciulli.read.data.ArticleItem;

public class ArticleDetailActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Toast.makeText(this, ((ArticleItem)getIntent().getParcelableExtra("articleitem")).getTitle(), Toast.LENGTH_SHORT).show();
    }
}
