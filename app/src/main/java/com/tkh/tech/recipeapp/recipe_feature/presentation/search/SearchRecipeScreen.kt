package com.tkh.tech.recipeapp.recipe_feature.presentation.search

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.tkh.tech.recipeapp.R
import com.tkh.tech.recipeapp.core.LocalSpacing
import com.tkh.tech.recipeapp.core.Screen
import com.tkh.tech.recipeapp.recipe_feature.presentation.RecipeSearchViewModel
import com.tkh.tech.recipeapp.recipe_feature.presentation.search.components.RecipeListItem
import com.tkh.tech.recipeapp.recipe_feature.presentation.search.components.SearchTextField

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun SearchRecipeScreen(
    navController: NavController,
    viewModel: RecipeSearchViewModel = hiltViewModel()
) {

    val spacing = LocalSpacing.current
    val state = viewModel.state
    val keyboardController = LocalSoftwareKeyboardController.current


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(spacing.spaceSmall)
    ) {
        Text(
            text = stringResource(id = R.string.search_recipe),
            style = MaterialTheme.typography.h3,

        )
        Spacer(modifier = Modifier.height(spacing.spaceMedium))

        SearchTextField(
            text = state.query,
            onValueChange = {
                viewModel.onEvent(SearchEvent.OnQueryChange(it))
            },
            shouldShowHint = state.isHintVisible,
            onSearch = {
                keyboardController?.hide()
                viewModel.onEvent(SearchEvent.OnSearch)
            },
            onFocusChanged = {
                viewModel.onEvent(SearchEvent.OnSearchFocusChange(it.isFocused))
            }
        )
        Spacer(modifier = Modifier.height(spacing.spaceMedium))

        LazyColumn(modifier = Modifier.fillMaxSize()) {

            items(state.recipeList) { recipe ->

                RecipeListItem(
                    recipe = recipe,
                    onItemClick = {
                        navController.navigate(Screen.RecipeDetailsScreen.route + "/${recipe.id}")
                    }
                )

            }

        }
    }
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        when {
            state.isSearching -> CircularProgressIndicator()
            state.recipeList.isEmpty() -> {
                Text(
                    text = stringResource(id = R.string.no_results),
                    style = MaterialTheme.typography.body1,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}