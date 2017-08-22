package com.cipolat.news.UI.ArticleViewer;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.cipolat.news.Data.Network.Model.Article;
import com.cipolat.news.R;
import com.cipolat.news.UI.CustomView.CustomTextView;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;
/**
 * Created by sebastian on 02/06/16.
 */
public class SuggestNewsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements View.OnClickListener {
    private Context mContext;
    private ArrayList<Article> mListNews;
    private View.OnClickListener mListener;

    public SuggestNewsAdapter(Context context, ArrayList<Article> list) {
        this.mContext = context;
        this.mListNews = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.articles_suggest_item, parent, false);
        v.setOnClickListener(this);
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

    public Article getItemByPos(int pos) {
        return mListNews.get(pos);
    }

    @Override
    public int getItemCount() {
        return mListNews.size();
    }


    public void setOnClickListener(View.OnClickListener listen) {
        this.mListener = listen;
    }

    @Override
    public void onClick(View view) {
        if (mListener != null)
            mListener.onClick(view);
    }

    //Para Articulos Comunes
    class ViewHolderNews extends RecyclerView.ViewHolder {
        ImageView imag;
        CustomTextView mTitle;
        Context innerContext;

        public ViewHolderNews(View itemView, Context context) {
            super(itemView);
            this.innerContext = context;
            this.imag = (ImageView) itemView.findViewById(R.id.img_preview);
            this.mTitle = (CustomTextView) itemView.findViewById(R.id.itm_title);
        }

        public void bindPlaceObj(Article item) {
            this.mTitle.setText(item.getWebTitle());
            //imagen
            if (item.getFields() != null && item.getFields().getThumbnail() != null) {
                Picasso.with(innerContext).setLoggingEnabled(true);
                Picasso.with(innerContext).load(item.getFields().getThumbnail()).into(imag);
            } else {
                //TODO
            }
        }
    }

}







