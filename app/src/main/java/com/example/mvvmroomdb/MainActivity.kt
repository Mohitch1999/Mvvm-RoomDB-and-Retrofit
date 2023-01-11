package com.example.mvvmroomdb

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmroomdb.databinding.ActivityMainBinding
import com.example.mvvmroomdb.repository.QuoteRepository
import com.example.mvvmroomdb.roomdb.QuoteDatabase
import com.example.mvvmroomdb.roomdb.Quotes
import com.example.mvvmroomdb.viewModel.MainActvityViewModel
import com.example.mvvmroomdb.viewModelFactory.MainViewModelFactory

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var mainviewModel: MainActvityViewModel
    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        val dao = QuoteDatabase.getDatabase(applicationContext).quoteDao()
        val quoteRepository = QuoteRepository(dao)

        mainviewModel = ViewModelProvider(
            this,
            MainViewModelFactory(quoteRepository)
        ).get(MainActvityViewModel::class.java)

        mainviewModel.getQuoteData().observe(this) {
            binding.quotes = it.toString()
        }

        binding.btnaddquote.setOnClickListener {
        val quote = Quotes(0,"This is testing","mohit")
            mainviewModel.insertData(quote)
        }
    }
}