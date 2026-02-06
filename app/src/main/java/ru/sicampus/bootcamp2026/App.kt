package ru.sicampus.bootcamp2026

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import androidx.navigation.NavController

class App: Application() {
    override fun onCreate() {
        super.onCreate()
        context = this
    }
    companion object {
        lateinit var context: Context
    }
}