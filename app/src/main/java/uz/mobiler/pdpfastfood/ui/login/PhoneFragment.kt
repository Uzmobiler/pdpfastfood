package uz.mobiler.pdpfastfood.ui.login

import android.app.Application
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.zhuinden.fragmentviewbindingdelegatekt.viewBinding
import uz.mobiler.pdpfastfood.App
import uz.mobiler.pdpfastfood.R
import uz.mobiler.pdpfastfood.databinding.FragmentPhoneBinding
import uz.mobiler.pdpfastfood.utils.Status
import uz.mobiler.pdpfastfood.utils.onClick
import uz.mobiler.pdpfastfood.utils.showToast
import uz.mobiler.pdpfastfood.viewmodels.auth.AuthViewModel
import javax.inject.Inject

class PhoneFragment : Fragment(R.layout.fragment_phone) {

    private val binding by viewBinding(FragmentPhoneBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.apply {
            acceptBtn.onClick {
                val phone = "998${phoneEt.rawText}"
                if (phone.length == 12) {
                    val bundle = bundleOf("phone" to phone)
                    findNavController().navigate(R.id.confirmFragment, bundle)
                } else {
                    requireActivity().showToast("Telefon raqamingizni to'liq kiriting!")
                }
            }
        }

    }
}