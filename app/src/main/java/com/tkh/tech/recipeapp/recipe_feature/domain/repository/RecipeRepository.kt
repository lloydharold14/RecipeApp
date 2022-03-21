package com.tkh.tech.recipeapp.recipe_feature.domain.repository

import com.tkh.tech.recipeapp.recipe_feature.domain.model.Recipe
import com.tkh.tech.recipeapp.recipe_feature.domain.model.RecipeDetails

interface RecipeRepository {

    suspend fun searchRecipe(query: String): Result<List<Recipe>>

    suspend fun getRecipedetails(id: Int): Result<RecipeDetails>
}