package com.cipolat.news.Data.Network.Model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/**
 * Created by sebastian on 02/08/17.
 */

public class SearchBody implements Parcelable{
    private ArrayList<ArticleType> listaKeys;

    public SearchBody(ArrayList<ArticleType> listaKeys) {
        this.listaKeys = listaKeys;
    }
    public SearchBody(ArticleType type) {
        this.listaKeys = new ArrayList<>();
        this.listaKeys.add(type);
    }
    protected SearchBody(Parcel in) {
    }

    public static final Creator<SearchBody> CREATOR = new Creator<SearchBody>() {
        @Override
        public SearchBody createFromParcel(Parcel in) {
            return new SearchBody(in);
        }

        @Override
        public SearchBody[] newArray(int size) {
            return new SearchBody[size];
        }
    };

    public ArrayList<ArticleType> getListaKeys() {
        return listaKeys;
    }

    public void setListaKeys(ArrayList<ArticleType> listaKeys) {
        this.listaKeys = listaKeys;
    }
    public String getSearchString(){
        StringBuilder searchs=new StringBuilder();
        if(listaKeys.size()>1){
            for (ArticleType type:listaKeys) {
                searchs.append(type.getType().toLowerCase());
                searchs.append(",");
            }
        }else if(listaKeys.size()==1)
            searchs.append(listaKeys.get(0).getType().toLowerCase());
        return searchs.toString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
    }
}
