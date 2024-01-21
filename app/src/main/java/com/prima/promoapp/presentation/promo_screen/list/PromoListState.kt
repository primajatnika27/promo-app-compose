package com.prima.promoapp.presentation.promo_screen.list

import com.prima.promoapp.model.Promo

data class PromoListState(
    val promoList: List<Promo> = listOf(),
    val isLoading: Boolean = false
)
