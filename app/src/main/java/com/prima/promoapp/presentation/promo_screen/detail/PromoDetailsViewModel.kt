package com.prima.promoapp.presentation.promo_screen.detail

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.prima.promoapp.data.data_sources.remote.PromoRemoteSource
import com.prima.promoapp.presentation.NavigationKeys
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.lang.IllegalStateException
import javax.inject.Inject

@HiltViewModel
class PromoDetailsViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val remoteSource: PromoRemoteSource
): ViewModel() {

    var state by mutableStateOf(
        PromoDetailState(
            promo = null
        )
    )
        private set

    init {
        viewModelScope.launch {
            val promoId = savedStateHandle.get<String>(NavigationKeys.Arg.PROMO_ID)
                ?: throw IllegalStateException("No promoID passed to destination")

            val promoList = remoteSource.getPromo()
            val promo = promoList.first { it.id == promoId }

            state = state.copy(
                promo = promo
            )
        }
    }
}