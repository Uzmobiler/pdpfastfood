package uz.mobiler.pdpfastfood.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import uz.mobiler.pdpfastfood.databinding.ItemFavoriteBinding
import uz.mobiler.pdpfastfood.models.Product

class FavoriteAdapter(var list: List<Product>) : RecyclerView.Adapter<FavoriteAdapter.Vh>() {

    inner class Vh(itemFavoriteBinding: ItemFavoriteBinding) :
        RecyclerView.ViewHolder(itemFavoriteBinding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(ItemFavoriteBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: Vh, position: Int) {

    }

    override fun getItemCount(): Int = list.size
}