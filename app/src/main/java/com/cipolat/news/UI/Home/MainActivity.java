package com.cipolat.news.UI.Home;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.view.Menu;

import com.cipolat.news.Data.Network.Model.ArticleType;
import com.cipolat.news.Data.Network.Model.SearchBody;
import com.cipolat.news.R;
import com.cipolat.news.UI.CustomView.CustomTextView;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.mainTitle)
    CustomTextView mainTitle;
    @Bind(R.id.tabs)
    TabLayout mTabLayout;
    @Bind(R.id.viewpager)
    ViewPager mViewPager;
    private String TAG = MainActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        getWindow().setBackgroundDrawable(null);
        //Seteo estilo al titulo
        Spannable textTitle = new SpannableString(getString(R.string.app_name));
        textTitle.setSpan(new ForegroundColorSpan(ContextCompat.getColor(this, R.color.political_red)), 0, 1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        mainTitle.setText(textTitle);

        mTabLayout.setupWithViewPager(mViewPager);

        //Cargo ViewPager
        setupViewPager(mViewPager);
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());

        //Defino sobre que asunto sera cada fragment
        NewsListFragment newsList1 = new NewsListFragment();
        Bundle bundHome = new Bundle();
        ArrayList<ArticleType> homeKeys = new ArrayList<>();
        homeKeys.add(new ArticleType(ArticleType.MUSIC));
        homeKeys.add(new ArticleType(ArticleType.MOVIES));
        homeKeys.add(new ArticleType(ArticleType.FILM));
        homeKeys.add(new ArticleType(ArticleType.FASHION));
        homeKeys.add(new ArticleType(ArticleType.WORLD));
        bundHome.putParcelable(NewsListFragment.NEWS_TOPIC, new SearchBody(homeKeys));
        newsList1.setArguments(bundHome);

        NewsListFragment newsList2 = new NewsListFragment();
        Bundle bundPolyt = new Bundle();
        bundPolyt.putParcelable(NewsListFragment.NEWS_TOPIC, new SearchBody(new ArticleType(ArticleType.POLITICS)));
        newsList2.setArguments(bundPolyt);

        NewsListFragment newsList3 = new NewsListFragment();
        Bundle bundSport = new Bundle();
        ArrayList<ArticleType> sportsKeys = new ArrayList<>();
        homeKeys.add(new ArticleType(ArticleType.SPORTS));
        homeKeys.add(new ArticleType(ArticleType.FOOTBALL));

        bundSport.putParcelable(NewsListFragment.NEWS_TOPIC, new SearchBody(sportsKeys));
        newsList3.setArguments(bundSport);

        NewsListFragment newsList4 = new NewsListFragment();
        Bundle bundFashn = new Bundle();
        bundFashn.putParcelable(NewsListFragment.NEWS_TOPIC, new SearchBody(new ArticleType(ArticleType.TECHNOLOGY)));
        newsList4.setArguments(bundFashn);

        adapter.addFrag(newsList1, getString(R.string.section_1));
        adapter.addFrag(newsList2, getString(R.string.section_2));
        adapter.addFrag(newsList3, getString(R.string.section_3));
        adapter.addFrag(newsList4, getString(R.string.section_4));

        viewPager.setAdapter(adapter);
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
