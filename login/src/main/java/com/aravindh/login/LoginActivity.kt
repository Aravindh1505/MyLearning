package com.aravindh.login

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    private val viewModel: LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        viewModel.loginResult.observe(this) {
            println("Login result: ${it.errorMessage}")
        }
    }

    override fun onResume() {
        super.onResume()
        viewModel.login("aravindh.samidurai@gmail.com", "Test")
    }
}