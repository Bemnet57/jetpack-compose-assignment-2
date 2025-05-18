//package com.example.todoapp.data.local
//
//
//
//import androidx.room.Database
//import androidx.room.RoomDatabase
//
//@Database(
//    entities = [TodoEntity::class], // replace with your actual entity class
//    version = 1,
//    exportSchema = false
//)
//abstract class TodoDatabase : RoomDatabase() {
//    abstract fun todoDao(): TodoDao
//}
package com.example.todoapp.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [TodoEntity::class], // replace with your actual entity class
    version = 1,
    exportSchema = false
)
abstract class TodoDatabase : RoomDatabase() {
    abstract fun todoDao(): TodoDao

    companion object {
        @Volatile
        private var INSTANCE: TodoDatabase? = null

        fun getDatabase(context: Context): TodoDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    TodoDatabase::class.java,
                    "todo_database"
                ).fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}
