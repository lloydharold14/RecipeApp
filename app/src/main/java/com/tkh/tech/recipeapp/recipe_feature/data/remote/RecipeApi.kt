package com.tkh.tech.recipeapp.recipe_feature.data.remote

import com.tkh.tech.recipeapp.recipe_feature.data.remote.dto.RecipeDetailsDto
import com.tkh.tech.recipeapp.recipe_feature.data.remote.dto.SearchResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RecipeApi {

    @GET("recipes/complexSearch?/")
    suspend fun searchRecipe(
        @Query("query") query: String,
        @Query("apiKey") apiKey: String
    ): SearchResponse

    @GET("recipes/{recipeId}/information?includeNutrition=false")
    suspend fun getRecipeDetails(
        @Path("recipeId") id: Int,
        @Query("apiKey") apiKey: String
    ): RecipeDetailsDto

}