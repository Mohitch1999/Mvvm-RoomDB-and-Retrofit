package com.example.mvvmroomdb.repository

import androidx.lifecycle.LiveData
import com.example.mvvmroomdb.roomdb.QuoteDao
import com.example.mvvmroomdb.roomdb.Quotes

class QuoteRepository(private val quoteDao: QuoteDao) {

    fun getQuoteData() : LiveData<List<Quotes>>{
        return quoteDao.getQuoteData()
    }

    suspend fun insertQuote(quotes: Quotes){
        return quoteDao.insertQuoteData(quotes)
    }
}