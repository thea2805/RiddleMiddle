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
fun JokeSelectionac(service: Firestore, nav: NavController) {
    val riddles by remember {
        mutableStateOf(
            listOf(
                Riddle("01 TheMathBook", "Why did the math book look so sad?",
                    "because it had too many problems" +
                            "\n(directly taken from: https://www.mindyourlogic.com/logical-jokes) in 14-12-2023"),

                Riddle("02 Math", "Why do mathematicians love parks? ",
                    "Because of all the natural logs" +
                            "\n(directly taken from: https://www.mindyourlogic.com/logical-jokes) in 14-12-2023"),
                Riddle("03 Invention", "people don't like the person who invented 0. why? ",
                    "Because they invented Nothing!" +
                            ""),
                Riddle("05 Phisics", "what keeps me grounded?",
                    "Gravity" ),
                Riddle("06 Trick", "Who is always there for you when you fall?",
                    "the floor" ),
                Riddle("07 Trick", "What happeneds to a coal miner during the winter?",
                    "They get coal'ed " ),
                Riddle("08 Trick", "what do you do with your hands full?",
                    "you put them down and live the rest of your life." ),
                Riddle("09 Trick", "what do you do with your hands full?",
                    "you put them down and live the rest of your life." ),
                Riddle("10 Trick", "how do catch a mouse?",
                    "you make sure it is not wireless" ),
                Riddle("11 Trick", "What falls but never breaks, and what breaks but never falls? ",
                    "Nightfall and daybreak" ),
                Riddle("12 Trick", "What word begins with e, ends with e, and contains one letter, but is not the letter e? ",
                    "Envelope" ),
                Riddle("13 Trick", "You have a square house. All 4 walls face South. A bear steps in your front yard. What color is the bear?",
                    "White. Noeth Pole. Polar bear" ),
                Riddle("14 Trick", "A man is sitting in a chair. The chair is in a cabin. The cabin is in the woods. How did the man die?",
                    "Airplane crash" ),
                Riddle("15 Trick", "What starts and ends with T, and is filled with T?",
                    "Teapot" ),

                // Add more riddles as needed
            )
        )
    }

    GetListOfCards(riddles = riddles)
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
