package com.tkh.tech.recipeapp.recipe_feature.domain.model


data class RecipeDetails(

    val creditsText: String,
    val ingredients: List<ExtendedIngredient>,
    val healthScore: Double,
    val id: Int,
    val image: String,
    val imageType: String,
    val instructions: String,
    val readyInMinutes: Int,
    val servings: Int,
    val summary: String,
    val title: String,
)