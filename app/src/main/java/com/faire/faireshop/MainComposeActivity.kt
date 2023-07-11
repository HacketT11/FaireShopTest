package com.faire.faireshop

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.faire.faireshop.features.products.ProductListScreen
import com.faire.faireshop.ui.theme.FaireShopTheme
import org.koin.androidx.viewmodel.ext.android.getViewModel

class MainComposeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FaireShopTheme {
                ProductListScreen(getViewModel())
            }
        }
    }
}