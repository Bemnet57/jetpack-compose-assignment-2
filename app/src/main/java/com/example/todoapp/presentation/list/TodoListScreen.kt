package com.example.todoapp.presentation.list

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.material3.Text
import androidx.compose.foundation.lazy.items
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.todoapp.presentation.list.TodoCard



@Composable
fun TodoListScreen(navController: NavController,
                   viewModel: TodoListViewModel = hiltViewModel()
) {
    val state = viewModel.state

    when {
        state.isLoading -> CircularProgressIndicator()
        state.error.isNotEmpty() -> Text("Error: ${state.error}")
        else -> LazyColumn {
            items(state.todos) { todo ->
                TodoCard(todo = todo) {
                    navController.navigate("detail/${todo.id}")
                }
            }
        }
    }
}
