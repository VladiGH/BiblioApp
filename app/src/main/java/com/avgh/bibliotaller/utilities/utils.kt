package com.avgh.bibliotaller.utilities

import com.avgh.bibliotaller.room.entities.Book

object AppConstants{
    const val dataset_saveinstance_key = "CLE"
    const val MAIN_LIST_KEY = "key_list_coin"
    const val BOOK_KEY = "BOOK"
    const val AUTHOR_KEY = "AUTHOR"
    const val TAG_KEY = "TAG"
    const val EDITORIAL_KEY = "EDITORIAL"
    const val CONTENT_KEY = "CONTENT"
}

interface MyAdapter {
    fun changeDataSet(newDataSet : ArrayList<Book>)
}