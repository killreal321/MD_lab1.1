package com.example.io8325.md_lab11;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.io8325.md_lab11.BooksDto;
import com.example.md_lab11.R;

import java.util.List;


public class BooksAdapter extends ArrayAdapter<BooksDto> {
    private final LayoutInflater inflater;
    private final int layout;
    private final List<BooksDto> books;

    public BooksAdapter(Context context, int resource, List<BooksDto> books){
        super(context, resource, books);
        this.books = books;
        this.layout = resource;
        this.inflater = LayoutInflater.from(context);
    }

    public View getView(int position, View convertView, ViewGroup parent){
        @SuppressLint("ViewHolder")
        View view = inflater.inflate(this.layout, parent, false);
        ImageView imageView = view.findViewById(R.id.image_id);
        TextView titleView = view.findViewById(R.id.title_id);
        TextView priceView = view.findViewById(R.id.price_id);
        TextView isbn13View = view.findViewById(R.id.isbn13_id);
        TextView subtitleView = view.findViewById(R.id.subtitle_id);

        BooksDto book = books.get(position);
        imageView.setImageResource(book.getImage());
        titleView.setText(book.getTitle());
        priceView.setText(book.getPrice());
        isbn13View.setText(book.getIsbn13());
        subtitleView.setText(book.getSubtitle());

        if(parent.getResources().getConfiguration().orientation ==
                Configuration.ORIENTATION_LANDSCAPE){
            imageView.getLayoutParams().width = dpToPx(150, parent.getContext());
        }else{
            imageView.getLayoutParams().width = dpToPx(120, parent.getContext());
        }
        return view;
    }

    private int dpToPx(int dp, Context context) {
        float density = context.getResources().getDisplayMetrics().density;
        return Math.round((float) dp * density);
    }
}
