package com.cipolat.news.Views.Home;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.cipolat.news.R;
import com.cipolat.news.Views.CustomView.CustomTextView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import Model.NewsItem;

/**
 * Created by sebastian on 02/06/16.
 */
public class NewsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements View.OnClickListener {

    public Context mContext;
    private ArrayList<NewsItem> mListNews;

    public NewsAdapter(Context context, ArrayList<NewsItem> list) {
        this.mContext = context;
        this.mListNews = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.articles_item, parent, false);
        return new ViewHolderNews(v, mContext);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ViewHolderNews) {
            ViewHolderNews vhNews = (ViewHolderNews) holder;
            vhNews.bindPlaceObj(mListNews.get(position));
        }
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    public NewsItem getItemByPos(int pos) {
        return mListNews.get(pos - 1);
    }

    @Override
    public int getItemCount() {
        return mListNews.size();
    }

    @Override
    public void onClick(View view) {

    }

    //Para HEADER
    class ViewHolderNews extends RecyclerView.ViewHolder {
        ImageView imag;
        TextView   mCategory;
        CustomTextView mTitle,mDate;
        Context innerContext;

        public ViewHolderNews(View itemView, Context context) {
            super(itemView);
            this.innerContext = context;
            this.imag = (ImageView) itemView.findViewById(R.id.img_preview);
            this.mTitle = (CustomTextView) itemView.findViewById(R.id.itm_title);
            this.mDate = (CustomTextView) itemView.findViewById(R.id.itm_date);
            this.mCategory = (TextView) itemView.findViewById(R.id.categoryLabel);
        }

        public void bindPlaceObj(NewsItem item) {
            this.mTitle.setText(item.getTitle());
            this.mDate.setText(item.getDate());
            this.mCategory.setText(item.getCategory());
            Picasso.with(innerContext).setLoggingEnabled(true);
            Picasso.with(innerContext).load(item.getImageUrl()).into(imag);
        }
    }

}







