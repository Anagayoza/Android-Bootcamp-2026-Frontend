package ru.sicampus.bootcamp2026.ui.screen.users

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import ru.sicampus.bootcamp2026.data.UserRepository
import ru.sicampus.bootcamp2026.data.source.UserInfoDataSource
import ru.sicampus.bootcamp2026.domain.GetUsersUseCase

class UsersViewModel: ViewModel() {
    private val getUsersUseCase = GetUsersUseCase(
        userRepository = UserRepository(UserInfoDataSource())
    )
    private val _uiState: MutableStateFlow<UsersState> = MutableStateFlow(UsersState.Loading)
    val uiState = _uiState.asStateFlow()

    init {
        getData()
    }

    fun getData() {
        viewModelScope.launch {
            _uiState.emit(UsersState.Loading)
            getUsersUseCase.invoke().fold(
                onSuccess = { data ->
                    _uiState.emit(UsersState.Content(data))
                },
                onFailure = { error ->
                    _uiState.emit((UsersState.Error(error.message.orEmpty())))
                }
            )
        }
    }
}