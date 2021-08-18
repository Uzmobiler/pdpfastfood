package uz.mobiler.pdpfastfood.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.zhuinden.fragmentviewbindingdelegatekt.viewBinding
import uz.mobiler.pdpfastfood.R
import uz.mobiler.pdpfastfood.adapters.ProductAdapter
import uz.mobiler.pdpfastfood.databinding.FragmentMainBinding
import uz.mobiler.pdpfastfood.models.Product
import uz.mobiler.pdpfastfood.utils.getProducts

class MainFragment : Fragment(R.layout.fragment_main) {

    private val binding by viewBinding(FragmentMainBinding::bind)

    private lateinit var productAdapter: ProductAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        productAdapter = ProductAdapter(getProducts())
        binding.apply {
            rv.adapter = productAdapter
        }
    }
}