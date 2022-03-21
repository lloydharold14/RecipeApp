package com.tkh.tech.recipeapp.recipe_feature.presentation.recipe_details.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.tkh.tech.recipeapp.R
import com.tkh.tech.recipeapp.ui.theme.DarkGray
import com.tkh.tech.recipeapp.ui.theme.LightGray
import com.tkh.tech.recipeapp.ui.theme.Shapes

@Composable
fun IngredientCard(
    image: String?,
    title: String,
    subtitle: String,
    unit: String,
    modifier: Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.padding(bottom = 16.dp)
    ) {
        Card(
            shape = Shapes.large,
            elevation = 0.dp,
            backgroundColor = LightGray,
            modifier = Modifier
                .width(100.dp)
                .height(100.dp)
                .padding(bottom = 8.dp)
        ) {
            Image(
                painter = rememberImagePainter(
                    image,
                    builder = {
                        crossfade(true)
                        error(R.drawable.ic_breakfast)
                        fallback(R.drawable.ic_breakfast)
                    },


                    ),
                contentDescription = null,
                modifier = Modifier.padding(16.dp)
            )


        }
        Text(
            text = title,
            modifier = Modifier.width(100.dp),
            fontSize = 14.sp,
            fontWeight = FontWeight.Medium
        )
        Text(
            text = "$subtitle $unit",
            color = DarkGray,
            modifier = Modifier.width(100.dp),
            fontSize = 14.sp
        )
    }
}