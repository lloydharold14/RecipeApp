package com.tkh.tech.recipeapp.core

sealed class Screen(val route: String) {
    object RecipeSearchScreen: Screen("recipe_search_Screen")
    object RecipeDetailsScreen: Screen("recipe_details_Screen")
}
