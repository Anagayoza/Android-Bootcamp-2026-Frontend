package ru.sicampus.bootcamp2026.ui.screens.SignIn

sealed class SignInState {
    data class Data(
        val userLoggedIn: Boolean = false
    )
}