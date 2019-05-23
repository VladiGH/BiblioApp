package com.avgh.bibliotaller.utilities

import com.avgh.bibliotaller.room.entities.Book

object AppConstants{
    val dataset_saveinstance_key = "CLE"
    val MAIN_LIST_KEY = "key_list_coin"
    val BOOK_KEY = "BOOK"
}

interface MyAdapter {
    fun changeDataSet(newDataSet : ArrayList<Book>)
}