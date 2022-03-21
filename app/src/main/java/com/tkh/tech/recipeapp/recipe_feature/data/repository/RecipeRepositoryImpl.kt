package com.tkh.tech.recipeapp.recipe_feature.data.repository

import com.tkh.tech.recipeapp.core.Constants
import com.tkh.tech.recipeapp.recipe_feature.data.remote.RecipeApi
import com.tkh.tech.recipeapp.recipe_feature.data.remote.dto.toRecipe
import com.tkh.tech.recipeapp.recipe_feature.data.remote.dto.toRecipeDetails
import com.tkh.tech.recipeapp.recipe_feature.domain.model.Recipe
import com.tkh.tech.recipeapp.recipe_feature.domain.model.RecipeDetails
import com.tkh.tech.recipeapp.recipe_feature.domain.repository.RecipeRepository

class RecipeRepositoryImpl(
    private val api: RecipeApi
) : RecipeRepository {
    override suspend fun searchRecipe(query: String): Result<List<Recipe>> {
        return try {
            val searchDto = api.searchRecipe(
                query = query,
                apiKey = Constants.API_KEY
            )
            Result.success(
                searchDto.results.map { it.toRecipe() }
            )
        } catch (e: Exception) {
            e.printStackTrace()
            Result.failure(e)
        }
    }

    override suspend fun getRecipedetails(id: Int): Result<RecipeDetails> {
        return try {
            val recipeDetailsDto = api.getRecipeDetails(
                id = id,
                apiKey = Constants.API_KEY
            )
            Result.success(
                recipeDetailsDto.toRecipeDetails()
            )
        } catch (e: Exception) {
            e.printStackTrace()
            Result.failure(e)
        }
    }
}