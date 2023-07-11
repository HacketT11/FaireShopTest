package com.faire.faireshop.features.products

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.faire.faireshop.domain.GetProductsUseCase
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ProductListViewModel(private val getProductsUseCase: GetProductsUseCase) : ViewModel() {

    private val _state = MutableStateFlow(ProductListState())
    val state = _state.asStateFlow()

    private val _events = MutableSharedFlow<ProductListEvent>()
    val events = _events.asSharedFlow()

    init {
        getProducts()
    }

    private fun getProducts() = viewModelScope.launch {
        getProductsUseCase.invoke()
            .onSuccess {
                _state.value = _state.value.copy(products = it, isLoading = false)
            }.onFailure {
                _state.value = _state.value.copy(isLoading = false)
                _events.emit(ErrorEvent)
            }
    }
}