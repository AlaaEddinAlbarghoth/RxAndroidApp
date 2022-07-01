package com.alaaeddinalbarghoth.rxandroidapp.activities.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.alaaeddinalbarghoth.rxandroidapp.data.model.Repo


@Composable
fun ListCompose(list: List<Repo>) {
    LazyColumn(
        Modifier
            .padding(16.dp)
            .fillMaxSize()
    ) {
        items(list) { item ->
            Column(
                Modifier
                    .padding(16.dp)
            ) {
                Text(text = "Name: ${item.name}")
                Text(text = "Description: ${item.description}")
                Text(text = "Language: ${item.language}")
            }
        }
    }
}
