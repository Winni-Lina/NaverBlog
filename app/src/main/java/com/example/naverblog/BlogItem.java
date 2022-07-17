package com.example.naverblog;

public class BlogItem {
    private String bloger;
    private String title;
    private String date;

    public BlogItem(String bloger, String title, String date){
        this.bloger = bloger;
        this.title = title;
        this.date = date;
    };

    public String getBloger() {
        return bloger;
    }

    public void setBloger(String bloger) {
        this.bloger = bloger;
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
}
