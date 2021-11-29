package com.example.bukscan;

public class Books {
    private String bookName;
    private String bookAuthors;
    private long bookISBN;
    private String publishedBy;
    private String bookBestFor;
    private String bookInsights;
    private String bookPositiveReview;
    private String bookNegativeReview;

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

    public String getPublishedBy(){
        return publishedBy;
    }

    public void setPublishedBy(String publishers){
        this.publishedBy = publishers;
    }

    public String getBookBestFor(){
        return bookBestFor;
    }

    public void setBookBestFor(String bestFor){
        this.bookBestFor = bestFor;
    }

    public String getBookInsights(){
        return bookInsights;
    }

    public void setBookInsights(String insights){
        this.bookInsights = insights;
    }

    public String getBookPositiveReview(){
        return bookPositiveReview;
    }

    public void setBookPositiveReview(String positiveReview){
        this.bookPositiveReview = positiveReview;
    }

    public String getBookNegativeReview(){
        return bookNegativeReview;
    }

    public void setBookNegativeReview(String negativeReview){
        this.bookNegativeReview = negativeReview;
    }

    public Books(
            String bookName,
            String bookAuthors,
            Long bookISBN,
            String publishedBy,
            String bookBestFor,
            String bookInsights,
            String bookPositiveReview,
            String bookNegativeReview){
        this.bookName = bookName;
        this.bookAuthors = bookAuthors;
        this.bookISBN = bookISBN;
        this.publishedBy = publishedBy;
        this.bookBestFor = bookBestFor;
        this.bookInsights = bookInsights;
        this.bookPositiveReview = bookPositiveReview;
        this.bookNegativeReview = bookNegativeReview;

    }
}
