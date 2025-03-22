package com.aravindh.login

import com.google.common.truth.Truth.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4


@RunWith(JUnit4::class)
class LoginValidatorTest {

    @Test
    fun validateLogin_validateUsernameAndPassword_returnTrue() {
        val username = "aravindh@gmail.com"
        val password = "Test@123"

        val result = LoginValidator.validateLogin(username, password)
        assertThat(result.isValid).isEqualTo(true)
    }

    @Test
    fun validateLogin_whenUsernameIsEmpty_returnFalse() {
        val username = ""
        val password = "Test@123"

        val result = LoginValidator.validateLogin(username, password)
        assertThat(result.isValid).isEqualTo(false)
    }

    @Test
    fun validateLogin_whenPasswordIsEmpty_returnFalse() {
        val username = "aravindh@gmail.com"
        val password = ""

        val result = LoginValidator.validateLogin(username, password)
        assertThat(result.isValid).isEqualTo(false)
    }

    @Test
    fun validateLogin_whenUsernameAndPasswordIsEmpty_returnFalse() {
        val username = ""
        val password = ""

        val result = LoginValidator.validateLogin(username, password)
        assertThat(result.isValid).isEqualTo(false)
    }

    @Test
    fun validateLogin_whenUsernameIsInvalidEmailAddress_returnFalse() {
        val username = "aravindhgmail.com"
        val password = "Test@123"

        val result = LoginValidator.validateLogin(username, password)
        assertThat(result.isValid).isEqualTo(false)
    }

    @Test
    fun validateLogin_whenPasswordNotMeetTheeExpectations_returnFalse() {
        val username = "aravindhgmail.com"
        val password = "Test"

        val result = LoginValidator.validateLogin(username, password)
        assertThat(result.isValid).isEqualTo(false)
    }

    @Test
    fun validateLogin_whenPasswordLengthIsLessThanEight_returnFalse() {
        val username = "aravindhgmail.com"
        val password = "Test"

        val result = LoginValidator.validateLogin(username, password)
        assertThat(result.isValid).isEqualTo(false)
    }

    @Test
    fun validateLogin_whenPasswordLengthIsExceedingSixteen_returnFalse() {
        val username = "aravindhgmail.com"
        val password = "Testing@1234567890123456789"

        val result = LoginValidator.validateLogin(username, password)
        assertThat(result.isValid).isEqualTo(false)
    }

    @Test
    fun validateLogin_whenUsernameAndPasswordShouldNotSame_returnFalse() {
        val username = "aravindhgmail.com"
        val password = "aravindhgmail.com"

        val result = LoginValidator.validateLogin(username, password)
        assertThat(result.isValid).isEqualTo(false)
    }

    @Test
    fun validateLogin_whenPasswordShouldNotContainSpaces_returnFalse() {
        val username = "aravindhgmail.com"
        val password = "Test@ 123"

        val result = LoginValidator.validateLogin(username, password)
        assertThat(result.isValid).isEqualTo(false)
    }
}