package com.tkh.tech.recipeapp.recipe_feature.presentation.recipe_details.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.DarkGray
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.tkh.tech.recipeapp.R
import com.tkh.tech.recipeapp.recipe_feature.domain.model.RecipeDetails
import com.tkh.tech.recipeapp.ui.theme.Pink

@Composable
fun Reviews(creditsText: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column {
            Text(text = "Reviews", fontWeight = FontWeight.Bold)
            Text(creditsText, color = DarkGray)
        }
       /* Button(
            onClick = { *//*TODO*//* }, elevation = null, colors = ButtonDefaults.buttonColors(
                backgroundColor = Transparent, contentColor = Pink
            )
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text("See all")
                Icon(
                    painter = painterResource(id = R.drawable.ic_arrow_right),
                    contentDescription = null
                )
            }
        }*/
    }
}