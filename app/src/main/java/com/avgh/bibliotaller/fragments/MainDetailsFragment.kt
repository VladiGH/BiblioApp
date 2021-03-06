package com.avgh.bibliotaller.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.avgh.bibliotaller.R
import com.avgh.bibliotaller.room.entities.Book
import com.avgh.bibliotaller.utilities.Languages
import kotlinx.android.synthetic.main.fragment_book_detail.view.*

class MainDetailsFragment : Fragment() {
    var book = Book(R.string.n_a_value.toString(), R.drawable.ic_launcher_background.toString(), 1, false)

    companion object {

        fun newInstance (dataset : Book) : MainDetailsFragment{
            return MainDetailsFragment().apply {
                arguments = Bundle().apply {
                    putParcelable("book", dataset)

                }
            }
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            book = it.getParcelable("book")
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        val view = inflater.inflate(R.layout.fragment_book_detail, container, false)

        bindData(view)

        return view
    }

    fun bindData(view: View) {
        if(view != null) {
            view.land_book_image.setImageResource(book.cover.toInt())
            Log.d("MainActivity", book.content.toString())
            view.bookTitle.text = book.content.valueAt(Languages.ENGLISH).title
            view.bookISBN.text = book.ISBN
            view.bookEdition.text = book.edition.toString()
            view.bookAuthor.text = book.author[0].name?:"N/A"
            view.bookEditorial.text = book.editorial[0].name?:"N/A"
            view.bookTags.text = book.tag[0].name?:"N/A"
            view.bookSummary.text = book.content.valueAt(Languages.ENGLISH).resume
        }
    }
}