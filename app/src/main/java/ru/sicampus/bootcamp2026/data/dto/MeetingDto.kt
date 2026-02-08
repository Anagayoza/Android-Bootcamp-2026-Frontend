package ru.sicampus.bootcamp2026.data.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MeetingDto (
    @SerialName("title")
    val title: String?,
    @SerialName("date")
    val date: String?,

)