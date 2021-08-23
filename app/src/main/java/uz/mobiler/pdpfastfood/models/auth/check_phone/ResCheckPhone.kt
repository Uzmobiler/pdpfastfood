package uz.mobiler.pdpfastfood.models.auth.check_phone

data class ResCheckPhone(
    val message: String,
    val success: Boolean,
    val errors:List<ResErrorCheckPhone>
)