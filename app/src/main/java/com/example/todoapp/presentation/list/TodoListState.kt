package com.example.todoapp.presentation.list

import com.example.todoapp.data.local.TodoEntity
import com.example.todoapp.domain.model.Todo

//data class TodoListState(
//    val todos: List<Todo> = emptyList(),
//    val isLoading: Boolean = false,
//    val error: String = ""
//)

data class TodoListState(
    val todos: List<Todo> = emptyList(),
    val isLoading: Boolean = false,
    val error: String = ""
)
// val todos: List<TodoEntity> = emptyList(),