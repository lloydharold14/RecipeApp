package com.tkh.tech.recipeapp.recipe_feature.presentation.recipe_details


sealed class RecipeDetailsEvent {
    data class OnServingChange (val serving: Int) : RecipeDetailsEvent()
    object  OnFavoriteClick: RecipeDetailsEvent()
    object  OnBackClick: RecipeDetailsEvent()
    data class OnDetailsDisplay(val id:Int): RecipeDetailsEvent()
}