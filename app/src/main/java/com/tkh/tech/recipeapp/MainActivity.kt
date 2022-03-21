package com.tkh.tech.recipeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.tkh.tech.recipeapp.core.Screen
import com.tkh.tech.recipeapp.recipe_feature.presentation.recipe_details.RecipeDetailsScreen
import com.tkh.tech.recipeapp.recipe_feature.presentation.search.SearchRecipeScreen
import com.tkh.tech.recipeapp.ui.theme.RecipeAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RecipeAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Screen.RecipeSearchScreen.route
                    ) {
                        composable(
                            route = Screen.RecipeSearchScreen.route
                        ) {
                            SearchRecipeScreen(navController)
                        }
                        composable(
                            route = Screen.RecipeDetailsScreen.route + "/{recipeId}",
                            arguments = listOf(
                                navArgument("recipeId") {
                                    type = NavType.IntType
                                })
                        ) {
                            val id = it.arguments?.getInt("recipeId")!!
                            RecipeDetailsScreen(id, navController)
                        }
                    }
                }
            }
        }
    }
}

