package com.tkh.tech.recipeapp.recipe_feature.presentation.recipe_details.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.tkh.tech.recipeapp.recipe_feature.domain.model.ExtendedIngredient

@Composable
fun IngredientsList(ingredient: List<ExtendedIngredient>) {
    EasyGrid(
        nColumns = 3,
        items = ingredient
    ) {
        IngredientCard(it.image, it.name, it.amount.toString(), it.unit, Modifier)
    }

}