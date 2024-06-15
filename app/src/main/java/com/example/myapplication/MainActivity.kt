package com.example.myapplication

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.adapter.CardShowAdapter
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.models.TestModelItem
import com.example.myapplication.viewmodel.testViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {


    private lateinit var _binding: ActivityMainBinding
    lateinit var mainViewModel: testViewModel
    private lateinit var feedAdapter: CardShowAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(_binding.root)

        mainViewModel = ViewModelProvider(this)[testViewModel::class.java]


        _binding.btn.setOnClickListener {
            mainViewModel.data()
        }
        bindObservers()
    }

    private fun bindObservers() {
        mainViewModel.categories.observe(this, Observer {
            feedAdapter = CardShowAdapter(it,::onNoteClick)
            _binding.recView.layoutManager = LinearLayoutManager(this)
            _binding.recView.adapter = feedAdapter

        })
    }

    private fun onNoteClick(item: TestModelItem) {
        Toast.makeText(this,"hi" , Toast.LENGTH_SHORT).show()
    }

}