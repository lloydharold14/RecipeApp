package com.tkh.tech.recipeapp.recipe_feature.data.remote.dto

data class SearchResponse(
    val number: Int,
    val offset: Int,
    val results: List<RecipeDto>,
    val totalResults: Int
)