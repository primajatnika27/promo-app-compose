package com.prima.promoapp.presentation.promo_screen.list

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.prima.promoapp.data.data_sources.remote.PromoRemoteSource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PromoViewModel @Inject constructor(
    private val remoteSource: PromoRemoteSource
): ViewModel() {

    var state by mutableStateOf(
        PromoListState(
            promoList = listOf(),
            isLoading = true
        )
    )
    private set

    init {
        viewModelScope.launch {
            getAllPromo()
        }
    }

    private suspend fun getAllPromo() {
        val promo = remoteSource.getPromo()

        viewModelScope.launch {
            state = state.copy(promoList = promo, isLoading = false)
        }
    }
}