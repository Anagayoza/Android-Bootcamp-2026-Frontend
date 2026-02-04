package ru.sicampus.bootcamp2026.ui.screen.users

import ru.sicampus.bootcamp2026.domain.users.entities.UserEntity

sealed interface UsersState {
    data class Error(val reason: String): UsersState
    data object Loading: UsersState
    data class Content(
        val users: List<UserEntity>
    ): UsersState
}