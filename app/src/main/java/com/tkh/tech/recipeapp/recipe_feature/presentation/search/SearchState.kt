package com.tkh.tech.recipeapp.recipe_feature.presentation.search

import com.tkh.tech.recipeapp.recipe_feature.domain.model.Recipe

data class SearchState(

    val query: String = "",
    val isHintVisible: Boolean = false,
    val isSearching: Boolean = false,
    val recipeList: List<Recipe> = emptyList()
)