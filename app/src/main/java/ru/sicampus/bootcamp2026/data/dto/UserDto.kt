package ru.sicampus.bootcamp2026.data.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UserDto(
    @SerialName("name")
    val name: String?,
    @SerialName("personalEmail")
    val personalEmail: String?,
    @SerialName("photoUrl")
    val photoUrl: String?,
)
