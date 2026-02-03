package ru.sicampus.bootcamp2026.ui.screens.SignIn

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.sicampus.bootcamp2026.ui.theme.accentBlue

@Composable
fun SignIn (
    modifier: Modifier = Modifier,
    onNavigateToSignUp: () -> Unit,
    onNavigateToTimeTable: () -> Unit
) {
    // val state by remember { mutableStateOf() } // вообще насколько зн нужно собирать все состояния
    Column(
        modifier = Modifier.fillMaxSize().verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        /*Row (){
        Text("Вход", fontSize = 30.sp)
            Spacer(modifier = Modifier.fillMaxWidth())
        }*/
        Text("Вход", fontSize = 30.sp)
        Spacer(modifier = Modifier.padding(vertical = 10.dp))
        val login = remember{mutableStateOf("")}
        OutlinedTextField(
            label = {Text("Логин")},
            value = login.value,
            onValueChange = {it -> login.value = it},
            shape = RoundedCornerShape(20.dp)
        )
        val pass = remember{mutableStateOf("")}
        OutlinedTextField(
            label = {Text("Пароль")},
            value = pass.value,
            onValueChange = {it -> pass.value = it},
            shape = RoundedCornerShape(20.dp)
        )
        Spacer(modifier = Modifier.padding(vertical = 10.dp))
        Button(onClick = {
            //SignInState.Data(userLoggedIn = true)
            onNavigateToTimeTable()
                         },
            colors = ButtonDefaults.buttonColors(
                accentBlue
            ),
            modifier = Modifier.width(275.dp),
            shape = RoundedCornerShape(15.dp)
            ){
            Text("Вход")
        }
        OutlinedButton(onClick = {onNavigateToSignUp()},
            border = BorderStroke(1.dp,accentBlue),
            modifier = Modifier.width(275.dp),
            shape = RoundedCornerShape(15.dp)) {
            Text("Регистрация")
        }
        /*OtlinedButton(onClick = {},
            colors = ButtonDefaults.buttonColors(
                transporant
            ),
            border = BorderStroke(1.dp, accentBlue),
            modifier = Modifier.padding(2.dp).width(275.dp)
        ){
            Text("Регистрация")
        }*/
    }
}

/*
@Preview
@Composable
fun see() {
    SignIn(onNavigateToSignUp = {
        navController.navigate(route = SignUp)
    })
}*/
