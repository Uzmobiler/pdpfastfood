package uz.mobiler.pdpfastfood.ui.login

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
import android.text.method.LinkMovementMethod

import android.text.style.ClickableSpan
import androidx.navigation.fragment.findNavController
import uz.mobiler.pdpfastfood.utils.showToast


class RegisterFragment : Fragment(R.layout.fragment_register) {

    private val binding by viewBinding(FragmentRegisterBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

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

            confirmBtn.setOnClickListener {
//                findNavController().navigate(R.id.action_registerFragment_to_confirmFragment)
            }
        }
    }

}