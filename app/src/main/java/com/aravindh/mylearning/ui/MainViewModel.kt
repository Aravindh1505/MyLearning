package com.aravindh.mylearning.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor() : ViewModel() {

    private val _count = MutableLiveData(0)
    val count : LiveData<Int> = _count

    fun startCountDown() {
        viewModelScope.launch {
            for (i in 10 downTo 1) {
                delay(1000)
                _count.value = i
            }
        }
    }
}