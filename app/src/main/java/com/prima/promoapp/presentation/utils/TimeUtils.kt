package com.prima.promoapp.presentation.utils

import android.os.Build
import androidx.annotation.RequiresApi
import java.text.SimpleDateFormat
import java.util.Locale


class TimeUtils {

    @RequiresApi(Build.VERSION_CODES.O)
    fun getFormattedTime(date: String): String {
        val parser = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss")
        val formatter = SimpleDateFormat("MMM d, yyyy, hh:mm a", Locale.getDefault())
        return formatter.format(parser.parse(date))
    }
}