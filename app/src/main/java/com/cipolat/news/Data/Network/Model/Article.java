package com.cipolat.news.Data.Network.Model;


import java.util.ArrayList;

/**
 * Created by sebastian on 23/07/17.
 */

public class Article {
    private String id, type, sectionId, webPublicationDate, webTitle, webUrl, apiUrl;
    private Data fields;
    private ArrayList<Author> tags;
    private int typeColor;

    private boolean isDummy = false;

    public Article(boolean isDummy) {
        this.isDummy = isDummy;
    }

    public Article(String webTitle) {
        this.webTitle = webTitle;
    }
    public ArrayList<Author> getTags() {
        return tags;
    }

    public void setTags(ArrayList<Author> tags) {
        this.tags = tags;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSectionId() {
        return sectionId;
    }

    public void setSectionId(String sectionId) {
        this.sectionId = sectionId;
    }

    public String getWebPublicationDate() {
        return webPublicationDate;
    }

    public void setWebPublicationDate(String webPublicationDate) {
        this.webPublicationDate = webPublicationDate;
    }

    public String getWebTitle() {
        return webTitle;
    }

    public void setWebTitle(String webTitle) {
        this.webTitle = webTitle;
    }

    public String getWebUrl() {
        return webUrl;
    }

    public void setWebUrl(String webUrl) {
        this.webUrl = webUrl;
    }

    public String getApiUrl() {
        return apiUrl;
    }

    public void setApiUrl(String apiUrl) {
        this.apiUrl = apiUrl;
    }

    public Data getFields() {
        return fields;
    }

    public void setFields(Data fields) {
        this.fields = fields;
    }

    public boolean isDummy() {
        return isDummy;
    }

    public void setDummy(boolean dummy) {
        isDummy = dummy;
    }

    public int getTypeColor() {
        return typeColor;
    }

    public void setTypeColor(int typeColor) {
        this.typeColor = typeColor;
    }

    public class Data {
        private String headline, trailText, main, body, firstPublicationDate, shortUrl, thumbnail, bodyText;

        public String getHeadline() {
            return headline;
        }

        public void setHeadline(String headline) {
            this.headline = headline;
        }

        public String getTrailText() {
            return trailText;
        }

        public void setTrailText(String trailText) {
            this.trailText = trailText;
        }

        public String getMain() {
            return main;
        }

        public void setMain(String main) {
            this.main = main;
        }

        public String getBody() {
            return body;
        }

        public void setBody(String body) {
            this.body = body;
        }

        public String getFirstPublicationDate() {
            return firstPublicationDate;
        }

        public void setFirstPublicationDate(String firstPublicationDate) {
            this.firstPublicationDate = firstPublicationDate;
        }

        public String getShortUrl() {
            return shortUrl;
        }

        public void setShortUrl(String shortUrl) {
            this.shortUrl = shortUrl;
        }

        public String getThumbnail() {
            return thumbnail;
        }

        public void setThumbnail(String thumbnail) {
            this.thumbnail = thumbnail;
        }

        public String getBodyText() {
            return bodyText;
        }

        public void setBodyText(String bodyText) {
            this.bodyText = bodyText;
        }
    }

}
