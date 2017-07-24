package com.cipolat.news.UI.Home;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;

import com.cipolat.news.Model.TheGuardianApiModel.Article;
import com.cipolat.news.Model.TheGuardianApiModel.NewsResponse;
import com.cipolat.news.R;
import com.cipolat.news.UI.ArticleViewer.ArticleViewerActivity;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements HomeView {

    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.listNews)
    RecyclerView listNews;
    private String TAG = MainActivity.class.getName();
    private HomePresenter mHomePresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        getWindow().setBackgroundDrawable(null);


        startDummyLoad();
        mHomePresenter = new HomePresenter(this);
        mHomePresenter.setView(this);
        mHomePresenter.getNews();
    }

    private void fillList(ArrayList<Article> lista) {
        final NewsAdapter adapter = new NewsAdapter(this, lista);
        listNews.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
       /* GridLayoutManager manager = new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false);
        manager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                // 2 column size for first row
                return (position == 0 ? 2 : 1);
            }
        });
        listNews.setLayoutManager(manager);*/
        adapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Article item = adapter.getItemByPos(listNews.getChildAdapterPosition(view));
                if (item != null) {
                    Intent inten = new Intent(getBaseContext(), ArticleViewerActivity.class);
                    inten.putExtra(ArticleViewerActivity.ARTICLE_ITEM_ID, item.getApiUrl());
                    inten.putExtra(ArticleViewerActivity.ARTICLE_ITEM_TITLE, item.getWebTitle());
                    startActivity(inten);
                }
            }
        });
        listNews.setAdapter(adapter);
        listNews.setHasFixedSize(true);

    }

    private void startDummyLoad() {
        //items de carga
        ArrayList<Article> listaDummy = new ArrayList();
        listaDummy.add(new Article(true));
        listaDummy.add(new Article(true));
        listaDummy.add(new Article(true));
        listaDummy.add(new Article(true));
        fillList(listaDummy);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu, menu);
        return true;

    }

    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }

    @Override
    public void onNewsSearchResponse(NewsResponse response) {

        fillList(response.getResponse().getResults());

    }

    @Override
    public void onNewsSearchFail() {

    }
}
