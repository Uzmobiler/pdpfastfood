package uz.mobiler.pdpfastfood.repository.auth

import uz.mobiler.pdpfastfood.network.RegionService
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RegionRepository @Inject constructor(private val regionService: RegionService) {

    suspend fun getRegions() = regionService.getRegions()
}