package com.avgh.bibliotaller.activities

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.avgh.bibliotaller.R
import com.avgh.bibliotaller.test.BookTest

class BookAdapter(val bookList: ArrayList<BookTest>) : RecyclerView.Adapter<BookAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.book_item_layout, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return bookList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val book: BookTest = bookList[position]

        holder.bookImage.setImageResource(book.cover)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val bookImage = itemView.findViewById<ImageView>(R.id.bookImage)
    }
}