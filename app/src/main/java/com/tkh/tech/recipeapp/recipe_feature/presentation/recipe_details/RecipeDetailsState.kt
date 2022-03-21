package com.tkh.tech.recipeapp.recipe_feature.presentation.recipe_details

import com.tkh.tech.recipeapp.recipe_feature.domain.model.ExtendedIngredient

data class RecipeDetailsState(
    val id: Int? = null,
    val readyMinutes: Int = 0,
    val summary: String = "",
    val healthScore: Double = 0.0,
    val title: String = "",
    val image: String? = "",
    val creditText: String = "",
    val servingNumber: Int = 0,
    val ingredient: List<ExtendedIngredient> = emptyList(),
    val isFavorite: Boolean = false,
    val isLoading: Boolean = false,
    val error: String = ""
)