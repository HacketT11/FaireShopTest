package com.faire.faireshop.di

import com.faire.faireshop.data.product.ProductRepository
import com.faire.faireshop.data.product.ProductRepositoryImpl
import com.faire.faireshop.data.product.ProductService
import com.faire.faireshop.domain.GetProductsUseCase
import com.faire.faireshop.features.products.ProductListViewModel
import com.faire.faireshop.network.RetrofitServiceProvider
import com.faire.faireshop.network.ServiceProvider
import kotlinx.coroutines.Dispatchers
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.bind
import org.koin.dsl.module

val mainModule = module {

    // can be named but we use only this one
    single { Dispatchers.IO }

    single { RetrofitServiceProvider() } bind ServiceProvider::class
    single { get<ServiceProvider>().provideService(ProductService::class.java) }
    single { ProductRepositoryImpl(get()) } bind ProductRepository::class
    single { GetProductsUseCase(get(), get()) }

    viewModelOf(::ProductListViewModel)
}