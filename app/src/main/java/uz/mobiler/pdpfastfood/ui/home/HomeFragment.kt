package uz.mobiler.pdpfastfood.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.zhuinden.fragmentviewbindingdelegatekt.viewBinding
import nl.joery.animatedbottombar.AnimatedBottomBar
import uz.mobiler.pdpfastfood.R
import uz.mobiler.pdpfastfood.adapters.ViewPagerAdapter
import uz.mobiler.pdpfastfood.databinding.FragmentHomeBinding

class HomeFragment : Fragment(R.layout.fragment_home) {

    private val binding by viewBinding(FragmentHomeBinding::bind)

    private lateinit var viewPagerAdapter: ViewPagerAdapter
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {

            viewPagerAdapter = ViewPagerAdapter(this@HomeFragment)
            viewPager.adapter = viewPagerAdapter
            viewPager.isUserInputEnabled = false

            bottomBar.setOnTabSelectListener(object : AnimatedBottomBar.OnTabSelectListener {
                override fun onTabSelected(
                    lastIndex: Int,
                    lastTab: AnimatedBottomBar.Tab?,
                    newIndex: Int,
                    newTab: AnimatedBottomBar.Tab
                ) {
                    viewPager.currentItem = newIndex
                }
            })
        }
    }
}