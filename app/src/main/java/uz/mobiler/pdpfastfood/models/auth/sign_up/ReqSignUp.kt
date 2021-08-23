package uz.mobiler.pdpfastfood.models.auth.sign_up

data class ReqSignUp(
    val birthDate: String,
    val code: String,
    val fullName: String,
    val language: String,
    val phoneNumber: String,
    val regionId: String
)