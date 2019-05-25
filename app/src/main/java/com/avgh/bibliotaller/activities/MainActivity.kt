package com.avgh.bibliotaller.activities

import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.avgh.bibliotaller.R
import com.avgh.bibliotaller.fragments.MainDetailsFragment
import com.avgh.bibliotaller.fragments.MainListFragment
import com.avgh.bibliotaller.room.LibraryDatabase
import com.avgh.bibliotaller.room.entities.Book
import com.avgh.bibliotaller.utilities.AppConstants
import com.avgh.bibliotaller.utilities.BookHolder
import com.avgh.bibliotaller.utilities.Languages
import com.avgh.bibliotaller.viewmodels.BookViewModel
import kotlinx.coroutines.*
import java.lang.Exception

class MainActivity : AppCompatActivity(), MainListFragment.ListenerTools {

    private var bookList = ArrayList<Book>()
    private lateinit var bookViewModel: BookViewModel
    private lateinit var mainFragment: MainListFragment
    private lateinit var mainContentFragment: MainDetailsFragment


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        GlobalScope.launch {
            insertion()
        }
        initMainFragment()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putParcelableArrayList(AppConstants.dataset_saveinstance_key, bookList)
        super.onSaveInstanceState(outState)
    }

    override fun managePortraitItemClick(item: Book) {
        val bookBundle = Bundle()

        bookBundle.putParcelable(AppConstants.BOOK_KEY, item)
        startActivity(Intent(this, BookViewer::class.java).putExtras(bookBundle))
    }

    override fun manageLandscapeItemClick(item: Book) {
        mainContentFragment = MainDetailsFragment.newInstance(item)
        changeFragment(R.id.land_main_content_fragment, mainContentFragment)
    }

    fun initMainFragment() {

        bookViewModel = ViewModelProviders.of(this).get(BookViewModel::class.java)

        mainFragment = MainListFragment.newInstance(bookList)


        val resource = if (resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT)
            R.id.main_fragment
        else {
            mainContentFragment =
                MainDetailsFragment.newInstance(Book("N/A", R.drawable.ic_launcher_background.toString(), 1, false))

            changeFragment(R.id.land_main_content_fragment, mainContentFragment)

            R.id.land_list_fragment
        }

        changeFragment(resource, mainFragment)

        bookViewModel.books?.observe(this, Observer { books ->
            books?.let {
                updateBookList(it as ArrayList<Book>)
                for (book in books) {
                    Log.d("MainActivity", "-----------------------------------------------")
                    Log.d("MainActivity", book.ISBN)
                    Log.d("MainActivity", book.edition.toString())
                    Log.d("MainActivity", "${book.author}")
                    Log.d("MainActivity", "${book.editorial}")
                    Log.d("MainActivity", "${book.tag}")
                    Log.d("MainActivity", book.content.valueAt(Languages.ENGLISH).title)
                    Log.d("MainActivity", book.content.valueAt(Languages.ENGLISH).resume)
                }
            }
        })

    }

    fun updateBookList(bookList: ArrayList<Book>) {
        mainFragment.updateBookList(bookList)
    }


    private fun changeFragment(id: Int, frag: Fragment) {
        supportFragmentManager.beginTransaction().replace(id, frag).commit()
    }

    private fun insertion() {
        val db = LibraryDatabase.getDatabase(this@MainActivity)
        BookHolder.bookHeld.forEach {
            db.bookDao().insertBook(it)
        }
        BookHolder.authorHeld.forEach {
            db.authorDao().insert(it)
        }
        BookHolder.authorByBook.forEach {
            db.bookJoinAuthorDao().insert(it)
        }
        BookHolder.contentHeld.forEach {
            db.contentDao().insert(it)
        }
        BookHolder.tagHeld.forEach {
            db.tagDao().insert(it)
        }
        BookHolder.bookByTag.forEach {
            db.bookJoinTag().insert(it)
        }
        BookHolder.editorialHeld.forEach {
            db.editorialDao().insert(it)
        }
        BookHolder.bookByEditorial.forEach {
            db.bookJoinEditorial().insert(it)
        }
    }

}