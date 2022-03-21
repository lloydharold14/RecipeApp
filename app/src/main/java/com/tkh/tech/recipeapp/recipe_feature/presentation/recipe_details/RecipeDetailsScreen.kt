package com.tkh.tech.recipeapp.recipe_feature.presentation.recipe_details

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.tkh.tech.recipeapp.recipe_feature.presentation.recipe_details.components.*
import com.tkh.tech.recipeapp.ui.AppBarExpendedHeight
import com.tkhtech.core.util.UiEvent

@Composable
fun RecipeDetailsScreen(
    id: Int,
    navController: NavController,
    viewModel: RecipeDetailsViewModel = hiltViewModel()
) {


    val state = viewModel.state

    viewModel.onEvent(RecipeDetailsEvent.OnDetailsDisplay(id))
    viewModel.getRecipedetails(id)
    val scrollState = rememberLazyListState()



    Box {
        LazyColumn(
            contentPadding = PaddingValues(top = AppBarExpendedHeight),
            state = scrollState
        ) {
            item {
                BasicInfo(state.readyMinutes, state.healthScore)
                Description(state.summary)
                /*ServingCalculator(state.servingNumber, viewModel)*/
                IngredientsHeader()
                IngredientsList(state.ingredient)
                Reviews(state.creditText)
            }
        }
        ParallaxToolbar(state.image, state.title, scrollState)
    }


}