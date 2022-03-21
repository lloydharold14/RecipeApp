package com.tkh.tech.recipeapp.recipe_feature.domain.use_case.recipe_search

import com.tkh.tech.recipeapp.recipe_feature.domain.model.Recipe
import com.tkh.tech.recipeapp.recipe_feature.domain.repository.RecipeRepository

class SearchRecipeUseCase(
    private val repository: RecipeRepository
) {

    suspend operator fun invoke(query: String): Result<List<Recipe>> {

        return repository.searchRecipe(query)
    }

}