package com.faire.faireshop.features.products

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState

@Composable
fun ProductListScreen(viewModel: ProductListViewModel) {

    val state = viewModel.state.collectAsState()

    ProductListComponent(state = state.value)
    ProductsListEventProcessor(viewModel.events)
}
