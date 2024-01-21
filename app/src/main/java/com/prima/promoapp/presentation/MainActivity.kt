package com.prima.promoapp.presentation

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.prima.promoapp.presentation.promo_screen.PromoScreen
import com.prima.promoapp.ui.theme.PromoAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PromoAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    PromoScreen()
                }
            }
        }
    }
}

object NavigationKeys {

    object Arg {
        const val PROMO_ID = "promoId"
    }

    object Route {
        const val PROMO_LIST = "promo_list"
        const val PROMO_DETAIL = "$PROMO_LIST/{${Arg.PROMO_ID}}"
    }

}