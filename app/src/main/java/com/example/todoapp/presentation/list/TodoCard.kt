package com.example.todoapp.presentation.list

// Inside com.example.todoapp.presentation.list or a shared UI package

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.todoapp.domain.model.Todo

@Composable
fun TodoCard(todo: Todo, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable { onClick() },
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = todo.title, style = MaterialTheme.typography.titleMedium)
            Text(text = if (todo.completed) "Completed" else "Pending")
        }
    }
}
