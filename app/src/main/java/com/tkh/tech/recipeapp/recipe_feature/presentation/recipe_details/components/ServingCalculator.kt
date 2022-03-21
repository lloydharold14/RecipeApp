package com.tkh.tech.recipeapp.recipe_feature.presentation.recipe_details.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.tkh.tech.recipeapp.R
import com.tkh.tech.recipeapp.recipe_feature.presentation.recipe_details.RecipeDetailsEvent
import com.tkh.tech.recipeapp.recipe_feature.presentation.recipe_details.RecipeDetailsViewModel
import com.tkh.tech.recipeapp.ui.theme.LightGray
import com.tkh.tech.recipeapp.ui.theme.Pink
import com.tkh.tech.recipeapp.ui.theme.Shapes

@Composable
fun ServingCalculator(
    serving: Int,
    viewModel: RecipeDetailsViewModel
) {

    var value by remember { mutableStateOf(serving) }
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .clip(Shapes.medium)
            .background(LightGray)
            .padding(horizontal = 16.dp)
    ) {

        Text(text = "Serving", Modifier.weight(1f), fontWeight = FontWeight.Medium)
        CircularButton(
            iconResouce = R.drawable.ic_minus,
            elevation = null,
            color = Pink
        ) {
            if (value <= 1) {
                value = 1
                viewModel.onEvent(RecipeDetailsEvent.OnServingChange(value))
            } else {
                value--
                viewModel.onEvent(RecipeDetailsEvent.OnServingChange(value))
            }
        }
        Text(text = "$value", Modifier.padding(16.dp), fontWeight = FontWeight.Medium)
        CircularButton(iconResouce = R.drawable.ic_plus, elevation = null, color = Pink) {
            value++
            viewModel.onEvent(RecipeDetailsEvent.OnServingChange(value))
        }
    }
}