package com.faire.faireshop.features.products

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.faire.faireshop.R
import com.faire.faireshop.features.products.components.ProductItemComponent

@Composable
fun ProductListComponent(state: ProductListState) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        LazyColumn(content = {
            items(
                count = state.products.size,
//                key = { state.products[it].id }, // we have 2 same ids that returns from that API, it causes exception
                itemContent = {
                    ProductItemComponent(product = state.products[it])
                })
        }, modifier = Modifier.fillMaxSize())
        AnimatedVisibility(visible = state.isLoading) {
            CircularProgressIndicator()
        }
        AnimatedVisibility(visible = state.products.isEmpty()) {
            Text(text = stringResource(id = R.string.empty))
        }
    }
}