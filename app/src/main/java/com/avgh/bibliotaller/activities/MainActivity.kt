package com.avgh.bibliotaller.activities

import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.avgh.bibliotaller.R
import com.avgh.bibliotaller.fragments.MainDetailsFragment
import com.avgh.bibliotaller.room.LibraryDatabase
import com.avgh.bibliotaller.room.entities.Content
import com.avgh.bibliotaller.fragments.MainListFragment
import com.avgh.bibliotaller.test.BookTest
import com.avgh.bibliotaller.utilities.AppConstants

class MainActivity : AppCompatActivity(), MainListFragment.ListenerTools {

    private var bookList = ArrayList<BookTest>()

    private lateinit var mainFragment: MainListFragment
    private lateinit var mainContentFragment: MainDetailsFragment

    lateinit var database: LibraryDatabase
    private val observer = Observer<List<Content>>{
            data ->
        data.forEach {
            Log.i("test", it.title + it.resume +it.bookId)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        bookList.add(BookTest(R.drawable.murmullo))
        bookList.add(BookTest(R.drawable.creatividad))
        bookList.add(BookTest(R.drawable.nuestro_planeta))
        bookList.add(BookTest(R.drawable.portada_la))
        bookList.add(BookTest(R.drawable.julia))
        bookList.add(BookTest(R.drawable.creatividad))
        bookList.add(BookTest(R.drawable.murmullo))
        bookList.add(BookTest(R.drawable.portada_la))
        bookList.add(BookTest(R.drawable.nuestro_planeta))
        bookList.add(BookTest(R.drawable.julia))

        initMainFragment()
    }


    override fun onSaveInstanceState(outState: Bundle) {
        outState.putParcelableArrayList(AppConstants.dataset_saveinstance_key, bookList)
        super.onSaveInstanceState(outState)
    }

    override fun managePortraitItemClick(item: BookTest) {
        val bookBundle = Bundle()

        bookBundle.putParcelable("BOOK", item)
        startActivity(Intent(this, BookViewer::class.java).putExtras(bookBundle))
        Log.d("image","Enviado + $bookBundle")
    }

    override fun manageLandscapeItemClick(item: BookTest) {
        mainContentFragment = MainDetailsFragment.newInstance(item)
        changeFragment(R.id.land_main_content_fragment, mainContentFragment)
    }

    fun initMainFragment() {

        mainFragment = MainListFragment.newInstance(bookList)


        val resource = if (resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT)
            R.id.main_fragment

        else{
            mainContentFragment = MainDetailsFragment.newInstance(BookTest(
                R.drawable.ic_launcher_background))

            changeFragment(R.id.land_main_content_fragment, mainContentFragment)

            R.id.land_list_fragment
        }

        changeFragment(resource, mainFragment)

    }

    /*fun addCoinToList(coin: Coin){
        coinList.add(coin)
        mainFragment.updateCoinAdapter(coinList)
        Log.d("Number", coinList.size.toString())
    }*/


    private fun changeFragment(id: Int, frag: Fragment) {
        supportFragmentManager.beginTransaction().replace(id, frag).commit()
    }


/*
    fun updateCoins(){
        deleteCoins()
        coinList = ArrayList<Coin>()
        mainFragment.updateCoinAdapter(coinList)
        FetchCoinTask().execute("")
        Toast.makeText(this@MainActivity, "Actualizando base de datos", Toast.LENGTH_LONG).show()
    }

    fun showCoins(country: String){
        coinList = ArrayList<Coin>()

        var coins = filterCoins(country)

        coinList = coins as ArrayList<Coin>
        Log.d("Read", "Monedas de $country")
        Log.d("Read", coins.toString())
        Toast.makeText(this@MainActivity, "Filtro: $country", Toast.LENGTH_LONG).show()

        initMainFragment()
    }
    */
}