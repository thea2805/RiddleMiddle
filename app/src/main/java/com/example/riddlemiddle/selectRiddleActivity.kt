package com.example.riddlemiddle

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
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