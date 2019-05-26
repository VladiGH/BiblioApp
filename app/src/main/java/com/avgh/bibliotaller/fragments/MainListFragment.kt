package com.avgh.bibliotaller.fragments

import android.content.Context
import android.content.res.Configuration
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.avgh.bibliotaller.R
import com.avgh.bibliotaller.activities.BookAdapter
import com.avgh.bibliotaller.room.entities.Book
import com.avgh.bibliotaller.utilities.AppConstants
import com.avgh.bibliotaller.utilities.MyAdapter
import kotlinx.android.synthetic.main.fragment_book_list.view.*

class MainListFragment : Fragment() {

    private lateinit var  bookList :ArrayList<Book>
    private lateinit var BookAdapter : MyAdapter
    var listenerTools :  ListenerTools? = null

    companion object {
        @JvmStatic
        fun newInstance(param1: ArrayList<Book>) =
            MainListFragment().apply {
                arguments = Bundle().apply {
                    putParcelableArrayList("list", param1)

                }
            }
    }

    interface ListenerTools{
        fun managePortraitItemClick(item: Book)

        fun manageLandscapeItemClick(item: Book)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            bookList = it.getParcelableArrayList("list")
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        val view = inflater.inflate(R.layout.fragment_book_list, container, false)
        initRecyclerView(resources.configuration.orientation, view)
        return view
    }

    private fun initRecyclerView(orientation:Int, container: View){
        val linearLayoutManager = LinearLayoutManager(this.context)
        val gridLayoutManager = GridLayoutManager(this.context,2)

        if(orientation == Configuration.ORIENTATION_PORTRAIT){
            BookAdapter =
                BookAdapter(
                    bookList
                ) { item: Book -> listenerTools?.managePortraitItemClick(item) }

            container.recyclerView.adapter = BookAdapter as BookAdapter

            container.recyclerView.apply {
                setHasFixedSize(true)
                layoutManager = gridLayoutManager
            }
        }
        if(orientation == Configuration.ORIENTATION_LANDSCAPE){
            BookAdapter =
                BookAdapter(
                    bookList
                ) { item: Book -> listenerTools?.manageLandscapeItemClick(item) }

            container.recyclerView.adapter = BookAdapter as BookAdapter

            container.recyclerView.apply {
                setHasFixedSize(true)
                layoutManager = linearLayoutManager
            }
        }

    }

    fun updateBookList(bookList: ArrayList<Book>){ BookAdapter.changeDataSet(bookList) }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is ListenerTools) {
            listenerTools = context
        } else {
            throw RuntimeException("Se necesita una implementación de  la interfaz")
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putParcelableArrayList(AppConstants.MAIN_LIST_KEY, bookList)
        super.onSaveInstanceState(outState)
    }

    override fun onDetach() {
        super.onDetach()
        listenerTools = null
    }
}