package com.tkh.tech.recipeapp.recipe_feature.data.remote.dto

import com.tkh.tech.recipeapp.recipe_feature.domain.model.Recipe

data class RecipeDto(
    val calories: Int,
    val carbs: String,
    val fat: String,
    val id: Int,
    val image: String,
    val imageType: String,
    val protein: String,
    val title: String
)

fun RecipeDto.toRecipe(

): Recipe {
    return Recipe(
        id = id,
        image = image,
        title = title
    )
}