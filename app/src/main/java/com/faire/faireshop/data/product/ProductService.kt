package com.faire.faireshop.data.product

import com.faire.faireshop.data.product.models.ProductDTO
import retrofit2.http.GET

interface ProductService {

    @GET("static/mobile-take-home/products-response.json")
    suspend fun getProducts(): Result<List<ProductDTO>>
}