package uz.mobiler.pdpfastfood.utils

import android.content.Context
import android.view.View
import android.widget.Toast
import uz.mobiler.pdpfastfood.models.BranchData
import uz.mobiler.pdpfastfood.models.Product

fun Context.showToast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

fun View.onClick(listener: (View) -> Unit) {
    this.setOnClickListener { listener.invoke(it) }
}


fun getProducts(): List<Product> {
    val productList = ArrayList<Product>()
    for (i in 1..100) {
        productList.add(Product("Go’shtli lavash", "", 21000.0, 19000.0))
    }
    return productList
}

fun getCategories(): List<String> {
    val list = ArrayList<String>()
    list.add("Set")
    list.add("Lavash")
    list.add("Shaurma")
    list.add("Donar")
    list.add("Burger")
    list.add("Xot-dog")
    return list
}

fun getBranches(): List<BranchData> {
    val list = ArrayList<BranchData>()
    list.add(
        BranchData(
            "Algoritm",
            "Chilonzor rayoni, Sugoli ota 56",
            "09:00 - 03:00",
            41.326397,
            69.228420
        )
    )
    list.add(
        BranchData(
            "Muqimiy",
            "Chilonzor rayoni, Sugoli ota 56",
            "09:00 - 03:00",
            41.326397,
            69.228420
        )
    )
    list.add(
        BranchData(
            "Alayskiy",
            "Chilonzor rayoni, Sugoli ota 56",
            "09:00 - 03:00",
            41.326397,
            69.228420
        )
    )
    list.add(
        BranchData(
            "Parkentskiy",
            "Chilonzor rayoni, Sugoli ota 56",
            "09:00 - 03:00",
            41.326397,
            69.228420
        )
    )
    list.add(
        BranchData(
            "Sofiyski",
            "Chilonzor rayoni, Sugoli ota 56",
            "09:00 - 03:00",
            41.326397,
            69.228420
        )
    )
    return list
}

fun getRegions(): List<String> {
    val list = ArrayList<String>()
    list.add("Toshkent")
    list.add("Farg’ona")
    list.add("Qirguli")
    list.add("Qashqadaryo")
    list.add("Andijon")
    list.add("Navoiy")
    return list
}