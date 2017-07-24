package com.cipolat.news.UI.Home;

import android.content.Context;

import com.cipolat.news.Model.Presenter;
import com.cipolat.news.Model.TheGuardianApiModel.NewsResponse;
import com.cipolat.news.Network.GuardianApiInteractor;

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

    public void getNews() {
        mInteractor.searchNews(new GuardianApiInteractor.NewsSearchCallback() {
            @Override
            public void onSuccess(NewsResponse cityListResponse) {
                mPView.onNewsSearchResponse(cityListResponse);
            }

            @Override
            public void onError() {

            }
        });
    }

    @Override
    public void detachView() {
        mPView = null;

    }
}
