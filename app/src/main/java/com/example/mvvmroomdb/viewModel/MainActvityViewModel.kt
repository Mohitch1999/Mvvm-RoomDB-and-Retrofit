package com.example.mvvmroomdb.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvmroomdb.repository.QuoteRepository
import com.example.mvvmroomdb.roomdb.Quotes
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActvityViewModel(private val quoteRepository: QuoteRepository) : ViewModel() {

    fun getQuoteData() : LiveData<List<Quotes>>{
        return quoteRepository.getQuoteData()
    }

    fun insertData(quotes: Quotes){
        viewModelScope.launch(Dispatchers.IO){
             quoteRepository.insertQuote(quotes)
        }
    }
}