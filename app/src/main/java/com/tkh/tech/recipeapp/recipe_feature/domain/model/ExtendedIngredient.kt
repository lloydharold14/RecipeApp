package com.tkh.tech.recipeapp.recipe_feature.domain.model

data class ExtendedIngredient(
    val aisle: String,
    var amount: Double,
    val consistency: String,
    val id: Int,
    val image: String?,
    val meta: List<String>,
    val name: String,
    val nameClean: String,
    val original: String,
    val originalName: String,
    val unit: String
)