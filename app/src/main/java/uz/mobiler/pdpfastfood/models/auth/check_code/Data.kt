package uz.mobiler.pdpfastfood.models.auth.check_code

data class Data(
    val registered: Boolean,
    val accessToken: String,
    val refreshToken: String
)