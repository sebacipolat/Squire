package com.cipolat.news.UI.Home;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cipolat.news.Data.Network.Model.Article;
import com.cipolat.news.Data.Network.Model.NewsResponse;
import com.cipolat.news.Data.Network.Model.SearchBody;
import com.cipolat.news.R;
import com.cipolat.news.UI.ArticleViewer.ArticleViewerActivity;
import com.cipolat.superstateview.SuperStateView;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

import android.support.v4.content.ContextCompat;

/**
 * Created by sebastian on 02/08/17.
 */

public class NewsListFragment extends Fragment implements HomeView {
    public static final String NEWS_TOPIC = "NEWS_TOPIC";
    @Bind(R.id.listNews)
    RecyclerView listNews;
    @Bind(R.id.stateView)
    SuperStateView stateView;
    private HomePresenter mHomePresenter;

    public NewsListFragment() {

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.news_list_fragment, container, false);
        ButterKnife.bind(this, rootView);
        startDummyLoad();
        //Seteo tipo de contenido
        SearchBody topic = getArguments().getParcelable("NEWS_TOPIC");

        mHomePresenter = new HomePresenter(getActivity());
        mHomePresenter.setView(this);
        mHomePresenter.getNewsByCriteria(topic);
        return rootView;
    }

    private void fillList(ArrayList<Article> lista) {
        final NewsAdapter adapter = new NewsAdapter(getActivity(), lista);
        listNews.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
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
                    Intent inten = new Intent(getActivity(), ArticleViewerActivity.class);
                    inten.putExtra(ArticleViewerActivity.ARTICLE_ITEM_ID, item.getApiUrl());
                    inten.putExtra(ArticleViewerActivity.ARTICLE_ITEM_TITLE, item.getWebTitle());
                    inten.putExtra(ArticleViewerActivity.ARTICLE_ITEM_COLOR_TYPE, item.getTypeColor());
                    inten.putExtra(ArticleViewerActivity.ARTICLE_SHARE_URL, item.getWebUrl());
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
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onNewsSearchResponse(NewsResponse response) {
        fillList(response.getResponse().getResults());
    }

    @Override
    public void onNewsSearchFail() {
        listNews.setVisibility(View.GONE);
        setErrorImageState();
    }

    @Override
    public void onNetworkError() {
        listNews.setVisibility(View.GONE);
        setNetworkErrorImageState();
    }

    private void setNetworkErrorImageState() {
        stateView.setVisibility(View.VISIBLE);
        stateView.setImageState( R.drawable.cloud_sad);
        stateView.setTitleText(getString(R.string.internet_connection_error_lbl));
        stateView.setSubTitleText(getString(R.string.internet_connection_error_sub_lbl));
        stateView.setTitleStyle(R.style.network_error_placeholder_title);
        stateView.setSubTitleStyle(R.style.placeholder_error_sub_title);
    }
    private void setErrorImageState() {
        stateView.setVisibility(View.VISIBLE);
        stateView.setImageState( R.drawable.error_guy);
        stateView.setTitleText(getString(R.string.response_error_lbl));
        stateView.setSubTitleText(getString(R.string.response_error_sub_lbl));
        stateView.setTitleStyle(R.style.response_error_placeholder_title);
        stateView.setSubTitleStyle(R.style.placeholder_error_sub_title);
    }
}
