package com.android.kotlinapp1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.android.kotlinapp1.model.DataViewModel
import kotlinx.android.synthetic.main.activity_main.*;

class MainActivity : AppCompatActivity() {

    lateinit var viewModel : DataViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProvider(this).get(DataViewModel::class.java)
        viewModel.currentIndex.observe(this, Observer {
            counterValue.text = it.toString()
        })

        viewModel.currentStatus.observe(this, Observer {
            statusView.text = it.toString()
        })

        incCounterValue()
    }

    private fun incCounterValue(){
        btnAdd.setOnClickListener{
            viewModel.currentIndex.value = ++viewModel.index;
            viewModel.currentStatus.value = viewModel.index % 2 == 0
        }
    }
}