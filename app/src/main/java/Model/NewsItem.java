package Model;

/**
 * Created by sebastian on 13/07/17.
 */

public class NewsItem {

    private String title;
    private String date;
    private String category;
    private String imageUrl;


    public NewsItem(String title, String date, String category, String imageUrl) {
        this.title = title;
        this.date = date;
        this.category = category;
        this.imageUrl = imageUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

}
