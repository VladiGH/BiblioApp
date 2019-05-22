package com.avgh.bibliotaller.utilities

import com.avgh.bibliotaller.test.BookTest

object AppConstants{
    val dataset_saveinstance_key = "CLE"
    val MAIN_LIST_KEY = "key_list_coin"
}

interface MyAdapter {
    fun changeDataSet(newDataSet : ArrayList<BookTest>)
}