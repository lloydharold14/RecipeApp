package com.tkh.tech.recipeapp.recipe_feature.data.remote.dto

data class WinePairing(
    val pairedWines: List<Any>,
    val pairingText: String,
    val productMatches: List<Any>
)