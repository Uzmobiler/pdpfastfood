package uz.mobiler.pdpfastfood.utils

import android.content.Context
import android.view.View
import android.widget.Toast

fun Context.showToast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

fun View.onClick(listener: (View) -> Unit) {
    this.setOnClickListener { listener.invoke(it) }
}