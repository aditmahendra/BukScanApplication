package com.example.bukscan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class homepage extends AppCompatActivity {
    private CardView cardScanCover, cardScanBarcode, cardAddNewBook, cardViewBook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        cardScanCover = (CardView) findViewById(R.id.cardview_scanCover);
//        cardScanCover.setBackgroundResource(R.drawable.icon_addbook);
        cardScanCover.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openScanCoverPage();
            }
        });
        cardScanBarcode = (CardView) findViewById(R.id.cardview_scanBarcode);
//        cardScanBarcode.setBackgroundResource(R.drawable.icon_scanisbn);

        cardAddNewBook = (CardView) findViewById(R.id.cardview_addNewBook);
//        cardAddNewBook.setBackgroundResource(R.drawable.icon_addbook);
        cardAddNewBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAddBookPage();
            }
        });

        cardViewBook = (CardView) findViewById(R.id.cardview_bookRepository);
//        cardViewBook.setBackgroundResource(R.drawable.icon_repository1);
        cardViewBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openBookRepositoryPage();
            }
        });
    }
    public void openScanCoverPage(){
        Intent intent = new Intent(this, activity_scanBookCover.class);
        startActivity(intent);
    }
    public void openAddBookPage(){
        Intent intent = new Intent(this, activity_addBook.class);
        startActivity(intent);
    }
    public void openBookRepositoryPage(){
        Intent intent = new Intent(this, activity_bookRepository.class);
        startActivity(intent);
    }
}