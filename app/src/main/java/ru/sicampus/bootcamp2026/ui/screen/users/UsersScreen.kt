package ru.sicampus.bootcamp2026.ui.screen.users

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil3.compose.AsyncImage
import ru.sicampus.bootcamp2026.domain.entities.UserEntity

@Composable
fun UsersScreen(
    viewModel: UsersViewModel = viewModel<UsersViewModel>()
) {
    val state by viewModel.uiState.collectAsState()

    when (val currentState = state) {
        is UsersState.Loading -> UsersLoadingState()
        is UsersState.Content -> UsersContentState(currentState)
        is UsersState.Error -> UsersErrorState(currentState, onRefresh = { viewModel.getData() })
    }
}

@Preview
@Composable
private fun UsersLoadingState() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        CircularProgressIndicator(
            modifier = Modifier.size(48.dp)
        )
    }
}

@Composable
private fun UsersErrorState(
    state: UsersState.Error,
    onRefresh: () -> Unit
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(state.reason)
            Button(
                onClick = onRefresh
            ) {
                Text("Refresh")
            }
        }
    }
}

@Composable
private fun UsersContentState(
    state: UsersState.Content
) {
    Column(
        modifier = Modifier.fillMaxSize(),
    ) {
        state.users.forEach { user ->
            Row(
                modifier = Modifier.padding(vertical = 8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                AsyncImage(
                    modifier = Modifier.size(48.dp).clip(CircleShape),
                    model = user.photoUrl,
                    contentDescription = null
                )
                Column {
                    Text(user.name)
                    Text(user.email)
                }
            }
        }
    }
}

@Preview
@Composable
private fun TestUsersContentState() {
    UsersContentState(UsersState.Content(
        listOf<UserEntity>(
            UserEntity("Ramis Girfanov", "girfanov2007@gmail.com", "something"),
            UserEntity("Somebody Once Told", "somebody@yandex.ru", "metheworldisgonnarollme")
        )
    ))
}