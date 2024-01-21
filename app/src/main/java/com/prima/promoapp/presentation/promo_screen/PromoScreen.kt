package com.prima.promoapp.presentation.promo_screen

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.prima.promoapp.presentation.NavigationKeys
import com.prima.promoapp.presentation.promo_screen.detail.PromoDetails
import com.prima.promoapp.presentation.promo_screen.detail.PromoDetailsViewModel
import com.prima.promoapp.presentation.promo_screen.list.PromoList
import com.prima.promoapp.presentation.promo_screen.list.PromoViewModel

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun PromoScreen() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = NavigationKeys.Route.PROMO_LIST) {
        composable(route = NavigationKeys.Route.PROMO_LIST) {
            PromoListDestination(navController = navController)
        }

        composable(
            route = NavigationKeys.Route.PROMO_DETAIL,
            arguments = listOf(navArgument(NavigationKeys.Arg.PROMO_ID) {
                type = NavType.StringType
            })
        ) {
            PromoDetailDestination(navController)
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun PromoListDestination(navController: NavController) {
    val viewModel: PromoViewModel = hiltViewModel()
    PromoList(
        state = viewModel.state,
        onNavigationRequested = { promoId ->
            navController.navigate("${NavigationKeys.Route.PROMO_LIST}/${promoId}")
        }
    )
}

@Composable
fun PromoDetailDestination(navController: NavController) {
    val viewModel: PromoDetailsViewModel = hiltViewModel()
    PromoDetails(viewModel.state, navController)
}