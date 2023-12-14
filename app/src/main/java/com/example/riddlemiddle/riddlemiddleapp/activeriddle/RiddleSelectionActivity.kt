package com.example.riddlemiddle.riddlemiddleapp.activeriddle

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material.icons.Icons
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.*
import androidx.navigation.NavController
import com.example.riddlemiddle.R
import com.example.riddlemiddle.apiService.model.Riddle
import com.example.riddlemiddle.riddlemiddleapp.firestore.service.Firestore
import androidx.compose.ui.Modifier as Modifier1


@Composable
fun RiddleSelectionac(service: Firestore, nav: NavController) {
    val riddles by remember {
        mutableStateOf(
            listOf(
                Riddle("Title 1", "Question 1", "Answer 1"),
                Riddle("Title 2", "Question 2", "Answer 2"),
                // Add more riddles as needed
            )
        )
    }

    GetListOfCards(riddles = riddles)
}


@Preview
@Composable
fun MyNewApp() {
    GetListOfCards()
}


@Composable
private fun GetListOfCards(
    modifier: Modifier1 = Modifier1,
    riddles: List<Riddle> = emptyList()
) {
    LazyColumn(modifier = modifier.padding(vertical = 4.dp)) {
        items(items = riddles) { riddle ->
            GetCard(riddle = riddle)
        }
    }
}

@Composable
private fun GetCard(riddle: Riddle) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primary
        ),
        modifier = Modifier1.padding(vertical = 4.dp, horizontal = 8.dp)
    ) {
        CardContent(riddle = riddle)
    }
}

@Composable
private fun CardContent(riddle: Riddle) {
    var expanded by remember { mutableStateOf(false) }

    Row(
        modifier = Modifier1
            .padding(12.dp)
            .animateContentSize(
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioMediumBouncy,
                    stiffness = Spring.StiffnessLow
                )
            )
    ) {
        Column(
            modifier = Modifier1
                .weight(1f)
                .padding(12.dp)
        ) {
            Text(text = riddle.title)
            Text(
                text = riddle.question, style = MaterialTheme.typography.headlineMedium.copy(
                    fontWeight = FontWeight.ExtraBold
                )
            )
            if (expanded) {
                Text(
                    text = riddle.answer
                )
            }
            Button(
                onClick = { expanded = !expanded },
                modifier = Modifier1.padding(top = 8.dp)
            ) {
                Text(text = "Show Answer")
            }
        }
        IconButton(onClick = { expanded = !expanded }) {
            Icon(
                imageVector = if (expanded) Icons.Filled.ExpandLess else Icons.Filled.ExpandMore,
                contentDescription = if (expanded) {
                    stringResource(R.string.show_less)
                } else {
                    stringResource(R.string.show_more)
                }
            )
        }
    }
}






/*
@Composable
private fun GetCard(name: String) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primary
        ),
        modifier = Modifier1.padding(vertical = 4.dp, horizontal = 8.dp)
    ) {
        CardContent(name)
    }
}

@Composable
private fun CardContent(name: String) {
    var expanded by remember { mutableStateOf(false) }

    Row(
        modifier = Modifier1
            .padding(12.dp)
            .animateContentSize(
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioMediumBouncy,
                    stiffness = Spring.StiffnessLow
                )
            )
    ) {
        Column(
            modifier = Modifier1
                .weight(1f)
                .padding(12.dp)
        ) {
            Text(text = "Hello, ")
            Text(
                text = name, style = MaterialTheme.typography.headlineMedium.copy(
                    fontWeight = FontWeight.ExtraBold
                )
            )
            if (expanded) {
                Text(
                    text = ("Composem ipsum color sit lazy, " +
                            "padding theme elit, sed do bouncy. ").repeat(4),
                )
            }
        }
        IconButton(onClick = { expanded = !expanded }) {
            Icon(
                imageVector = if (expanded) Icons.Filled.ExpandLess else Icons.Filled.ExpandMore,
                contentDescription = if (expanded) {
                    stringResource(R.string.show_less)
                } else {
                    stringResource(R.string.show_more)
                }
            )
        }
    }
}
*/
