package com.faire.faireshop.data.product.models

import com.google.gson.annotations.SerializedName

data class ProductDTO(
    @SerializedName("brandToken") val id: String,
    @SerializedName("productImage") val image: String,
    @SerializedName("detailsText") val description: String,
    @SerializedName("productName") val name: String,
    @SerializedName("retailPrice") val price: PriceDTO
)

data class PriceDTO(
    @SerializedName("price") val price: Float,
    @SerializedName("currency") val currency: String
)
