package com.example.todoapp.domain.model

import com.example.todoapp.data.local.TodoEntity
import com.example.todoapp.data.remote.TodoDto
// Domain model
data class Todo(
    val id: Int,
    val userId: Int,
    val title: String,
    val completed: Boolean
)

fun TodoDto.toEntity() = TodoEntity(id, userId, title, completed)
fun TodoEntity.toDomain() = Todo(id, userId, title, completed)
fun TodoDto.toDomain() = Todo(id, userId, title, completed)
