package com.tkh.tech.recipeapp.recipe_feature.domain.use_case

import com.tkh.tech.recipeapp.recipe_feature.domain.use_case.recipe_details.CalculateIngredientPerServing
import com.tkh.tech.recipeapp.recipe_feature.domain.use_case.recipe_details.GetRecipeDetailsUseCase
import com.tkh.tech.recipeapp.recipe_feature.domain.use_case.recipe_search.SearchRecipeUseCase

data class RecipeUseCases(
    val searchRecipeUseCase: SearchRecipeUseCase,
    val getRecipeDetailsUseCase: GetRecipeDetailsUseCase,
    val calculateIngredientPerServing: CalculateIngredientPerServing
)