package com.example.io8325.md_lab11;

import com.example.md_lab11.R;
import com.google.gson.annotations.SerializedName;

import java.lang.reflect.Field;


public class Books {
    @SerializedName("Title")
    private  String title;
    @SerializedName("Price")
    private String price;
    @SerializedName("isbn13")
    private String isbn13;
    @SerializedName("subtitle")
    private String subtitle;
    @SerializedName("Image")
    private String image;

    public Books() {}

    public Books(String title, String price, String isbn13, String subtitle, String image) {
        this.title = title;
        this.price = price;
        this.isbn13 = isbn13;
        this.subtitle = subtitle;
        this.image = image;
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

    public String getisbn13() {
        return isbn13;
    }

    public void setisbn13(String isbn13) {
        this.isbn13 = isbn13;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Books{" +
                "title='" + title + '\'' +
                ", price='" + price + '\'' +
                ", isbn13='" + isbn13 + '\'' +
                ", subtitle='" + subtitle + '\'' +
                ", image='" + image + '\'' +
                '}';
    }

    public int getImageId(){
        try {
            String str = image.split("\\.")[0].toLowerCase();
            System.out.println(str);
            Field field = R.drawable.class.getDeclaredField(str);
            return field.getInt(field);
        } catch (NoSuchFieldException e) {
            return R.drawable.third_icon;
        } catch (IllegalAccessException e) {
            return R.drawable.third_icon;
        }
    }
}