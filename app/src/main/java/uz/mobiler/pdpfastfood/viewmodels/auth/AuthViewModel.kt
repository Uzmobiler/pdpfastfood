package uz.mobiler.pdpfastfood.viewmodels.auth

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.gson.Gson
import kotlinx.coroutines.launch
import uz.mobiler.pdpfastfood.models.auth.check_phone.ResCheckPhone
import uz.mobiler.pdpfastfood.repository.auth.AuthRepository
import uz.mobiler.pdpfastfood.utils.NetworkHelper
import uz.mobiler.pdpfastfood.utils.Resource
import javax.inject.Inject
import javax.inject.Singleton

class AuthViewModel @Inject constructor(
    private val repository: AuthRepository,
    val networkHelper: NetworkHelper
) : ViewModel() {

    fun checkPhone(phoneNumber: String): LiveData<Resource<ResCheckPhone>> {
        val liveData = MutableLiveData<Resource<ResCheckPhone>>()
        if (networkHelper.isNetworkConnected()) {
            viewModelScope.launch {
                liveData.postValue(Resource.loading(null))
                val response = repository.checkPhone(phoneNumber)
                if (response.isSuccessful) {
                    liveData.postValue(Resource.success(response.body()))
                } else {
                    val str = response.errorBody()?.string()
                    val errorResCheckPhone = Gson().fromJson(str, ResCheckPhone::class.java)
                    val errorMsg = errorResCheckPhone.errors[0].errorMsg
                    liveData.postValue(Resource.error(errorMsg, null))
                }
            }
        } else {
            liveData.postValue(Resource.error("No internet connection", null))
        }
        return liveData
    }
}