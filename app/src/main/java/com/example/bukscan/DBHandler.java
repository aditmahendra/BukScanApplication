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
    private static final String BOOK_PUBLSIHED_BY = "publishedBy";
    private static final String BOOK_BESTFOR = "bookBestFor";
    private static final String BOOK_INSIGHTS = "bookInsights";
    private static final String BOOK_POSITIVE_REVIEW = "bookPositiveRev";
    private static final String BOOK_NEGATIVE_REVIEW = "bookNegativeRev";


    public DBHandler(Context context){
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME + " ("
                + ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + BOOK_NAME + " TEXT,"
                + BOOK_AUTHORS + " TEXT,"
                + BOOK_ISBN + " INTEGER,"
                + BOOK_PUBLSIHED_BY + "TEXT,"
                + BOOK_BESTFOR + "TEXT,"
                + BOOK_INSIGHTS + "TEXT,"
                + BOOK_POSITIVE_REVIEW + "TEXT,"
                +BOOK_NEGATIVE_REVIEW + "TEXT)";
        db.execSQL(query);
    }

    public void addNewBook(String bookName, String authors, long isbn, String publisher, String bestFor, String insights, String positiveRev, String negativeRev){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(BOOK_NAME, bookName);
        values.put(BOOK_AUTHORS, authors);
        values.put(BOOK_ISBN, isbn);
        values.put(BOOK_PUBLSIHED_BY, publisher);
        values.put(BOOK_BESTFOR, bestFor);
        values.put(BOOK_INSIGHTS, insights);
        values.put(BOOK_POSITIVE_REVIEW, positiveRev);
        values.put(BOOK_NEGATIVE_REVIEW, negativeRev);

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
                        cursorBooks.getLong(3),
                        cursorBooks.getString(4),
                        cursorBooks.getString(5),
                        cursorBooks.getString(6),
                        cursorBooks.getString(7),
                        cursorBooks.getString(8)
                ));
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
