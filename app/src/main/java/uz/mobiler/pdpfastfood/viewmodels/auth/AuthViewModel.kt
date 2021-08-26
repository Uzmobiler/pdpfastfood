package uz.mobiler.pdpfastfood.viewmodels.auth

import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.gson.Gson
import kotlinx.coroutines.launch
import uz.mobiler.pdpfastfood.models.auth.check_code.ResCheckCode
import uz.mobiler.pdpfastfood.models.auth.check_phone.ResCheckPhone
import uz.mobiler.pdpfastfood.models.auth.sign_up.ReqSignUp
import uz.mobiler.pdpfastfood.models.auth.sign_up.ResSignUp
import uz.mobiler.pdpfastfood.repository.auth.AuthRepository
import uz.mobiler.pdpfastfood.storage.DataStoreManager
import uz.mobiler.pdpfastfood.utils.NetworkHelper
import uz.mobiler.pdpfastfood.utils.Resource
import javax.inject.Inject

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

    fun checkCode(code: String, phoneNumber: String): LiveData<Resource<ResCheckCode>> {
        val liveData = MutableLiveData<Resource<ResCheckCode>>()
        if (networkHelper.isNetworkConnected()) {
            viewModelScope.launch {
                liveData.postValue(Resource.loading(null))
                val response = repository.checkCode(code, phoneNumber)
                if (response.isSuccessful) {
                    liveData.postValue(Resource.success(response.body()))
                } else {
                    val str = response.errorBody()?.string()
                    val errorResCheckPhone = Gson().fromJson(str, ResCheckCode::class.java)
                    val errorMsg = errorResCheckPhone.errors[0].errorMsg
                    liveData.postValue(Resource.error(errorMsg, null))
                }
            }
        } else {
            liveData.postValue(Resource.error("No internet connection", null))
        }
        return liveData
    }


    fun signUp(reqSignUp: ReqSignUp): LiveData<Resource<ResSignUp>> {
        val liveData = MutableLiveData<Resource<ResSignUp>>()
        if (networkHelper.isNetworkConnected()) {
            viewModelScope.launch {
                liveData.postValue(Resource.loading(null))
                val response = repository.signUp(reqSignUp)
                if (response.isSuccessful) {
                    liveData.postValue(Resource.success(response.body()))
                } else {
                    val str = response.errorBody()?.string()
                    val errorResCheckPhone = Gson().fromJson(str, ResSignUp::class.java)
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