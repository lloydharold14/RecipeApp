package com.tkh.tech.recipeapp.recipe_feature.domain.use_case.recipe_details

import com.tkh.tech.recipeapp.recipe_feature.domain.model.RecipeDetails
import com.tkh.tech.recipeapp.recipe_feature.domain.repository.RecipeRepository

class GetRecipeDetailsUseCase(
    private val repository: RecipeRepository
) {

    suspend operator fun invoke(id: Int): Result<RecipeDetails> {

        return repository.getRecipedetails(id)
    }

}