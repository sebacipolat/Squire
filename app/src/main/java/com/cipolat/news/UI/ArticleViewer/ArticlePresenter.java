package com.cipolat.news.UI.ArticleViewer;

import android.content.Context;
import android.util.Log;

import com.cipolat.news.Data.DataManager;
import com.cipolat.news.Data.Network.Model.Article;
import com.cipolat.news.UI.base.Presenter;
import com.cipolat.news.Data.Network.Model.ArticleResponse;
import com.cipolat.news.Data.Network.GuardianApiInteractor;

import java.util.ArrayList;
import java.util.Random;

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

    public ArrayList<Article> getSuggestedList() {
        int max = DataManager.getInstance().getmListArticles().size() - 1;
        Random rand = new Random();
        ArrayList<Article> list = new ArrayList<>();
        for (int i = 0; i < 3; i++)
            list.add(DataManager.getInstance().getmListArticles().get(rand.nextInt(max) + 1));
        return list;
    }

    @Override
    public void detachView() {
        mPView = null;

    }
}
