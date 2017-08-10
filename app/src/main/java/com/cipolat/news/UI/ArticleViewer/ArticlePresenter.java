package com.cipolat.news.UI.ArticleViewer;

import android.content.Context;

import com.cipolat.news.UI.base.Presenter;
import com.cipolat.news.Data.Network.Model.ArticleResponse;
import com.cipolat.news.Data.Network.GuardianApiInteractor;

/**
 * Created by sebastian on 23/07/17.
 */

public class ArticlePresenter implements Presenter<ArticleView> {
    private Context mCtx;
    private ArticleView mPView;
    private GuardianApiInteractor mInteractor;

    public ArticlePresenter(Context mCtx) {
        this.mCtx = mCtx;
        this.mInteractor = new GuardianApiInteractor();
    }

    @Override
    public void setView(ArticleView view) {
        if (view == null) throw new IllegalArgumentException("You can't set a null view");
        this.mPView = view;
    }

    public void getArticle(String articleID) {
        mInteractor.getArticleByID(articleID, new GuardianApiInteractor.ArticleCallback() {
            @Override
            public void onSuccess(ArticleResponse response) {
                mPView.onArticleResponse(response);
            }

            @Override
            public void onError(Throwable e) {

            }


        });
    }

    @Override
    public void detachView() {
        mPView = null;

    }
}
