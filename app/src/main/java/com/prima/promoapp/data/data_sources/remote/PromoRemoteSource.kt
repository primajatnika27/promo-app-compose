package com.prima.promoapp.data.data_sources.remote

import com.prima.promoapp.model.Promo
import com.prima.promoapp.model.response.PromoResponses
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PromoRemoteSource @Inject constructor(
    private val api: PromoApi
) {

    private var cachedPromo: List<Promo>? = null

    suspend fun getPromo(): List<Promo> = withContext(Dispatchers.IO) {
        var cached = cachedPromo
        if (cached == null) {
            cached = api.getPromo().mapResponseToModel()
            this@PromoRemoteSource.cachedPromo = cached
        }

        return@withContext cached
    }

    private fun PromoResponses.mapResponseToModel(): List<Promo> {
        return this.data.map {
            Promo(
                title = it.attributes.title,
                promoName = it.attributes.promoName,
                description = it.attributes.description,
                descriptionPromo = it.attributes.descriptionPromo,
                location = it.attributes.location,
                createdDate = it.attributes.createdAt,
                id = it.id.toString()
            )
        }
    }
}