package com.aravindh.login

import androidx.core.util.PatternsCompat.EMAIL_ADDRESS

object LoginValidator {

    /*
    * 1. Username and Password should not be empty
    * 2. Username should be a valid email
    * 3. Password should be a valid password contains at least one special character, one digit, one uppercase and one lowercase
    * 4. Password should be at least 8 characters long
    * 5. Password should be at most 16 characters long
    * 6. Password should not contain username
    * 7. Password should not contain spaces
    * */

    fun validateLogin(username : String?, password : String?): LoginValidationStatus {

        // 1. Username and Password should not be empty
        if (username.isNullOrEmpty() || password.isNullOrEmpty()) {
            return LoginValidationStatus(false, "Username and Password should not be empty")
        }

        // 2. Username should be a valid email
        if (!EMAIL_ADDRESS.matcher(username).matches()) {
            return LoginValidationStatus(false, "Username should be a valid email")
        }

        // 3. Password should be a valid password contains at least one special character, one digit, one uppercase and one lowercase
        val passwordRegex = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,16}"
        if (!password.matches(passwordRegex.toRegex())) {
            return LoginValidationStatus(false, "Password should be a valid password contains at least one special character, one digit, one uppercase and one lowercase")
        }

        // 4. Password should be at least 8 characters long
        if (password.length < 8) {
            return LoginValidationStatus(false, "Password should be at least 8 characters long")
        }

        // 5. Password should be at most 16 characters long
        if (password.length > 16) {
            return LoginValidationStatus(false, "Password should be at most 16 characters long")
        }

        // 6. Password should not contain username
        if (password.contains(username)) {
            return LoginValidationStatus(false, "Password should not contain username")
        }

        // 7. Password should not contain spaces
        if (password.contains(" ")) {
            return LoginValidationStatus(false, "Password should not contain spaces")
        }


        return LoginValidationStatus(true, null)
    }
}