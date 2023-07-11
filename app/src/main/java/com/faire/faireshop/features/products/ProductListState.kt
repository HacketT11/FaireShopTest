package com.faire.faireshop.features.products

import com.faire.faireshop.data.product.models.Product

data class ProductListState(val isLoading: Boolean = true, val products: List<Product> = listOf())