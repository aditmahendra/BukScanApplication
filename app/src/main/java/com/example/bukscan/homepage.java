package com.example.bukscan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class homepage extends AppCompatActivity {
    private CardView cardScanCover;
    private CardView cardScanBarcode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        cardScanCover = (CardView) findViewById(R.id.cardview_scanCover);
        cardScanCover.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openScanCover();
            }
        });
    }
    public void openScanCover(){
        Intent intent = new Intent(this, activity_scanBookCover.class);
        startActivity(intent);
    }
}