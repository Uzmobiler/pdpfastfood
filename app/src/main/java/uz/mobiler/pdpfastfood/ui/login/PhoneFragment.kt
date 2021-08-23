package uz.mobiler.pdpfastfood.ui.login

import android.app.Application
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.zhuinden.fragmentviewbindingdelegatekt.viewBinding
import uz.mobiler.pdpfastfood.App
import uz.mobiler.pdpfastfood.R
import uz.mobiler.pdpfastfood.databinding.FragmentPhoneBinding
import uz.mobiler.pdpfastfood.utils.Status
import uz.mobiler.pdpfastfood.utils.showToast
import uz.mobiler.pdpfastfood.viewmodels.auth.AuthViewModel
import javax.inject.Inject

class PhoneFragment : Fragment(R.layout.fragment_phone) {

    private val binding by viewBinding(FragmentPhoneBinding::bind)

    @Inject
    lateinit var authViewModel: AuthViewModel

    private val TAG = "PhoneFragment"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        App.app.applicationComponent.inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        authViewModel.checkPhone("998970079621")
            .observe(viewLifecycleOwner, Observer {
                when (it.status) {
                    Status.LOADING -> {

                    }
                    Status.SUCCESS -> {
                        Log.d(TAG, "onViewCreated: ${it.data}")
                    }
                    Status.ERROR -> {
                        requireContext().showToast(it.message ?: "")
                    }
                }
            })

    }
}