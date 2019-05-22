package com.avgh.bibliotaller.activities

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.avgh.bibliotaller.R
import com.avgh.bibliotaller.test.BookTest
import com.avgh.bibliotaller.utilities.MyAdapter
import kotlinx.android.synthetic.main.book_item_layout.view.*

class BookAdapter(var items: ArrayList<BookTest>, val clickListener: (BookTest)->Unit) : RecyclerView.Adapter<BookAdapter.ViewHolder>(),
    MyAdapter {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.book_item_layout,parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount() = items.size


    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(items[position], clickListener)

    override fun changeDataSet(newDataSet: ArrayList<BookTest>) {
        this.items = newDataSet
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        fun bind(item: BookTest, clickListener:  (BookTest) -> Unit) = with(itemView){
            bookImage.setImageResource(item.cover)

            itemView.setOnClickListener{(clickListener(item))}
        }
    }
}