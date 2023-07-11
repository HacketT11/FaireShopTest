package com.faire.faireshop.domain

import com.faire.faireshop.data.product.ProductRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

//dispatcher should be named but we use only one - IO
class GetProductsUseCase(
    private val productRepository: ProductRepository,
    private val dispatcher: CoroutineDispatcher
) {
    suspend operator fun invoke() = withContext(dispatcher) {
        productRepository.getProducts()
    }
}