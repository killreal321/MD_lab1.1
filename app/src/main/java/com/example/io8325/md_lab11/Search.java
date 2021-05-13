package com.example.io8325.md_lab11;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;
import com.example.io8325.md_lab11.ui.BooksDto;

public class Search {
    @SerializedName("Search")
    private Books[] search;

    public Search() {}

    public Search(Books[] search) {
        this.search = search;
    }

    public Books[] getSearch() {
        return search;
    }

    public void setSearch(Books[] search) {
        this.search = search;
    }

    public List<BooksDto> toBooksDtoArray(){
        List<BooksDto> booksDtos = new ArrayList<>();
        for(Books books: search){
            String title = books.getTitle();
            String price = books.getPrice();
            String isbn13 = books.getIsbn13();
            String subtitle = books.getSubtitle();
            BooksDto booksDto = new BooksDto(
                    title.isEmpty()?"Unnamed :(":title,
                    price.isEmpty()?"":price,
                    isbn13.isEmpty() || isbn13.equals("noid")?"":isbn13,
                    subtitle.isEmpty()?"": subtitle,
                    books.getImageId()
            );
            booksDtos.add(booksDto);
        }
        return booksDtos;
    }
}