package com.faire.faireshop.features.products.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage
import com.faire.faireshop.data.product.models.Product
import com.faire.faireshop.ui.theme.FaireShopTheme
import com.faire.faireshop.ui.theme.dp1
import com.faire.faireshop.ui.theme.dp24
import com.faire.faireshop.ui.theme.dp64
import com.faire.faireshop.ui.theme.dp8

@Composable
fun ProductItemComponent(product: Product) {
    Column {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            AsyncImage(
                model = product.image,
                contentDescription = null,
                modifier = Modifier
                    .size(dp64).padding(dp8),
                contentScale = ContentScale.Crop
            )
            Column(
                modifier = Modifier
                    .weight(1f)
            ) {
                Text(
                    text = product.name,
                    style = MaterialTheme.typography.h6,
                    fontWeight = FontWeight.Bold,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier.padding(start = dp8, top = dp8)
                )
                Text(
                    text = product.description,
                    modifier = Modifier.padding(dp8)
                )
            }
            Text(
                text = product.price,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(end = dp8)
            )
        }
        Divider(
            color = MaterialTheme.colors.onSurface,
            thickness = dp1,
            modifier = Modifier.padding(top = dp24, start = dp8, end = dp8)
        )
    }
}

@Composable
@Preview
private fun ProductItemComponentPreview() {
    FaireShopTheme {
        ProductItemComponent(
            Product(
                "",
                "Name",
                "Description",
                "5$",
                "https://cdn.faire.com/res/hszgttpjt/image/upload/5c70d91680e2d7846418e34ce494732505628738c249bda6477cb9651d7ba2c4/1519826013.jpg"
            )
        )
    }
}