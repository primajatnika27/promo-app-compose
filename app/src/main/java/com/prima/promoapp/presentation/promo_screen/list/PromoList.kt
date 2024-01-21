package com.prima.promoapp.presentation.promo_screen.list

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.prima.promoapp.model.Promo
import com.prima.promoapp.presentation.utils.TimeUtils

@RequiresApi(Build.VERSION_CODES.O)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PromoList(
    state: PromoListState,
    onNavigationRequested: (itemId: String) -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Promo List")
                },
                colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = MaterialTheme.colorScheme.primary, titleContentColor = Color.White)
            )
        }
    ) {
        Box(modifier = Modifier.padding(it)) {
            LazyColumn(
                contentPadding = PaddingValues(bottom = 16.dp)
            ) {
                items(state.promoList) { item ->
                    PromoItemRow(item = item, onTap = {
                        onNavigationRequested(item.id)
                    })
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun PromoItemRow(
    item: Promo,
    onTap: (id: String) -> Unit = { }
) {
    ElevatedCard(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        onClick = {
            onTap(item.id)
        }
    ) {
        Spacer(modifier = Modifier.height(10.dp))

        Row(modifier = Modifier.padding(start = 10.dp)) {
            Text(text = "Promo Name : ", fontWeight = FontWeight.Bold)
            Text(text = item.promoName)
        }

        Row(modifier = Modifier.padding(start = 10.dp)) {
            Text(text = "Created Date: ")
            Text(text = TimeUtils().getFormattedTime(item.createdDate))
        }

        Spacer(modifier = Modifier.height(15.dp))

        Row(modifier = Modifier.padding(start = 10.dp)) {
            Text(text = "Judul: ")
            Text(text = item.title)
        }

        Spacer(modifier = Modifier.height(10.dp))
    }
}