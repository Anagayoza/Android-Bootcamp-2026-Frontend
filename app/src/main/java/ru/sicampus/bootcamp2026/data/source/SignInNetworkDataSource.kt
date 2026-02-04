package ru.sicampus.bootcamp2026.data.source

import io.ktor.client.request.get
import io.ktor.client.request.header
import io.ktor.http.HttpHeaders
import io.ktor.http.HttpMessageBuilder
import io.ktor.http.HttpStatusCode
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class SignInNetworkDataSource {
    suspend fun checkSignIn(): Result<Boolean> = withContext(Dispatchers.IO) {
        runCatching {
            val result = Network.client.get("${Network.HOST}/api/users/login") {
                addSignInHeader()
            }
            result.status == HttpStatusCode.OK
        }
    }
}

suspend fun HttpMessageBuilder.addSignInHeader() {
    val token = SignInLocalDataSource.getToken() ?: return
    header(HttpHeaders.Authorization, token)
}