package uz.mobiler.pdpfastfood.network

import retrofit2.Response
import retrofit2.http.GET
import uz.mobiler.pdpfastfood.models.region.ResRegion

interface RegionService {

    @GET("/api/region")
    suspend fun getRegions(): Response<ResRegion>
}