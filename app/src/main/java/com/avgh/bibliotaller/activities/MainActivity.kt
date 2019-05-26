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

class MainActivity : AppCompatActivity(), MainListFragment.ListenerTools {

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

    override fun managePortraitItemClick(item: Book) {
        val bookBundle = Bundle()

        bookBundle.putParcelable(AppConstants.BOOK_KEY, item)
        bookBundle.putParcelableArrayList(AppConstants.AUTHOR_KEY, item.author)
        bookBundle.putParcelableArrayList(AppConstants.EDITORIAL_KEY, item.editorial)
        bookBundle.putParcelableArrayList(AppConstants.TAG_KEY, item.tag)
        bookBundle.putSparseParcelableArray(AppConstants.CONTENT_KEY, item.content)
        startActivity(Intent(this, BookViewer::class.java).putExtras(bookBundle))
    }

    override fun manageLandscapeItemClick(item: Book) {
        mainContentFragment = MainDetailsFragment.newInstance(item)
        supportFragmentManager.beginTransaction().replace(R.id.land_main_content_fragment, mainContentFragment).commit()
    }

    fun initMainFragment() {

        bookViewModel = ViewModelProviders.of(this).get(BookViewModel::class.java)

        bookViewModel.books?.observe(this, Observer { books ->
            books?.let {
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
            val fresh = ArrayList<Book>()
            books.forEach {
                fresh.add(it)
            }
            mainFragment = MainListFragment.newInstance(fresh)
            if (resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {
                supportFragmentManager.beginTransaction().replace(R.id.main_fragment, mainFragment).commit()
            } else {
                supportFragmentManager.beginTransaction().replace(R.id.land_main_content_fragment, mainContentFragment)
                    .commit()
            }
        })
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