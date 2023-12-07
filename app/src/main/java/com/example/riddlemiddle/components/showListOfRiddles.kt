package com.example.riddlemiddle.components


import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Card
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import com.example.riddlemiddle.dataclasses.testListItem

@Composable
fun showListOfRiddles(listItemObj: testListItem){

    Row {
        Card {
            Text(listItemObj.name)
            Text(listItemObj.number.toString())
            Text(listItemObj.sicription)
            }
    }

}