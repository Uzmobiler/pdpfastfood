package uz.mobiler.pdpfastfood.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import uz.mobiler.pdpfastfood.databinding.ItemBranchBinding
import uz.mobiler.pdpfastfood.models.BranchData

class BranchAdapter(var list: List<BranchData>) : RecyclerView.Adapter<BranchAdapter.Vh>() {

    inner class Vh(var itemBranchBinding: ItemBranchBinding) :
        RecyclerView.ViewHolder(itemBranchBinding.root) {

        fun onBind(branchData: BranchData) {
            itemBranchBinding.apply {
                nameTv.text = branchData.name
                addressTv.text = branchData.address
                workTv.text = branchData.workTime
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(ItemBranchBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int = list.size
}