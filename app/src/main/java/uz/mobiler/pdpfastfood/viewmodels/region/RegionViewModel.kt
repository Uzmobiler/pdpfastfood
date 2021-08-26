package uz.mobiler.pdpfastfood.viewmodels.region

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.gson.Gson
import kotlinx.coroutines.launch
import uz.mobiler.pdpfastfood.models.auth.check_phone.ResCheckPhone
import uz.mobiler.pdpfastfood.models.region.ResRegion
import uz.mobiler.pdpfastfood.repository.auth.AuthRepository
import uz.mobiler.pdpfastfood.repository.auth.RegionRepository
import uz.mobiler.pdpfastfood.utils.NetworkHelper
import uz.mobiler.pdpfastfood.utils.Resource
import javax.inject.Inject

class RegionViewModel @Inject constructor(
    private val repository: RegionRepository,
    val networkHelper: NetworkHelper
) : ViewModel() {

    fun getRegions(): LiveData<Resource<ResRegion>> {
        val liveData = MutableLiveData<Resource<ResRegion>>()
        if (networkHelper.isNetworkConnected()) {
            viewModelScope.launch {
                liveData.postValue(Resource.loading(null))
                val response = repository.getRegions()
                if (response.isSuccessful) {
                    liveData.postValue(Resource.success(response.body()))
                } else if (response.code() == 500) {
                    liveData.postValue(Resource.error("Serverda xatolik", null))
                }
            }
        } else {
            liveData.postValue(Resource.error("No internet connection", null))
        }
        return liveData
    }
}