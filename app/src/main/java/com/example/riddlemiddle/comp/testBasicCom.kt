package com.example.riddlemiddle.comp

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun testComItem(basicCom: baisccomponent, onClick: () -> Unit){
    Column {
        Text(text = basicCom.data)
        Button(onClick = onClick) {
            Text(text = basicCom.btnName);
            Text(text = basicCom.dataNum.toString());
        }
    }
}

