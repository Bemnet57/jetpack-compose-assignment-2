package com.example.todoapp.data.mapper

import com.example.todoapp.data.local.TodoEntity
import com.example.todoapp.data.remote.TodoDto
import com.example.todoapp.domain.model.Todo

fun TodoDto.toEntity(): TodoEntity {
    return TodoEntity(
        id = this.id,
        userId = this.userId,
        title = this.title,
        completed = this.completed
    )
}

fun TodoEntity.toDomain(): Todo {
    return Todo(
        id = this.id,
        userId = this.userId,
        title = this.title,
        completed = this.completed
    )
}

fun Todo.toEntity(): TodoEntity {
    return TodoEntity(
        id = this.id,
        userId = this.userId,
        title = this.title,
        completed = this.completed
    )
}
