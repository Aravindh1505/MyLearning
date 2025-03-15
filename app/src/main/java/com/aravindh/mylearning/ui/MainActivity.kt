package com.aravindh.mylearning.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.aravindh.mylearning.R
import com.aravindh.mylearning.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        viewModel.count.observeForever {
            println("Count is $it")
            binding.textView.text = "Count is $it"
        }
    }

    override fun onResume() {
        super.onResume()
        viewModel.startCountDown()
    }
}