package com.cipolat.news.UI.ArticleViewer;

import android.content.Context;
import com.cipolat.news.Data.DataManager;
import com.cipolat.news.Data.Network.GuardianApiInteractor;
import com.cipolat.news.Data.Network.Model.Article;
import com.cipolat.news.Data.Network.Model.ArticleResponse;
import com.cipolat.news.UI.base.Presenter;
import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.Random;
import retrofit2.HttpException;

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
            public void onError(Throwable t) {
                if (t instanceof HttpException) {
                    mPView.onSearchFail();
                } else if (t instanceof SocketTimeoutException) {
                    mPView.onNetworkError();
                } else if (t instanceof IOException) {
                    mPView.onNetworkError();
                } else {
                    mPView.onSearchFail();
                }
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
