package com.prima.promoapp.presentation.promo_screen.detail

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PromoDetails(
    state: PromoDetailState,
    navController: NavController
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Detail")
                },
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = Color.White
                )
            )
        }
    ) {
        Column(
            modifier = Modifier.padding(
                top = it.calculateTopPadding(),
                start = 15.dp,
                end = 15.dp
            ).fillMaxSize(),
            Arrangement.SpaceBetween
        ) {
            Column {
                Spacer(modifier = Modifier.height(10.dp))
                Row(
                    modifier = Modifier.padding(bottom = 6.dp)
                ) {
                    Text(text = "Promo Name : ", fontWeight = FontWeight.Bold)
                    state.promo?.let { it1 -> Text(text = it1.promoName) }
                }
                Divider(thickness = 2.dp)

                Row(
                    modifier = Modifier.padding(bottom = 6.dp)
                ) {
                    Text(text = "Promo Location : ", fontWeight = FontWeight.Bold)
                    state.promo?.let { it1 -> Text(text = it1.location) }
                }
                Divider(thickness = 2.dp)

                Spacer(modifier = Modifier.height(10.dp))
                Text(text = "Description", fontWeight = FontWeight.Bold)
                state.promo?.let { it1 -> Text(text = it1.description) }
            }
            
            OutlinedButton(
                modifier = Modifier.fillMaxWidth(),
                onClick = {
                    navController.popBackStack()
                }
            ) {
                Text(text = "back")
            }
        }
    }
}