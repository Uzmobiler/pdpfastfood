package uz.mobiler.pdpfastfood.models.auth.check_code

import uz.mobiler.pdpfastfood.models.auth.check_phone.ResErrorCheckPhone

data class ResCheckCode(
    val `data`: Data,
    val success: Boolean,
    val errors: List<ResErrorCheckPhone>
)