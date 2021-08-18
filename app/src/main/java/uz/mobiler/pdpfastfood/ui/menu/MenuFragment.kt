package uz.mobiler.pdpfastfood.ui.menu

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.iammert.tabscrollattacherlib.TabScrollAttacher
import com.zhuinden.fragmentviewbindingdelegatekt.viewBinding
import uz.mobiler.pdpfastfood.R
import uz.mobiler.pdpfastfood.adapters.ProductAdapter
import uz.mobiler.pdpfastfood.databinding.FragmentMenuBinding
import uz.mobiler.pdpfastfood.utils.getCategories
import uz.mobiler.pdpfastfood.utils.getProducts

class MenuFragment : Fragment(R.layout.fragment_menu) {

    private val binding by viewBinding(FragmentMenuBinding::bind)

    private lateinit var productAdapter: ProductAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val list = listOf(0, 10, 20, 30, 40, 100)

        productAdapter = ProductAdapter(getProducts())
        binding.apply {
            rv.adapter = productAdapter
            getCategories().forEach {
                val tab = tabLayout.newTab()
                tab.text = it
                tabLayout.addTab(tab)
            }
            val attacher = TabScrollAttacher(tabLayout, rv, list)
            attacher.attach()
        }
    }
}