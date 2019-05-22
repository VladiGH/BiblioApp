package com.avgh.bibliotaller.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.avgh.bibliotaller.R
import com.avgh.bibliotaller.test.BookTest

class MainDetailsFragment : Fragment() {
    var book = BookTest(R.drawable.ic_launcher_background)

    companion object {
        fun newInstance(item: BookTest): MainDetailsFragment {
            val newFragment = MainDetailsFragment()
            newFragment.book = item
            return newFragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        val view = inflater.inflate(R.layout.fragment_book_list, container, false)

        //bindData(view)

        return view
    }
/*
    fun bindData(view: View) {

        if(view != null) {
            view.bookImage.setImageResource(book.cover)
        }

    }*/
}