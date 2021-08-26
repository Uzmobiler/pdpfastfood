package uz.mobiler.pdpfastfood.ui.login

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import androidx.core.os.bundleOf
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.zhuinden.fragmentviewbindingdelegatekt.viewBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import uz.mobiler.pdpfastfood.App
import uz.mobiler.pdpfastfood.MainActivity
import uz.mobiler.pdpfastfood.R
import uz.mobiler.pdpfastfood.databinding.FragmentConfirmBinding
import uz.mobiler.pdpfastfood.storage.DataStoreManager
import uz.mobiler.pdpfastfood.utils.Status
import uz.mobiler.pdpfastfood.utils.showToast
import uz.mobiler.pdpfastfood.viewmodels.auth.AuthViewModel
import javax.inject.Inject

class ConfirmFragment : Fragment(R.layout.fragment_confirm) {

    private val binding by viewBinding(FragmentConfirmBinding::bind)
    private lateinit var phone: String

    @Inject
    lateinit var authViewModel: AuthViewModel

    @Inject
    lateinit var dataStoreManager: DataStoreManager

    private val TAG = "ConfirmFragment"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        App.app.applicationComponent.inject(this)

        arguments?.let {
            phone = it.getString("phone", "")
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            authViewModel.checkPhone(phone)
                .observe(viewLifecycleOwner, Observer {
                    when (it.status) {
                        Status.LOADING -> {

                        }
                        Status.SUCCESS -> {
                            requireContext().showToast(it.data?.message ?: "")
                        }
                        Status.ERROR -> {
                            requireContext().showToast(it.message ?: "")
                        }
                    }
                })

            codeEt.addTextChangedListener {
                val code = it.toString()
                if (code.length == 6) {
                    authViewModel.checkCode(code, phone).observe(viewLifecycleOwner, Observer {
                        when (it.status) {
                            Status.LOADING -> {

                            }
                            Status.SUCCESS -> {
                                if (it.data?.data?.registered == true) {
                                    val accessToken = it.data.data.accessToken
                                    val refreshToken = it.data.data.refreshToken

                                    GlobalScope.launch {
                                        dataStoreManager.setAccessToken(accessToken)
                                        Log.d(TAG, "onViewCreated: ${dataStoreManager.getAccessToken.firstOrNull() ?: ""}")
                                    }
                                    val intent =
                                        Intent(requireActivity(), MainActivity::class.java)
                                    startActivity(intent)
                                } else {
                                    val bundle = bundleOf("phone" to phone, "code" to code)
                                    findNavController().navigate(R.id.registerFragment, bundle)
                                }
                            }
                            Status.ERROR -> {
                                requireContext().showToast(it.message ?: "")
                            }
                        }
                    })
                }
            }
        }
    }

}