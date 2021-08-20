package uz.mobiler.pdpfastfood.ui.branch

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import com.zhuinden.fragmentviewbindingdelegatekt.viewBinding
import uz.mobiler.pdpfastfood.R
import uz.mobiler.pdpfastfood.adapters.BranchAdapter
import uz.mobiler.pdpfastfood.databinding.FragmentBranchPageBinding
import uz.mobiler.pdpfastfood.utils.getBranches

class BranchPageFragment : Fragment(R.layout.fragment_branch_page) {

    private val binding by viewBinding(FragmentBranchPageBinding::bind)

    private lateinit var branchAdapter: BranchAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        branchAdapter = BranchAdapter(getBranches())

        binding.apply {
            rv.addItemDecoration(
                DividerItemDecoration(
                    requireContext(),
                    DividerItemDecoration.VERTICAL
                )
            )
            rv.adapter = branchAdapter
        }
    }

}