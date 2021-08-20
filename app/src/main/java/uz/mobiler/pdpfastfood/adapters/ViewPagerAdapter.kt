package uz.mobiler.pdpfastfood.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import uz.mobiler.pdpfastfood.ui.branch.BranchFragment
import uz.mobiler.pdpfastfood.ui.favorite.FavoriteFragment
import uz.mobiler.pdpfastfood.ui.main.MainFragment
import uz.mobiler.pdpfastfood.ui.menu.MenuFragment
import uz.mobiler.pdpfastfood.ui.profile.ProfileFragment

class ViewPagerAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int {
        return 5
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> MainFragment()
            1 -> FavoriteFragment()
            2 -> MenuFragment()
            3 -> BranchFragment()
            4 -> ProfileFragment()
            else -> MainFragment()
        }
    }
}