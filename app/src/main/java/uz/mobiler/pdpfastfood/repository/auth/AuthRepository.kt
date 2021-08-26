package uz.mobiler.pdpfastfood.repository.auth

import uz.mobiler.pdpfastfood.models.auth.sign_up.ReqSignUp
import uz.mobiler.pdpfastfood.network.AuthService
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AuthRepository @Inject constructor(private val authService: AuthService) {

    suspend fun checkPhone(phoneNumber: String) = authService.checkPhone(phoneNumber)

    suspend fun checkCode(code: String, phoneNumber: String) =
        authService.checkCode(code, phoneNumber)

    suspend fun signUp(reqSignUp: ReqSignUp) =
        authService.signUp(reqSignUp)


}