package com.cipolat.news.Data.Network;

import com.cipolat.news.Data.Constants;
import com.cipolat.news.Logger.L;
import com.cipolat.news.Data.Network.Model.ArticleResponse;
import com.cipolat.news.Data.Network.Model.NewsResponse;

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

    public void searchNewsByKeys(String keys,final NewsSearchCallback callback) {
        apiService.searchNews(keys, "json", "2017", "thumbnail", "relevance", Constants.API_KEY)
                .subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DisposableObserver<NewsResponse>() {
                    @Override
                    public void onNext(@NonNull NewsResponse newsResponse) {
                        if (newsResponse != null)
                            callback.onSuccess(newsResponse);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        L.e("Error"," ");
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
