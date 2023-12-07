package com.example.riddlemiddle

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.*
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.riddlemiddle.components.showListOfRiddles
import com.example.riddlemiddle.dataclasses.testListItem


class selectRiddleActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent{

        }
    }
}

@Composable
@Preview
fun PreviewListItem() {
    // Sample data for the preview
    val sampleListItem = testListItem("Preview Name", 123, "Preview Description")

    // Display the list item using the showListOfRiddles composable in the preview
    showListOfRiddles(sampleListItem)
}


@Composable
@Preview
fun ShowListOfRiddlesListPreview() {
    // Sample list of data for the preview
    val sampleList = listOf(
        testListItem("Preview Item 1", 101, "Preview Description 1"),
        testListItem("Preview Item 2", 102, "Preview Description 2"),
        testListItem("Preview Item 3", 103, "Preview Description 3")
        // Add more items as needed
    )

    // Display the list of items using the ShowListOfRiddlesList composable in the preview
    ShowListOfRiddlesList(sampleList)
}

@Composable
fun ShowListOfRiddlesList(items: List<testListItem>) {
    // Use LazyColumn to display a list of items
    LazyColumn {
        items(items) { item ->
            showListOfRiddles(item)
        }
    }
}


@Composable
@Preview
fun ShowListOfRiddlesColumnPreview() {
    // Sample list of data for the preview
    val sampleList = listOf(
        testListItem("Column Item 1", 201, "Column Description 1"),
        testListItem("Column Item 2", 202, "Column Description 2"),
        testListItem("Column Item 3", 203, "Column Description 3")
        // Add more items as needed
    )

    // Display the list of items using a Column in the preview
    Column {
        sampleList.forEach { item ->
            showListOfRiddles(item)
        }
    }
}

@Composable
@Preview
fun ShowListOfRiddlesDifferentStylePreview() {
    // Sample list of data for the preview
    val sampleList = listOf(
        testListItem("Style Item 1", 301, "Style Description 1"),
        testListItem("Style Item 2", 302, "Style Description 2"),
        testListItem("Style Item 3", 303, "Style Description 3")
        // Add more items as needed
    )

    // Display the list of items using a different style in the preview
    // Customize the style based on your requirements
    LazyColumn {
        items(sampleList) { item ->
            // Customize the item view style here
            showListOfRiddles(item)
        }
    }
}

@Composable
@Preview
fun ShowListOfRiddlesWithButtonsPreview() {
    // Sample list of data for the preview
    val sampleList = listOf(
        testListItem("Button Item 1", 401, "Button Description 1"),
        testListItem("Button Item 2", 402, "Button Description 2"),
        testListItem("Button Item 3", 403, "Button Description 3")
        // Add more items as needed
    )

    // Display the list of items with buttons in the preview
    LazyColumn {
        items(sampleList) { item ->
            // Each item has a button that shows a toast message when clicked
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                val context = LocalContext.current
                showListOfRiddles(item)
                Button(
                    onClick = {
                        // Show a toast message when the button is clicked
                        Toast.makeText(
                            /* context = */ context,
                            /* text = */ "Button Clicked for ${item.name}",
                            /* duration = */ Toast.LENGTH_SHORT
                        ).show()
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    Text(text = "Click me")
                }
            }
        }
    }
}