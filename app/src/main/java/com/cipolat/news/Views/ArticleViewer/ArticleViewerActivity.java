package com.cipolat.news.Views.ArticleViewer;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;

import com.cipolat.news.R;
import com.cipolat.news.Views.Home.NewsAdapter;

import java.util.ArrayList;

import Model.NewsItem;
import butterknife.Bind;
import butterknife.ButterKnife;

public class ArticleViewerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article_viewer);
        ButterKnife.bind(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // getMenuInflater().inflate(R.menu.toolbar_menu, menu);
        return true;

    }

    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }
}
