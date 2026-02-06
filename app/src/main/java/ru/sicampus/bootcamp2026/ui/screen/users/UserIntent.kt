package ru.sicampus.bootcamp2026.ui.screen.users

sealed interface UserIntent {
    data object LoadMore: UserIntent
    data object Refresh: UserIntent
}