package com.example.bukscan;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DBHandler extends SQLiteOpenHelper {
    private static final String DB_NAME ="bukscandb";
    private static final int DB_VERSION = 1;
    private static final String TABLE_NAME = "book";
    private static final String ID_COL = "id";
    private static final String BOOK_NAME = "name";
    private static final String BOOK_AUTHORS = "authors";
    private static final String BOOK_ISBN = "isbn";


    public DBHandler(Context context){
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME + " ("
                + ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + BOOK_NAME + " TEXT,"
                + BOOK_AUTHORS + " TEXT,"
                + BOOK_ISBN + " INTEGER)";

        db.execSQL(query);
    }

    public void addNewBook(String bookName, String authors, long isbn){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(BOOK_NAME, bookName);
        values.put(BOOK_AUTHORS, authors);
        values.put(BOOK_ISBN, isbn);

        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    public ArrayList<Books> readBooks(){
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursorBooks = db.rawQuery("SELECT * FROM "+TABLE_NAME, null);

        ArrayList<Books> booksArrayList = new ArrayList<>();

        if(cursorBooks.moveToFirst()){
            do{
                booksArrayList.add(new Books(
                        cursorBooks.getString(1),
                        cursorBooks.getString(2),
                        cursorBooks.getLong(3)));
            } while (cursorBooks.moveToNext());
        }
        cursorBooks.close();
        return booksArrayList;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME);
        onCreate(db);
    }
}
