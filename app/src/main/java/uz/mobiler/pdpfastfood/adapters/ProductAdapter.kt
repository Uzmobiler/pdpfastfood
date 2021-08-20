package uz.mobiler.pdpfastfood.adapters

import android.text.Html
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import uz.mobiler.pdpfastfood.databinding.ItemProductBinding
import uz.mobiler.pdpfastfood.models.Product
import uz.mobiler.pdpfastfood.utils.onClick

class ProductAdapter(var list: List<Product>, val listener: OnItemClickListener) :
    RecyclerView.Adapter<ProductAdapter.Vh>() {


    inner class Vh(var itemProductBinding: ItemProductBinding) :
        RecyclerView.ViewHolder(itemProductBinding.root) {

        fun onBind(product: Product) {
            itemProductBinding.apply {
                val a = product.nowPrice.toString()
                val b = Html.fromHtml("<del>$a</del>")
                lastRate.text = b

                card.onClick { listener.onItemClick(product) }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(ItemProductBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int = list.size

    interface OnItemClickListener {
        fun onItemClick(product: Product)
    }
}