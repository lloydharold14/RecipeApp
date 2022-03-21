package com.tkh.tech.recipeapp.recipe_feature.presentation.recipe_details.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.tkh.tech.recipeapp.R
import com.tkh.tech.recipeapp.recipe_feature.domain.model.RecipeDetails

@Composable
fun BasicInfo(readyInMinutes: Int, healthScore: Double) {
    Row(
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp)
    ) {
        InfoColumn(R.drawable.ic_clock, "${readyInMinutes}min")
        //InfoColumn(R.drawable.ic_flame, recipe.energy)
        InfoColumn(R.drawable.ic_star, "${healthScore}%")
    }
}