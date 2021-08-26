package uz.mobiler.pdpfastfood.ui.login

import android.app.DatePickerDialog
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.BulletSpan
import android.text.style.ForegroundColorSpan
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.zhuinden.fragmentviewbindingdelegatekt.viewBinding
import uz.mobiler.pdpfastfood.R
import uz.mobiler.pdpfastfood.databinding.FragmentRegisterBinding
import android.text.TextPaint

import android.content.Intent
import android.graphics.Region
import android.text.method.LinkMovementMethod

import android.text.style.ClickableSpan
import android.widget.DatePicker
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import uz.mobiler.pdpfastfood.App
import uz.mobiler.pdpfastfood.MainActivity
import uz.mobiler.pdpfastfood.adapters.RegionAdapter
import uz.mobiler.pdpfastfood.models.auth.sign_up.ReqSignUp
import uz.mobiler.pdpfastfood.models.region.RegionData
import uz.mobiler.pdpfastfood.utils.Status
import uz.mobiler.pdpfastfood.utils.getDate
import uz.mobiler.pdpfastfood.utils.showToast
import uz.mobiler.pdpfastfood.viewmodels.auth.AuthViewModel
import uz.mobiler.pdpfastfood.viewmodels.region.RegionViewModel
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject
import kotlin.collections.ArrayList


class RegisterFragment : Fragment(R.layout.fragment_register) {

    private val binding by viewBinding(FragmentRegisterBinding::bind)

    private lateinit var phone: String
    private lateinit var code: String

    @Inject
    lateinit var authViewModel: AuthViewModel

    @Inject
    lateinit var regionViewModel: RegionViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        App.app.applicationComponent.inject(this)

        arguments?.let {
            phone = it.getString("phone", "")
            code = it.getString("code", "")
        }
    }

    lateinit var regionAdapter: RegionAdapter
    lateinit var list: ArrayList<RegionData>

    lateinit var simpleDateFormat1: SimpleDateFormat
    lateinit var simpleDateFormat2: SimpleDateFormat

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        list = ArrayList()
        regionAdapter = RegionAdapter(list)

        binding.apply {
            val spannable = SpannableString("Saytdan foydalanish shartlariga roziman")
            val clickableSpan: ClickableSpan = object : ClickableSpan() {
                override fun onClick(textView: View) {
                    requireContext().showToast("Click")
                }

                override fun updateDrawState(ds: TextPaint) {
                    super.updateDrawState(ds)
                    ds.color = resources.getColor(R.color.purple_500)
                    ds.isUnderlineText = false
                }
            }
            spannable.setSpan(
                clickableSpan,
                20, 31,
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
            )
            tv.text = spannable
            tv.movementMethod = LinkMovementMethod.getInstance()
            simpleDateFormat1 = SimpleDateFormat("dd.MM.yyyy")
            simpleDateFormat2 = SimpleDateFormat("yyyy-MM-dd")


            regionSpinner.adapter = regionAdapter

            regionViewModel.getRegions().observe(viewLifecycleOwner, Observer {
                when (it.status) {
                    Status.ERROR -> {

                    }
                    Status.LOADING -> {

                    }
                    Status.SUCCESS -> {
                        list.addAll(it.data?.data ?: emptyList())
                        regionAdapter.notifyDataSetChanged()
                    }
                }
            })

            calendarImg.setOnClickListener {
                val calendar = Calendar.getInstance()
                val year = calendar.get(Calendar.YEAR)
                val month = calendar.get(Calendar.MONTH) + 1
                val day = calendar.get(Calendar.DAY_OF_MONTH)
                val dialog =
                    DatePickerDialog(requireContext(), { view, year, month, dayOfMonth ->
                        birthDate.setText("${getDate(dayOfMonth)}${getDate(month)}$year")
                    }, year, month, day)
                dialog.show()
            }

            confirmBtn.setOnClickListener {
                val regionId = list[regionSpinner.selectedItemPosition].id
                val fullName = fullNameEt.text.toString()
                if (fullName.isEmpty()) {
                    requireContext().showToast("Ismingizni kiriting")
                } else {
                    var birthDate1 = birthDate.rawText

                    if (birthDate1.isEmpty()) {
                        requireContext().showToast("Tug'ilgan kuningizni kiriting")
                    } else {
                        if (checkbox.isChecked) {
                            birthDate1 = birthDate.text.toString()
                            val date = simpleDateFormat1.parse(birthDate1)
                            val birthDate2 = simpleDateFormat2.format(date)
                            val reqSignUp =
                                ReqSignUp(birthDate2, code, fullName, "RU", phone, regionId)

                            authViewModel.signUp(reqSignUp).observe(viewLifecycleOwner, Observer {
                                when (it.status) {
                                    Status.ERROR -> {
                                        requireContext().showToast(it.message ?: "")
                                    }
                                    Status.LOADING -> {

                                    }
                                    Status.SUCCESS -> {
                                        val accessToken = it.data?.accessToken
                                        val refreshToken = it.data?.refreshToken

                                        val intent =
                                            Intent(requireActivity(), MainActivity::class.java)
                                        startActivity(intent)
                                    }
                                }
                            })
                        } else {
                            requireContext().showToast("Foydalanish shartlari bilan tanishib chiqing")
                        }
                    }
                }
            }
        }
    }

}