package com.tkh.tech.recipeapp.recipe_feature.domain.use_case.recipe_details

import android.util.Log
import com.tkh.tech.recipeapp.recipe_feature.domain.model.ExtendedIngredient

class CalculateIngredientPerServing(

) {

    operator fun invoke(serving: Int, ingredients: List<ExtendedIngredient>): List<ExtendedIngredient> {

        ingredients.forEach {
            it.amount = it.amount * serving
            Log.d("IngredientAmount", it.amount.toString())
        }

        return ingredients
    }

}
