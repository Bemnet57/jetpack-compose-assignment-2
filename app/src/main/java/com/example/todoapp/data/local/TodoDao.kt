//package com.example.todoapp.data.local
//
//import androidx.room.Dao
//import androidx.room.Insert
//import androidx.room.OnConflictStrategy
//import androidx.room.Query
//
//@Dao
//interface TodoDao {
//    @Query("SELECT * FROM todos")
//    suspend fun getAllTodos(): List<TodoEntity>
//
//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    suspend fun insertAll(todos: List<TodoEntity>)
//
//    @Query("SELECT * FROM todoentity WHERE id = :id")
//    suspend fun getTodoById(id: Int): TodoEntity // added to correct repository
//}

//package com.example.todoapp.data.local
//
//import androidx.room.Dao
//import androidx.room.Insert
//import androidx.room.OnConflictStrategy
//import androidx.room.Query
//
//@Dao
//interface TodoDao {
//
//    @Query("SELECT * FROM todos")
//    suspend fun getAllTodos(): List<TodoEntity>
//
//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    suspend fun insertAll(todos: List<TodoEntity>)
//
//    @Query("SELECT * FROM todos WHERE id = :id")
//    suspend fun getTodoById(id: Int): TodoEntity
//}

package com.example.todoapp.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Delete
import androidx.room.Update

@Dao
interface TodoDao {

    @Query("SELECT * FROM todos")
    suspend fun getAllTodos(): List<TodoEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(todos: List<TodoEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTodo(todo: TodoEntity)

    @Update
    suspend fun updateTodo(todo: TodoEntity)

    @Delete
    suspend fun deleteTodo(todo: TodoEntity)

    @Query("SELECT * FROM todos WHERE id = :id")
    suspend fun getTodoById(id: Int): TodoEntity
}
