package com.aravindh.users

import androidx.lifecycle.ViewModel
import com.aravindh.apiservice.ApiService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class UsersViewModel @Inject constructor(
    private val apiService: ApiService
) : ViewModel() {

    fun getUsers() {
        println("getUsers called ----->")

        CoroutineScope(Dispatchers.IO).launch {
            val data = apiService.getUsers()

            //println("data $data")
            println("data isSuccessful -----> ${data.isSuccessful}")
        }

    }
}