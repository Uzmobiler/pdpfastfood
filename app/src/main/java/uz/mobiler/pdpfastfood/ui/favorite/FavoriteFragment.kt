package uz.mobiler.pdpfastfood.ui.favorite

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.zhuinden.fragmentviewbindingdelegatekt.viewBinding
import uz.mobiler.pdpfastfood.R
import uz.mobiler.pdpfastfood.adapters.FavoriteAdapter
import uz.mobiler.pdpfastfood.databinding.FragmentFavoriteBinding
import uz.mobiler.pdpfastfood.models.Product
import uz.mobiler.pdpfastfood.utils.getProducts

class FavoriteFragment : Fragment(R.layout.fragment_favorite) {

    private val binding by viewBinding(FragmentFavoriteBinding::bind)

    private lateinit var favoriteAdapter: FavoriteAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        favoriteAdapter = FavoriteAdapter(getProducts())
        binding.apply {
            rv.adapter = favoriteAdapter
        }

    }

}