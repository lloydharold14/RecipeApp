package com.tkh.tech.recipeapp.recipe_feature.presentation.recipe_details.components

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.tkh.tech.recipeapp.recipe_feature.domain.model.RecipeDetails

@Composable
fun Description(summary: String) {
    Text(
        text = summary,
        fontWeight = FontWeight.Medium,
        modifier = Modifier.padding(horizontal = 16.dp, vertical = 16.dp)
    )
}