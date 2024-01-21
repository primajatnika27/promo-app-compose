package com.prima.promoapp.data.data_sources.remote

import com.prima.promoapp.model.response.PromoResponses
import javax.inject.Inject
import javax.inject.Singleton
import retrofit2.http.GET
import retrofit2.http.Query

@Singleton
class PromoApi @Inject constructor(
    private val service: Service
) {

    suspend fun getPromo(): PromoResponses = service.getPromos()

    interface Service {
        @GET("api/promos")
        suspend fun getPromos(): PromoResponses
    }

    companion object {
        const val API_URL = "https://content.digi46.id/"
    }
}