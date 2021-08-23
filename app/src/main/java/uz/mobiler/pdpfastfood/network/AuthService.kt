package uz.mobiler.pdpfastfood.network

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query
import uz.mobiler.pdpfastfood.models.auth.check_code.ResCheckCode
import uz.mobiler.pdpfastfood.models.auth.check_phone.ResCheckPhone
import uz.mobiler.pdpfastfood.models.auth.sign_up.ReqSignUp
import uz.mobiler.pdpfastfood.models.auth.sign_up.ResSignUp

interface AuthService {

    @GET("api/auth/check-phone")
    suspend fun checkPhone(@Query("phoneNumber") phoneNumber: String): Response<ResCheckPhone>

    @GET("api/auth/check-code")
    suspend fun checkCode(
        @Query("code") code: String,
        @Query("phoneNumber") phoneNumber: String
    ): Response<ResCheckCode>

    @POST("api/auth/sign-up")
    suspend fun signUp(@Body reqSignUp: ReqSignUp): Response<ResSignUp>



}