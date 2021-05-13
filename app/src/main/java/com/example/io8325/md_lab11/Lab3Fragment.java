package com.example.io8325.md_lab11;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.md_lab11.R;
import com.example.io8325.md_lab11.BooksAdapter;
import com.example.io8325.md_lab11.MyFileReader;

public class Lab3Fragment extends Fragment {

    private ListView booksList;

    public Lab3Fragment() {}

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.lab3_fragment, container, false);
    }

    @Override
    public void onResume() {
        super.onResume();

        MyFileReader fr = new MyFileReader(getContext());
        fr.init();
        fr.read();

        booksList = getActivity().findViewById(R.id.booksList_id);

        BooksAdapter booksAdapter = new BooksAdapter(getContext(), R.layout.list_item, fr.getSearch().toBooksDtoArray());
        booksList.setAdapter(booksAdapter);

    }
}
