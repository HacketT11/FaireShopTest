package com.faire.faireshop.data.product

import com.faire.faireshop.data.product.models.Product

interface ProductRepository {

    suspend fun getProducts(): Result<List<Product>>
}

//we also can create mapper entity and inject in here
class ProductRepositoryImpl(private val productService: ProductService) : ProductRepository {

    override suspend fun getProducts(): Result<List<Product>> {
        return productService.getProducts().map {
            it.map { dto ->
                Product(
                    id = dto.id,
                    description = dto.description,
                    name = dto.name,
                    image = dto.image,
                    price = dto.price.price.toString() + dto.price.currency
                )
            }
        }
    }

}