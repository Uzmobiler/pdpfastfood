package uz.mobiler.pdpfastfood.ui.profile

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.zhuinden.fragmentviewbindingdelegatekt.viewBinding
import uz.mobiler.pdpfastfood.R
import uz.mobiler.pdpfastfood.databinding.FragmentPinCodeBinding

class PinCodeFragment : Fragment(R.layout.fragment_pin_code) {

    private val binding by viewBinding(FragmentPinCodeBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {

            switch2.setOnCheckedChangeListener { buttonView, isChecked ->
                if (isChecked) {
                    findNavController().navigate(R.id.lockViewFragment)
                }
            }
        }
    }
}