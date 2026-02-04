package ru.sicampus.bootcamp2026.domain.users

import ru.sicampus.bootcamp2026.data.UserRepository
import ru.sicampus.bootcamp2026.domain.users.entities.UserEntity

class GetUsersUseCase(
    private val userRepository: UserRepository
) {
    suspend operator fun invoke(): Result<List<UserEntity>> {
        return userRepository.getUsers()
    }
}