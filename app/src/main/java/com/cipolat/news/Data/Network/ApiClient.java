package com.cipolat.news.Data.Network;

/**
 * Created by sebastian on 22/07/17.
 */

import com.cipolat.news.BuildConfig;
import com.cipolat.news.Data.Constants;
import com.facebook.stetho.okhttp3.StethoInterceptor;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    private static Retrofit retrofitXML = null;
    private static Retrofit retrofitJSON = null;

    private static OkHttpClient client;

    public static OkHttpClient getOKClient() {
        OkHttpClient client;
        OkHttpClient.Builder clientbuilder = new OkHttpClient.Builder();
        clientbuilder.followRedirects(true);

        if (BuildConfig.DEBUG) {
            /// /debug stethto only debug
            clientbuilder.addNetworkInterceptor(new StethoInterceptor());
        }
        client = clientbuilder.build();
        return client;
    }

    public static Retrofit getClient() {
        if (retrofitJSON == null) {
            retrofitJSON = new Retrofit.Builder()
                    .baseUrl(Constants.API_URL)
                    .client(getOKClient())
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();
        }
        return retrofitJSON;
    }

    public static Retrofit getClient(String url) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .client(getOKClient())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        return retrofit;
    }

}