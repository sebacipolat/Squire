package com.cipolat.news.Data.Network.Model;

/**
 * Created by sebastian on 23/07/17.
 */

public class Author {

    private String id,type,webTitle,webUrl,apiUrl,bio,bylineImageUrl,bylineLargeImageUrl,firstName,lastName;

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

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getBylineImageUrl() {
        return bylineImageUrl;
    }

    public void setBylineImageUrl(String bylineImageUrl) {
        this.bylineImageUrl = bylineImageUrl;
    }

    public String getBylineLargeImageUrl() {
        return bylineLargeImageUrl;
    }

    public void setBylineLargeImageUrl(String bylineLargeImageUrl) {
        this.bylineLargeImageUrl = bylineLargeImageUrl;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
