package com.example.io8325.md_lab11.ui;

public class BooksDto {
    private  String title;
    private String price;
    private String imdbID;
    private String type;
    private int image;

    public BooksDto(String title, String price, String imdbID, String type, int image) {
        this.title = title;
        this.price = price;
        this.imdbID = imdbID;
        this.type = type;
        this.image = image;
    }

    public BooksDto() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getImdbID() {
        return imdbID;
    }

    public void setImdbID(String imdbID) {
        this.imdbID = imdbID;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
