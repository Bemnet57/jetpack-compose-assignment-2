package com.example.todoapp.di



import android.app.Application
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.todoapp.data.local.TodoDao
import com.example.todoapp.data.local.TodoDatabase
import com.example.todoapp.data.local.TodoEntity
import com.example.todoapp.data.remote.TodoApi
import com.example.todoapp.data.repository.TodoRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideTodoApi(): TodoApi {
        return Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/") // Make sure it matches your usage
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(TodoApi::class.java)
    }

//    @Provides
//    @Singleton
//    fun provideDatabase(app: Application): TodoDatabase {
//        return Room.databaseBuilder(
//            app,
//            TodoDatabase::class.java,
//            "todo_db"
//        ).build()
//    }

    @Provides
    @Singleton
    fun provideDatabase(app: Application): TodoDatabase {
        return Room.databaseBuilder(
            app,
            TodoDatabase::class.java,
            "todo_db"
        )
            .addCallback(object : RoomDatabase.Callback() {
                override fun onCreate(db: SupportSQLiteDatabase) {
                    super.onCreate(db)
                    // Insert sample data on a background thread
                    CoroutineScope(Dispatchers.IO).launch {
                        val dao = provideDatabase(app).todoDao()
                        dao.insertTodo(TodoEntity(1, 1, "Test Task 1", false))
                        dao.insertTodo(TodoEntity(2, 1, "Test Task 2", true))
                        dao.insertTodo(TodoEntity(3, 1, "Test Task 1", false))
                        dao.insertTodo(TodoEntity(4, 1, "Test Task 2", true))
                    }
                }
            })
            .build()
    }

    @Provides
    fun provideTodoDao(database: TodoDatabase): TodoDao {
        return database.todoDao()
    }

    @Provides
    fun provideTodoRepository(todoDao: TodoDao): TodoRepository {
        return TodoRepository(todoDao)
    }

//    @Provides
//    @Singleton
//    fun provideTodoRepository(
//        todoApi: TodoApi,
//        todoDao: TodoDao
//    ): TodoRepository {
//        return TodoRepositoryImpl(todoApi, todoDao)
//    }

}
