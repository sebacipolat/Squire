package com.cipolat.news.Data;

import android.content.Context;

import com.cipolat.news.Data.Network.Model.Article;

import java.util.ArrayList;

/**
 * Created by sebastian on 11/06/16.
 */
public class DataManager {
    private static DataManager sInstance = null;

    private Context mContext;

    private ArrayList<Article> mListArticles;

    public static DataManager getInstance() {
        if (sInstance == null)
            sInstance = new DataManager();
        return sInstance;
    }

    public void init(Context ctx) {
        this.mContext = ctx;

        mListArticles = new ArrayList();
    }

    public static DataManager getsInstance() {
        return sInstance;
    }

    public static void setsInstance(DataManager sInstance) {
        DataManager.sInstance = sInstance;
    }

    public Context getmContext() {
        return mContext;
    }

    public void setmContext(Context mContext) {
        this.mContext = mContext;
    }

    public ArrayList<Article> getmListArticles() {
        return mListArticles;
    }

    public void setmListArticles(ArrayList<Article> mListArticles) {
        this.mListArticles = mListArticles;
    }

    public void appendArticles(ArrayList<Article> list){
        mListArticles.addAll(list);
    }

}
