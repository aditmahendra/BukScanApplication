package com.example.bukscan;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class bookAdapter extends RecyclerView.Adapter<bookAdapter.ViewHolder> {

    private ArrayList<Books> booksArrayList;
    private Context context;

    public bookAdapter(ArrayList<Books> booksArrayList, Context context){
        this.booksArrayList = booksArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public bookAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.book_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull bookAdapter.ViewHolder holder, int position) {
        Books book = booksArrayList.get(position);
        holder.bookName.setText(book.getBookName());
        holder.bookAuthors.setText(book.getBookAuthors());
        holder.bookIsbn.setText(Long.toString(book.getBookISBN()));

    }

    @Override
    public int getItemCount() {
        return booksArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView bookName, bookAuthors, bookIsbn, bookPublisher, bookBestFor, bookInsights, bookPositiveReview, bookNegativeReview;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            bookName = itemView.findViewById(R.id.idBookName);
            bookAuthors = itemView.findViewById(R.id.idBookAuthors);
            bookIsbn = itemView.findViewById(R.id.idBookIsbnCode);
        }
    }
}

