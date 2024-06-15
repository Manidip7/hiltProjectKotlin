package com.example.myapplication

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.adapter.CardShowAdapter
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.models.TestModelItem
import com.example.myapplication.viewmodel.testViewModel
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.qualifiers.ApplicationContext

@AndroidEntryPoint
class MainActivity : AppCompatActivity(),CardShowAdapter.CardClickListener {


    private lateinit var _binding : ActivityMainBinding
    lateinit var mainViewModel : testViewModel
    private lateinit var feedAdapter: CardShowAdapter


//    binding = ActivityMainBinding.inflate(layoutInflater)
//    setContentView(binding.root)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(_binding.root)

        mainViewModel = ViewModelProvider(this)[testViewModel::class.java]

        _binding.btn.setOnClickListener {
            mainViewModel.data()
        }

//        commentsAdapter = CommentsAdapter(requireContext(), commentList, this)
//        binding.commentRecyclerView.layoutManager = LinearLayoutManager(requireContext())
//        binding.commentRecyclerView.adapter = commentsAdapter


        mainViewModel.categories.observe(this, Observer {

//            _binding.riki.text = it.toString()

            feedAdapter = CardShowAdapter(this,it,this)
            _binding.recView.adapter = feedAdapter
            _binding.recView.layoutManager = LinearLayoutManager(this)

        })

    }

    override fun ButtonClicked(item: TestModelItem) {

        Toast.makeText(this, item.body, Toast.LENGTH_SHORT).show()
    }

}