package com.cipolat.news.Network;


import com.cipolat.news.Model.TheGuardianApiModel.ArticleResponse;
import com.cipolat.news.Model.TheGuardianApiModel.NewsResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.Url;

/**
 * Created by sebastian on 16/06/16.
 */
public interface GuardianApi {
    //SearchNews
    @GET("search")
    Observable<NewsResponse> searchNews(@Query("q") String seachString,
                                        @Query("format") String formatRespns,
                                        @Query("from-date") String date,
                                        @Query("show-fields") String fields,
                                        @Query("order-by") String orderCriteria,
                                        @Query("api-key") String apiKey);

    //Get Specific Article
    @GET
    Observable<ArticleResponse> getarticle(@Url String url);
}