package uz.mobiler.pdpfastfood.ui.branch

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayoutMediator
import com.zhuinden.fragmentviewbindingdelegatekt.viewBinding
import uz.mobiler.pdpfastfood.R
import uz.mobiler.pdpfastfood.adapters.BranchPagerAdapter
import uz.mobiler.pdpfastfood.databinding.FragmentBranchBinding
import uz.mobiler.pdpfastfood.utils.getRegions

class BranchFragment : Fragment(R.layout.fragment_branch) {

    private val binding by viewBinding(FragmentBranchBinding::bind)

    private lateinit var branchPagerAdapter: BranchPagerAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        branchPagerAdapter = BranchPagerAdapter(this, getRegions())
        binding.apply {
            viewPager.adapter = branchPagerAdapter
            TabLayoutMediator(tabLayout, viewPager) { tab, position ->
                tab.text = getRegions()[position]
            }.attach()
        }
    }
}