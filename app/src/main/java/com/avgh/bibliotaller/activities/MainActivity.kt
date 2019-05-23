package com.avgh.bibliotaller.activities

import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.avgh.bibliotaller.R
import com.avgh.bibliotaller.fragments.MainDetailsFragment
import com.avgh.bibliotaller.room.LibraryDatabase
import com.avgh.bibliotaller.room.entities.Content
import com.avgh.bibliotaller.fragments.MainListFragment
import com.avgh.bibliotaller.repository.BookRepository
import com.avgh.bibliotaller.room.entities.Book
import com.avgh.bibliotaller.utilities.AppConstants
import com.avgh.bibliotaller.utilities.BookHolder
import com.avgh.bibliotaller.utilities.Lagunajes
import com.avgh.bibliotaller.viewmodels.BookViewModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity(), MainListFragment.ListenerTools {

    private var bookList = ArrayList<Book>()
    private lateinit var bookViewModel : BookViewModel
    private lateinit var mainFragment: MainListFragment
    private lateinit var mainContentFragment: MainDetailsFragment

    lateinit var database: LibraryDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val observerTest = Observer<Book> {
            Log.i("testeando", "${it.ISBN}---${it.author[0].name}---${it.content.get(Lagunajes.English)}")
        }
        val repo = BookRepository(this@MainActivity)
        GlobalScope.launch{
            repo.db.bookDao().insertBook(BookHolder.bookHeld[0])
            repo.db.bookDao().insertBook(BookHolder.bookHeld[1])
            repo.db.bookDao().insertBook(BookHolder.bookHeld[2])
            repo.db.bookDao().insertBook(BookHolder.bookHeld[3])
            repo.db.bookDao().insertBook(BookHolder.bookHeld[4])

            repo.db.authorDao().insert(BookHolder.authorHeld[0])
            repo.db.authorDao().insert(BookHolder.authorHeld[1])
            repo.db.authorDao().insert(BookHolder.authorHeld[2])
            repo.db.authorDao().insert(BookHolder.authorHeld[3])

            repo.db.bookJoinAuthorDao().insert(BookHolder.authorByBook[0])
            repo.db.bookJoinAuthorDao().insert(BookHolder.authorByBook[1])
            repo.db.bookJoinAuthorDao().insert(BookHolder.authorByBook[2])
            repo.db.bookJoinAuthorDao().insert(BookHolder.authorByBook[3])
            repo.db.bookJoinAuthorDao().insert(BookHolder.authorByBook[4])

            delay(2000)



        }


        val book1 = repo.getBookByIdandLanguaje("978-84-08-19740-9",Lagunajes.English)
        val book2 = repo.getBookByIdandLanguaje("978-84-670-5248-0",Lagunajes.English)
        book1.observe(this@MainActivity, observerTest)
        book2.observe(this@MainActivity, observerTest)
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

        else{
            mainContentFragment = MainDetailsFragment.newInstance(Book("N/A", R.drawable.ic_launcher_background.toString(), 1, false))

            changeFragment(R.id.land_main_content_fragment, mainContentFragment)

            R.id.land_list_fragment
        }

        changeFragment(resource, mainFragment)

        bookViewModel.allBooks.observe(this, Observer{books ->
            books?.let{
                updateBookList(it as ArrayList<Book>)
                Log.d("List","_____________________________________")
                for (repo in books){
                    //Log.d("List", "${repo.ISBN}--Autor: ${repo.author} --Content: ${repo.content} ")
                }
            }
        })

    }

    fun updateBookList(bookList:ArrayList<Book>){
        mainFragment.updateBookList(bookList)
    }


    private fun changeFragment(id: Int, frag: Fragment) {
        supportFragmentManager.beginTransaction().replace(id, frag).commit()
    }

}