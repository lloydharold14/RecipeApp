package com.tkh.tech.recipeapp.recipe_feature.presentation.search


sealed class SearchEvent {
    data class OnQueryChange(val query: String) : SearchEvent()
    object OnSearch : SearchEvent()
    data class OnRecipeClick(
        val id: Int
    ): SearchEvent()
    data class OnSearchFocusChange(val isFocused: Boolean): SearchEvent()
}