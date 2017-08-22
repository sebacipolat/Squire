package com.cipolat.news.UI.ArticleViewer;

import com.cipolat.news.Data.Network.Model.ArticleResponse;

/**
 * Created by sebastian on 23/07/17.
 */

public interface ArticleView {
    void onArticleResponse(ArticleResponse response);
    void onSearchFail();
    void onNetworkError();
    void onNetworkTimeOut();
    void onUnkownError(String error);
}
