package uz.mobiler.pdpfastfood.models.auth.sign_up

import uz.mobiler.pdpfastfood.models.auth.check_phone.ResErrorCheckPhone

data class ResSignUp(
    val accessToken: String,
    val refreshToken: String,
    val success: Boolean,
    val message: String,
    val errors: List<ResErrorCheckPhone>

)