package model;

import java.io.Serializable;

public class Post implements Serializable {

    private String title;
    private String text;
    private String category;
    private String dateTime;


    public Post (String title, String text, String category, String dateTime){

        this.title = title;
        this.text = text;
        this.category = category;
        this.dateTime = dateTime;
    }


    public Post(){

    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }

    public String getCategory() {
        return category;
    }


    @Override
    public String toString() {
        return "model.Post{" +
                "title='" + title + '\'' +
                ", text='" + text + '\'' +
                ", category='" + category + '\'' +
                ", createdDate=" + dateTime +
                '}';
    }
}
