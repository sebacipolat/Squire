package com.cipolat.news.UI.base;

import android.view.View;

import com.cipolat.news.Data.Network.Model.Article;

/**
 * Created by sebastian on 22/07/17.
 */

public interface RecyclerViewClickListener {
    void onClick(View view, int position);
    void onNewsClick(Article item);
}