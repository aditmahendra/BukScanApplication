package com.example.bukscan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class activity_addBook extends AppCompatActivity {
    private EditText bookNameEdit, bookAuthorsEdit, bookIsbnEdit, bookBestForEdit, bookPublisherEdit, bookInsightsEdit, bookPositiveReviewEdit, bookNegativeReviewEdit;
    private Button addBookBtn;
    private ImageView backButton;
    private DBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_book);

        backButton = (ImageView) findViewById(R.id.backBtn);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        bookNameEdit = findViewById(R.id.bookNameTxt);
        bookAuthorsEdit = findViewById(R.id.bookAuthorsTxt);
        bookIsbnEdit = findViewById(R.id.bookIsbnTxt);
        bookBestForEdit = findViewById(R.id.bookBestForTxt);
        bookPublisherEdit = findViewById(R.id.bookPublisherTxt);
        bookInsightsEdit = findViewById(R.id.bookInsights);
        bookPositiveReviewEdit = findViewById(R.id.bookPositiveReviewTxt);
        bookNegativeReviewEdit = findViewById(R.id.bookNegativeReviewTxt);

        dbHandler = new DBHandler(activity_addBook.this);

        addBookBtn = findViewById(R.id.addBtn);
        addBookBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String bookName = bookNameEdit.getText().toString();
                String bookAuthorsName = bookAuthorsEdit.getText().toString();
                String bookPublisher = bookPublisherEdit.getText().toString();
                String bookBestFor = bookBestForEdit.getText().toString();
                String bookInsights = bookInsightsEdit.getText().toString();
                String bookPositiveReview = bookPositiveReviewEdit.getText().toString();
                String bookNegativeReview = bookNegativeReviewEdit.getText().toString();

                Long bookIsbnCode = Long.parseLong(bookIsbnEdit.getText().toString());

                if(bookName.isEmpty() || bookAuthorsName.isEmpty()
                        || bookIsbnEdit.getText().toString().isEmpty()
                        || bookPublisher.isEmpty()
                        || bookBestFor.isEmpty()
                        || bookInsights.isEmpty()
                        || bookPositiveReview.isEmpty()
                        || bookNegativeReview.isEmpty()
                ){
                    Toast.makeText(activity_addBook.this, "Please complete the data", Toast.LENGTH_SHORT).show();
                    return;
                }


                dbHandler.addNewBook(bookName, bookAuthorsName, bookIsbnCode, bookPublisher, bookBestFor, bookInsights, bookPositiveReview, bookNegativeReview);
                Toast.makeText(activity_addBook.this, "New books has been added", Toast.LENGTH_SHORT).show();
                bookNameEdit.setText("");
                bookAuthorsEdit.setText("");
                bookIsbnEdit.setText("");
                bookPublisherEdit.setText("");
                bookBestForEdit.setText("");
                bookInsightsEdit.setText("");
                bookPositiveReviewEdit.setText("");
                bookNegativeReviewEdit.setText("");

            }
        });
    }
}