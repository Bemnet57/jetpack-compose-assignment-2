package com.example.todoapp.data.remote

data class TodoDto(
    val userId: Int,
    val id: Int,
    val title: String,
    val completed: Boolean
)
