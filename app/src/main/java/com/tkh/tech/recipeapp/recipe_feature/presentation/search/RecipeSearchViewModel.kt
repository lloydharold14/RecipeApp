package com.tkh.tech.recipeapp.recipe_feature.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tkh.tech.recipeapp.recipe_feature.domain.use_case.RecipeUseCases
import com.tkh.tech.recipeapp.recipe_feature.presentation.search.SearchEvent
import com.tkh.tech.recipeapp.recipe_feature.presentation.search.SearchState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RecipeSearchViewModel @Inject constructor(
    private val recipeUseCases: RecipeUseCases
) : ViewModel() {

    var state by mutableStateOf(SearchState())
        private set



    fun onEvent(event: SearchEvent) {

        when (event) {
            is SearchEvent.OnQueryChange -> {

                state = state.copy(query = event.query)
            }

            is SearchEvent.OnSearch -> {
                executeSearch()
            }

            is SearchEvent.OnSearchFocusChange -> {

                state = state.copy(
                    isHintVisible = !event.isFocused && state.query.isBlank()
                )
            }
        }
    }

    private fun executeSearch() {

        viewModelScope.launch {
            state = state.copy(
                isSearching = true,
                recipeList = emptyList(),

                )

            recipeUseCases.searchRecipeUseCase(state.query).onSuccess { recipe ->

                state = state.copy(
                    recipeList = recipe,
                    isSearching = false,
                    query = ""
                )
            }
                .onFailure {
                    state = state.copy(isSearching = false)

                }
        }
    }

}