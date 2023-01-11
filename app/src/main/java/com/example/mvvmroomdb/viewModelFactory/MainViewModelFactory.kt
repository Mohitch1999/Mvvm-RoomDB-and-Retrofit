package com.example.mvvmroomdb.viewModelFactory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmroomdb.repository.QuoteRepository
import com.example.mvvmroomdb.viewModel.MainActvityViewModel

class MainViewModelFactory(private val quoteRepository: QuoteRepository) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainActvityViewModel(quoteRepository) as T
    }
}