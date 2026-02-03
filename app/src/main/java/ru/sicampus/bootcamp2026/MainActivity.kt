package ru.sicampus.bootcamp2026

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import ru.sicampus.bootcamp2026.ui.screen.users.UsersScreen
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import ru.sicampus.bootcamp2026.ui.navigation.Root
import ru.sicampus.bootcamp2026.ui.screens.TimeTable
import ru.sicampus.bootcamp2026.ui.theme.AndroidBootcamp2026FrontendTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            //val navController = rememberNavController()
            //val startDestination = TimeTable()
            AndroidBootcamp2026FrontendTheme {
                Root()
                /*Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    *//*AppNavHost(navController, modifier = Modifier.padding(innerPadding))*//*

                    *//*NavHost(navController = navController, startDestination = SignIn()){
                        composable ("singIn"){ SignIn(Modifier.padding(innerPadding) ) }
                        composable ("sing"){ SignIn(Modifier.padding(innerPadding) ) }
                        composable ("singIn"){ SignIn(Modifier.padding(innerPadding) ) }
                    }*//*

                    *//*Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )*//*
                    //signUp(Modifier.padding(innerPadding))
                }*/
            }
        }
    }
}

/*
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AndroidBootcamp2026FrontendTheme {
        Greeting("Android")
    }
}*/
