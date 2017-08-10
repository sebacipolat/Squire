package com.cipolat.news.Data.Network.Model;

import com.cipolat.news.R;

/**
 * Created by sebastian on 02/08/17.
 */

public class ArticleType {

    public static final String FILM = "FILM";
    public static final String MOVIES = "MOVIES";
    public static final String WORLD = "WORLD";
    public static final String SOCIETY = "SOCIETY";
    public static final String BOOKS = "BOOKS";
    public static final String BUSINESS = "BUSINESS";
    public static final String COMMUNITY = "COMMUNITY";
    public static final String CULTURE = "CULTURE";
    public static final String EDUCATION = "EDUCATION";
    public static final String ENVIRONMENT = "ENVIRONMENT";
    public static final String FASHION = "FASHION";
    public static final String NETFLIX = "NETFLIX";
    public static final String DISNEY = "DISNEY";
    public static final String TRUMP = "TRUMP";
    public static final String PUTTIN = "PUTTIN";

    public static final String FOOTBALL = "FOOTBALL";
    public static final String SOCCER = "SOCCER";
    public static final String NFL = "NFL";
    public static final String BASEBALL = "BASEBALL";
    public static final String F1 = "F1";

    public static final String MEDIA = "MEDIA";
    public static final String MUSIC = "MUSIC";
    public static final String POLITICS = "POLITICS";
    public static final String SCIENCE = "SCIENCE";
    public static final String TECHNOLOGY = "TECHNOLOGY";
    public static final String TRAVEL = "TRAVEL";
    public static final String WEATHER = "weather";
    public static final String LIFESTYLE = "LIFESTYLE";
    public static final String COMMENTISFREE = "COMMENTISFREE";
    public static final String COMMENTISFREE_REEPLACE = "Opinion";
    public static final String SPORTS = "SPORTS";

    private String type;

    public ArticleType(String type) {
        this.type = type;
    }

    public static int getColorByType(String type) {
        int color = 0;
        switch (type) {
            case MOVIES:
                color = R.color.film_green;
                break;
            case FILM:
                color = R.color.film_green;
                break;
            case WORLD:
                color = R.color.blue;
                break;
            case SOCIETY:
                color = R.color.society_red;
                break;
            case BOOKS:
                color = R.color.book_yellow;
                break;
            case COMMENTISFREE:
                color = R.color.comfree_brown;
                break;
            case EDUCATION:
                color = R.color.colorPrimaryDark;
                break;
            case ENVIRONMENT:
                color = R.color.environmtn_green;
                break;
            case FASHION:
                color = R.color.fashion_pink;
                break;
            case POLITICS:
                color = R.color.political_red;
                break;
            case SCIENCE:
                color = R.color.brown2;
                break;
            default:
                color = R.color.orange;
                break;
        }
        return color;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
