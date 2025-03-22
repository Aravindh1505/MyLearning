package com.aravindh.mylearning.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.aravindh.mylearning.R
import com.aravindh.mylearning.databinding.ActivityMainBinding
import com.aravindh.register.RegisterActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    //private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        //startActivity(Intent(this, LoginActivity::class.java))
        startActivity(Intent(this, RegisterActivity::class.java))
    }

    override fun onResume() {
        super.onResume()
        //viewModel.startCountDown()
    }
}