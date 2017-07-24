package com.cipolat.news.UI.ArticleViewer;

import com.cipolat.news.Model.TheGuardianApiModel.ArticleResponse;

/**
 * Created by sebastian on 23/07/17.
 */

public interface ArticleView {
    void onArticleResponse(ArticleResponse response);

    void onResponseFail();
}
