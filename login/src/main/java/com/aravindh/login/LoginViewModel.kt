package com.aravindh.login


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {

    private var _loginResult = MutableLiveData<LoginValidationStatus>()
    val loginResult: MutableLiveData<LoginValidationStatus> = _loginResult

    fun login(username : String?, password : String?)  {
        val loginValidationStatus = LoginValidator.validateLogin(username, password)

        if (loginValidationStatus.isValid == false) {
            _loginResult.value = loginValidationStatus
        } else {
            handleLogin()
        }
    }

    fun handleLogin() {
        // Handle login logic here

    }

}