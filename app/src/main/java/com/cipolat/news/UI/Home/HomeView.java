package com.cipolat.news.UI.Home;

import com.cipolat.news.Model.TheGuardianApiModel.NewsResponse;

/**
 * Created by sebastian on 23/07/17.
 */

public interface HomeView {

    void onNewsSearchResponse(NewsResponse response);
    void onNewsSearchFail();
}
