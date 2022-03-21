package com.tkh.tech.recipeapp.recipe_feature.data.remote.dto

import com.tkh.tech.recipeapp.recipe_feature.domain.model.ExtendedIngredient
import com.tkh.tech.recipeapp.recipe_feature.domain.model.RecipeDetails

data class RecipeDetailsDto(
    val aggregateLikes: Int,
    val analyzedInstructions: List<Any>,
    val cheap: Boolean,
    val creditsText: String,
    val cuisines: List<Any>,
    val dairyFree: Boolean,
    val diets: List<Any>,
    val dishTypes: List<String>,
    val extendedIngredients: List<ExtendedIngredient>,
    val gaps: String,
    val glutenFree: Boolean,
    val healthScore: Double,
    val id: Int,
    val image: String,
    val imageType: String,
    val instructions: String,
    val license: String,
    val lowFodmap: Boolean,
    val occasions: List<Any>,
    val originalId: Any,
    val pricePerServing: Double,
    val readyInMinutes: Int,
    val servings: Int,
    val sourceName: String,
    val sourceUrl: String,
    val spoonacularScore: Double,
    val spoonacularSourceUrl: String,
    val summary: String,
    val sustainable: Boolean,
    val title: String,
    val vegan: Boolean,
    val vegetarian: Boolean,
    val veryHealthy: Boolean,
    val veryPopular: Boolean,
    val weightWatcherSmartPoints: Int,
    val winePairing: WinePairing
)

fun RecipeDetailsDto.toRecipeDetails(

): RecipeDetails {
    return RecipeDetails(
        id = id,
        image = image,
        title = title,
        creditsText = creditsText,
        ingredients = extendedIngredients,
        healthScore = healthScore,
        imageType = imageType,
        instructions = instructions,
        readyInMinutes = readyInMinutes,
        servings = servings,
        summary = summary,
    )
}