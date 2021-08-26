package uz.mobiler.pdpfastfood.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import uz.mobiler.pdpfastfood.databinding.ItemRegionBinding
import uz.mobiler.pdpfastfood.models.region.RegionData

class RegionAdapter(var list: List<RegionData>) : BaseAdapter() {
    override fun getCount(): Int = list.size

    override fun getItem(position: Int): RegionData = list[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val itemRegionBinding: ItemRegionBinding
        if (convertView == null) {
            itemRegionBinding =
                ItemRegionBinding.inflate(LayoutInflater.from(parent?.context), parent, false)
        } else {
            itemRegionBinding = ItemRegionBinding.bind(convertView)
        }
        itemRegionBinding.regionTv.text = list[position].region
        return itemRegionBinding.root
    }
}