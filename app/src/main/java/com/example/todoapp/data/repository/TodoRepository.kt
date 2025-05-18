package com.example.todoapp.data.repository

import com.example.todoapp.data.local.TodoDao
import com.example.todoapp.data.local.TodoEntity
import com.example.todoapp.data.remote.TodoApi
import com.example.todoapp.data.mapper.toEntity
import com.example.todoapp.data.mapper.toDomain
import com.example.todoapp.domain.model.Todo
import javax.inject.Inject


//class TodoRepository @Inject constructor(
//    private val api: TodoApi,
//    private val dao: TodoDao
//) {
//    suspend fun getTodos(): List<Todo> {
//        return try {
//            val remoteTodos = api.getTodos()
//            val entities = remoteTodos.map { it.toEntity() }
//            dao.insertAll(entities)
//            entities.map { it.toDomain() }
//        } catch (e: Exception) {
//            dao.getAllTodos().map { it.toDomain() }
//        }
//    }
//    suspend fun getTodoById(id: Int): Todo {
//        val entity = dao.getTodoById(id) // Make sure this function exists in your Dao
//        return entity.toDomain()
//    }
//
//
//}
class TodoRepository @Inject constructor(
    private val todoDao: TodoDao
) {
//    suspend fun getTodos(): List<TodoEntity> = todoDao.getTodos()
    suspend fun getTodos(): List<TodoEntity> = todoDao.getAllTodos()
    suspend fun getTodoById(id: Int): TodoEntity? = todoDao.getTodoById(id)
    suspend fun insertTodo(todo: TodoEntity) = todoDao.insertTodo(todo)
    suspend fun updateTodo(todo: TodoEntity) = todoDao.updateTodo(todo)
    suspend fun deleteTodo(todo: TodoEntity) = todoDao.deleteTodo(todo)
}

