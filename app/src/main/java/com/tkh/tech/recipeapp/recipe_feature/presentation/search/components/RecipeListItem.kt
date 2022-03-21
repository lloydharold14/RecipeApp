package com.tkh.tech.recipeapp.recipe_feature.presentation.search.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Cyan
import androidx.compose.ui.graphics.Color.Companion.LightGray
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.tkh.tech.recipeapp.R
import com.tkh.tech.recipeapp.core.LocalSpacing
import com.tkh.tech.recipeapp.recipe_feature.domain.model.Recipe
import com.tkh.tech.recipeapp.ui.theme.Shapes
import kotlin.concurrent.fixedRateTimer

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun RecipeListItem(
    recipe: Recipe,
    onItemClick: (Recipe) -> Unit
) {
    val spacing = LocalSpacing.current


        Row(

            modifier = Modifier
                .fillMaxWidth()
                .clickable { onItemClick(recipe) }
                .padding(spacing.spaceMedium),

            ) {

            Image(
                painter = rememberImagePainter(
                    recipe.image,
                    builder = {
                        crossfade(true)
                        error(R.drawable.ic_breakfast)
                        fallback(R.drawable.ic_breakfast)
                    },


                    ),
                contentDescription = null,

                modifier = Modifier.size(50.dp)
                    .fillMaxHeight()
            )
            Text(
                text = recipe.title,
                style = MaterialTheme.typography.body1,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .padding(start = 15.dp)
            )
        }



}