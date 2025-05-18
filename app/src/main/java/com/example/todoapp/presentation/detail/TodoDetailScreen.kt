//package com.example.todoapp.presentation.detail

//import androidx.compose.foundation.layout.Column
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
////import com.example.todoapp.presentation.detail.TodoDetailScreen
//import com.example.todoapp.presentation.detail.TodoDetailViewModel
//
//@Composable
//fun TodoDetailScreen(todoId: Int, viewModel: TodoDetailViewModel) {
//    val todo = viewModel.getTodoById(todoId)
//    todo?.let {
//        Column {
//            Text("Title: ${it.title}")
//            Text("Status: ${if (it.completed) "Completed" else "Pending"}")
//            // Add back button
//        }
//    }
//}

package com.example.todoapp.presentation.detail


import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun TodoDetailScreen(
    todoId: Int,
    viewModel: TodoDetailViewModel = hiltViewModel() // don't pass view model and use hiltmodel at the same time
) {
    // Trigger load once
    LaunchedEffect(todoId) {
        viewModel.loadTodoById(todoId)
    }

    val todo by viewModel.todo.collectAsState()

    todo?.let {
        Column {
            Text("Title: ${it.title}")
            Text("Status: ${if (it.completed) "Completed" else "Pending"}")
        }
    } ?: Text("Loading...")
}

