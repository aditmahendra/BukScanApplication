package com.example.bukscan;

public class Books {
    private String bookName;
    private String bookAuthors;
    private long bookISBN;
    public int id;

    public String getBookName(){
        return bookName;
    }

    public void setBookName(String name){
        this.bookName = name;
    }

    public String getBookAuthors(){
        return bookAuthors;
    }

    public void setBookAuthors(String authors){
        this.bookAuthors = authors;
    }

    public long getBookISBN(){
        return bookISBN;
    }

    public void setBookISBN(long isbn){
        this.bookISBN = isbn;
    }

    public int getId(){
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Books(String bookName, String bookAuthors, Long bookISBN){
        this.bookName = bookName;
        this.bookAuthors = bookAuthors;
        this.bookISBN = bookISBN;
    }
}
