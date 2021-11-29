package com.example.bukscan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class activity_bookRepository extends AppCompatActivity {
    private ArrayList<Books> booksArrayList;
    private DBHandler dbHandler;
    private bookAdapter bookAdapter;
    private RecyclerView recyclerViewBooks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_repository);

        booksArrayList = new ArrayList<>();
        dbHandler = new DBHandler(activity_bookRepository.this);

        booksArrayList = dbHandler.readBooks();
        bookAdapter = new bookAdapter(booksArrayList, activity_bookRepository.this);
        recyclerViewBooks = findViewById(R.id.idRecyclerBooks);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(activity_bookRepository.this, RecyclerView.VERTICAL, false);
        recyclerViewBooks.setLayoutManager(linearLayoutManager);

        recyclerViewBooks.setAdapter(bookAdapter);
    }
}