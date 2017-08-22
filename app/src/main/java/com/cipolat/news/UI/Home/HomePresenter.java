package com.cipolat.news.UI.Home;

import android.content.Context;

import com.cipolat.news.Data.DataManager;
import com.cipolat.news.Data.Network.Model.ArticleType;
import com.cipolat.news.Data.Network.Model.SearchBody;
import com.cipolat.news.UI.base.Presenter;
import com.cipolat.news.Data.Network.Model.NewsResponse;
import com.cipolat.news.Data.Network.GuardianApiInteractor;

import java.io.IOException;
import java.net.SocketTimeoutException;

import okhttp3.ResponseBody;
import retrofit2.HttpException;

/**
 * Created by sebastian on 23/07/17.
 */

public class HomePresenter implements Presenter<HomeView> {
    private Context mCtx;
    private HomeView mPView;
    private GuardianApiInteractor mInteractor;

    public HomePresenter(Context mCtx) {
        this.mCtx = mCtx;
        this.mInteractor = new GuardianApiInteractor();
    }

    @Override
    public void setView(HomeView view) {
        if (view == null) throw new IllegalArgumentException("You can't set a null view");
        this.mPView = view;
    }

    public void getNewsByCriteria(SearchBody search) {
        mInteractor.searchNewsByKeys(search.getSearchString(), new GuardianApiInteractor.NewsSearchCallback() {
            @Override
            public void onSuccess(NewsResponse cityListResponse) {
                DataManager.getInstance().appendArticles(cityListResponse.getResponse().getResults());
                mPView.onNewsSearchResponse(cityListResponse);
            }

            @Override
            public void onError(Throwable t) {
                if (t instanceof HttpException) {
                    mPView.onNewsSearchFail();
                } else if (t instanceof SocketTimeoutException) {
                    mPView.onNetworkError();
                } else if (t instanceof IOException) {
                    mPView.onNetworkError();
                } else {
                    mPView.onNewsSearchFail();
                }
            }
        });
    }

    @Override
    public void detachView() {
        mPView = null;
    }
}
