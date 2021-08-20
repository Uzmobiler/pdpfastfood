package uz.mobiler.pdpfastfood.ui.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.andrognito.pinlockview.PinLockListener
import com.zhuinden.fragmentviewbindingdelegatekt.viewBinding
import uz.mobiler.pdpfastfood.R
import uz.mobiler.pdpfastfood.databinding.FragmentLockViewBinding
import uz.mobiler.pdpfastfood.utils.showToast

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [LockViewFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class LockViewFragment : Fragment(R.layout.fragment_lock_view), PinLockListener {

    private val binding by viewBinding(FragmentLockViewBinding::bind)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            pinLockView.attachIndicatorDots(indicatorDots)

            pinLockView.setPinLockListener(this@LockViewFragment)
        }
    }

    override fun onComplete(pin: String?) {
        requireContext().showToast(pin ?: "")
        binding.pinLockView.resetPinLockView()
    }

    override fun onEmpty() {

    }

    override fun onPinChange(pinLength: Int, intermediatePin: String?) {

    }
}