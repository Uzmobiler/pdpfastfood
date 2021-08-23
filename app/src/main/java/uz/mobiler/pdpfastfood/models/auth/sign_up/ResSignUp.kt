package uz.mobiler.pdpfastfood.models.auth.sign_up

data class ResSignUp(
    val accessToken: String,
    val refreshToken: String,
    val success: Boolean
)