package com.example.todoapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraph
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.todoapp.presentation.navigation.TodoNavGraph // or com.example.todoapp.navigation.TodoNavGraph
import com.example.todoapp.presentation.list.TodoListScreen
import com.example.todoapp.presentation.detail.TodoDetailScreen
import com.example.todoapp.ui.theme.ToDoAppTheme

//@AndroidEntryPoint
//class MainActivity : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContent {
//            val navController = rememberNavController()
//            TodoNavGraph(navController = navController)
//        }
//
//    }
//}

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ToDoAppTheme {
                val navController = rememberNavController()

                NavHost(navController, startDestination = "list") {
                    composable("list") {
                        TodoListScreen(navController = navController)
                    }
                    composable("detail/{todoId}") { backStackEntry ->
                        val todoId = backStackEntry.arguments?.getString("todoId")?.toIntOrNull() ?: 0
                        TodoDetailScreen(todoId = todoId)
                    }
                }
            }
        }
    }
}
