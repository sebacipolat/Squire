package com.cipolat.news.Model;

import android.view.View;

import com.cipolat.news.Model.TheGuardianApiModel.Article;

/**
 * Created by sebastian on 22/07/17.
 */

public interface RecyclerViewClickListener {
    void onClick(View view, int position);
    void onNewsClick(Article item);
}