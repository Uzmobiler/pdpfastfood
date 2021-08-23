package uz.mobiler.pdpfastfood.repository.auth

import uz.mobiler.pdpfastfood.network.AuthService
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AuthRepository @Inject constructor(private val authService: AuthService) {

    suspend fun checkPhone(phoneNumber: String) = authService.checkPhone(phoneNumber)
}