package com.cipolat.news.Network;

import com.cipolat.news.Data.Constants;
import com.cipolat.news.Logger.L;
import com.cipolat.news.Model.TheGuardianApiModel.ArticleResponse;
import com.cipolat.news.Model.TheGuardianApiModel.NewsResponse;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by sebastian on 23/07/17.
 */

public class GuardianApiInteractor {
    private GuardianApi apiService;

    public GuardianApiInteractor() {
        apiService = ApiClient.getClient().create(GuardianApi.class);
    }

    public void searchNews(final NewsSearchCallback callback) {
        String search = "movies,lifestyle,polictics,world";
        apiService.searchNews(search, "json", "2017", "thumbnail", "relevance", Constants.API_KEY)
                .subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DisposableObserver<NewsResponse>() {
                    @Override
                    public void onNext(@NonNull NewsResponse newsResponse) {
                        L.e("OKOKKK", ":)");
                        if (newsResponse != null)
                            callback.onSuccess(newsResponse);
                    }

                    @Override
                    public void onError(@NonNull Throwable throwable) {
                        L.e("errr", "err");
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    public void getArticleByID(String articleID, final ArticleCallback callbk) {
        String urlArticle=articleID+"?show-tags=contributor&show-fields=all&api-key="+Constants.API_KEY;
        apiService.getarticle(urlArticle)
                .subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DisposableObserver<ArticleResponse>() {
                    @Override
                    public void onNext(@NonNull ArticleResponse respnse) {
                        if(respnse!=null)
                            callbk.onSuccess(respnse);
                    }

                    @Override
                    public void onError(@NonNull Throwable throwable) {
                        L.e("errr", "err");
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    public interface ArticleCallback {
        void onSuccess(ArticleResponse response);
        void onError();
    }
    public interface NewsSearchCallback {
        void onSuccess(NewsResponse response);
        void onError();
    }
}
