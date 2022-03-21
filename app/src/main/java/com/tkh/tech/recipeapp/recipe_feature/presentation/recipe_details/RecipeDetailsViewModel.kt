package com.tkh.tech.recipeapp.recipe_feature.presentation.recipe_details

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tkh.tech.recipeapp.recipe_feature.domain.use_case.RecipeUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RecipeDetailsViewModel @Inject constructor(
    private val recipeUseCases: RecipeUseCases
) : ViewModel() {

    var state by mutableStateOf(RecipeDetailsState())
        private set

    init {
        state.id?.let {
            it
            state.id
            getRecipedetails(it)
        }
    }

    fun onEvent(event: RecipeDetailsEvent) {

        when (event) {
            is RecipeDetailsEvent.OnBackClick -> {

            }

            is RecipeDetailsEvent.OnFavoriteClick -> {

            }

            /*      is RecipeDetailsEvent.OnServingChange -> {
                      state = state.copy(
                          servingNumber = event.serving
                      )
                      val newINgredient = recipeUseCases.calculateIngredientPerServing(
                          state.servingNumber,
                          state.ingredient
                      )

                      state = state.copy(
                          ingredient = newINgredient
                      )


                  }*/

            is RecipeDetailsEvent.OnDetailsDisplay -> {
                state = state.copy(
                    id = event.id
                )
                state.id?.let {
                    it
                    state.id
                    getRecipedetails(it)
                }

            }
        }
    }

    fun getRecipedetails(id: Int) {

        viewModelScope.launch {
            recipeUseCases.getRecipeDetailsUseCase(id).onSuccess { recipe ->
                state = state.copy(
                    healthScore = recipe.healthScore,
                    summary = recipe.summary,
                    creditText = recipe.creditsText,
                    title = recipe.title,
                    image = recipe.image,
                    servingNumber = recipe.servings,
                    readyMinutes = recipe.readyInMinutes,
                    ingredient = recipe.ingredients,
                    isLoading = false,
                    error = ""
                )
            }
                .onFailure {
                    state = state.copy(
                        isLoading = false,
                        ingredient = emptyList(),
                        error = "An unexpected error occured"
                    )
                }

        }
    }


}