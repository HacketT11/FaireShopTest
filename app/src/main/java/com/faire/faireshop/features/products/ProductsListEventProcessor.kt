package com.faire.faireshop.features.products

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import com.faire.faireshop.R
import kotlinx.coroutines.flow.SharedFlow

@Composable
fun ProductsListEventProcessor(events: SharedFlow<ProductListEvent>) {
    val context = LocalContext.current
    LaunchedEffect(Unit) {
        events.collect {
            when (it) {
                is ErrorEvent -> Toast.makeText(
                    context,
                    context.getString(R.string.error),
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}