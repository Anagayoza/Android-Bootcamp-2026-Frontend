package ru.sicampus.bootcamp2026.data

import ru.sicampus.bootcamp2026.data.source.SignInLocalDataSource
import ru.sicampus.bootcamp2026.data.source.SignInNetworkDataSource

class SignInRepository(
    private val signInNetworkDataSource: SignInNetworkDataSource,
    private val signInLocalDataSource: SignInLocalDataSource
) {
    suspend fun checkAndSignIn(
        login: String,
        password: String
    ): Result<Boolean> {
        signInLocalDataSource.setToken(login, password)
        return signInNetworkDataSource.checkSignIn()
            .onSuccess { isLogin ->
                if (!isLogin) signInLocalDataSource.clearToken()
            }
            .onFailure {
                signInLocalDataSource.clearToken()
            }
    }

}