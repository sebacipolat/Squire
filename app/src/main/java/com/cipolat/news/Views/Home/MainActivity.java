package com.cipolat.news.Views.Home;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;

import com.cipolat.news.R;

import java.util.ArrayList;

import Model.NewsItem;
import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.listNews)
    RecyclerView listNews;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);

        ArrayList<NewsItem> lista = new ArrayList();
        lista.add(new NewsItem("Handel: Water Music CD review – Cummings makes the music dance\"","Miercoles. 5 Julio","MUSIC","https://media.guim.co.uk/9994f41b6021d835eda38ed6cd4091c19b07c907/69_0_2400_1440/500.jpg"));
        lista.add(new NewsItem("Life won't find a way: how an ostrich fossil halted plans for a real-life Jurassic Park ","Miercoles. 5 Julio","SCIENCE","https://media.guim.co.uk/fe9919f695d3fc3f1659b09e4f8f008b0ca4c5d3/0_120_3500_2100/500.jpg"));
        lista.add(new NewsItem("Trump downplays 100 days milestone\"","Miercoles. 5 Julio","POLITICS","https://media.guim.co.uk/3abf4daf9d1ea414eee8eac1caa76903dfd70c24/0_177_3130_1878/500.jpg"));
        lista.add(new NewsItem("Hedgehogs at risk from food scarcity, habitat loss and badgers","Miercoles. 5 Julio","ENVIRONMENT","https://media.guim.co.uk/0fd87861d3d52b6df1065d0dc19875d6df237330/0_398_3264_1958/500.jpg"));
        lista.add(new NewsItem("Uber drivers deserve to be treated far better ","Miercoles. 5 Julio","TECHNOLOGY","https://media.guim.co.uk/9fecd0145daddd05480414f4159fffccf3fc0030/0_146_4368_2621/500.jpg"));


        fillList(lista);
    }

    private void fillList(ArrayList<NewsItem> lista) {
        NewsAdapter adapter = new NewsAdapter(this, lista);
       // listNews.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        GridLayoutManager manager = new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false);
        manager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                // 2 column size for first row
                return (position == 0 ? 2 : 2);
            }
        });
        listNews.setLayoutManager(manager);
        listNews.setAdapter(adapter);
        listNews.setHasFixedSize(true);

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
}
