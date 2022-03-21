package com.tkh.tech.recipeapp.recipe_feature.di

import com.tkh.tech.recipeapp.core.Constants
import com.tkh.tech.recipeapp.recipe_feature.data.remote.RecipeApi
import com.tkh.tech.recipeapp.recipe_feature.data.repository.RecipeRepositoryImpl
import com.tkh.tech.recipeapp.recipe_feature.domain.repository.RecipeRepository
import com.tkh.tech.recipeapp.recipe_feature.domain.use_case.recipe_details.GetRecipeDetailsUseCase
import com.tkh.tech.recipeapp.recipe_feature.domain.use_case.RecipeUseCases
import com.tkh.tech.recipeapp.recipe_feature.domain.use_case.recipe_details.CalculateIngredientPerServing
import com.tkh.tech.recipeapp.recipe_feature.domain.use_case.recipe_search.SearchRecipeUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RecipeModule {

    @Provides
    @Singleton
    fun provideApi(): RecipeApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RecipeApi::class.java)
    }

    @Provides
    @Singleton
    fun provideRepository(api: RecipeApi): RecipeRepository {
        return RecipeRepositoryImpl(
            api = api
        )
    }

    @Provides
    @Singleton
    fun provideRecipeUseCases(repository: RecipeRepository): RecipeUseCases {
        return RecipeUseCases(
            searchRecipeUseCase = SearchRecipeUseCase(repository),
            getRecipeDetailsUseCase = GetRecipeDetailsUseCase(repository),
            calculateIngredientPerServing = CalculateIngredientPerServing()
        )
    }
}