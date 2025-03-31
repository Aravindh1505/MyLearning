package com.aravindh.users

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.aravindh.apiservice.ApiService
import com.aravindh.apiservice.model.UserResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class UsersViewModel @Inject constructor(
    private val apiService: ApiService
) : ViewModel() {

    private var _users = MutableLiveData<List<UserResponse.User?>?>()
    val users: LiveData<List<UserResponse.User?>?> get() = _users

    fun getUsers() {
        println("getUsers called ----->")

        CoroutineScope(Dispatchers.IO).launch {
            val data = apiService.getUsers()

            //println("data $data")
            println("data isSuccessful -----> ${data.isSuccessful}")

            if (data.isSuccessful) {
                _users.postValue(data.body()?.users)
            }

            println(users.value?.size)
        }

    }
}