package com.example.mvvmroomdb.roomdb

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface QuoteDao
{
    @Query("select * from quotes")
    fun getQuoteData() : LiveData<List<Quotes>>

    @Insert
    suspend fun insertQuoteData(quotes: Quotes)
}
