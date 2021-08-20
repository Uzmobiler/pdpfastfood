package uz.mobiler.pdpfastfood.adapters

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import uz.mobiler.pdpfastfood.ui.branch.BranchPageFragment

class BranchPagerAdapter(fragment: Fragment, var list: List<String>) : FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int {
        return list.size
    }

    override fun createFragment(position: Int): Fragment {
        return BranchPageFragment()
    }
}