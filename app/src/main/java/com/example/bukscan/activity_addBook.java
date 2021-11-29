package com.example.bukscan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class activity_addBook extends AppCompatActivity {
    private EditText bookNameEdit, bookAuthorsEdit, bookIsbnEdit;
    private Button addBookBtn;
    private DBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_book);

        bookNameEdit = findViewById(R.id.bookNameTxt);
        bookAuthorsEdit = findViewById(R.id.bookAuthorsTxt);
        bookIsbnEdit = findViewById(R.id.bookIsbnTxt);

        dbHandler = new DBHandler(activity_addBook.this);
        addBookBtn = findViewById(R.id.addBtn);
        addBookBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String bookName = bookNameEdit.getText().toString();
                String bookAuthorsName = bookAuthorsEdit.getText().toString();
                Long bookIsbnCode = Long.parseLong(bookIsbnEdit.getText().toString());

                if(bookName.isEmpty() && bookAuthorsName.isEmpty() && bookIsbnEdit.getText().toString().isEmpty()){
                    Toast.makeText(activity_addBook.this, "Please complete the data", Toast.LENGTH_SHORT).show();
                    return;
                }

                dbHandler.addNewBook(bookName, bookAuthorsName, bookIsbnCode);
                Toast.makeText(activity_addBook.this, "New books has been added", Toast.LENGTH_SHORT).show();
                bookNameEdit.setText("");
                bookAuthorsEdit.setText("");
                bookIsbnEdit.setText("");

            }
        });
    }
}