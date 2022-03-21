package com.tkh.tech.recipeapp.recipe_feature.presentation.recipe_details.components

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.tkh.tech.recipeapp.ui.theme.LightGray
import com.tkh.tech.recipeapp.ui.theme.Shapes

@Composable
fun IngredientsHeader() {


    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column {
            Text(text = "Ingredients", fontWeight = FontWeight.Bold)
        }
}
}

