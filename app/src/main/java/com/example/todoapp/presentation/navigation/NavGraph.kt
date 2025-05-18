package com.example.todoapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.todoapp.presentation.list.TodoListScreen
import com.example.todoapp.presentation.detail.TodoDetailScreen
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.example.todoapp.presentation.detail.TodoDetailScreen
import com.example.todoapp.presentation.detail.TodoDetailViewModel
import com.example.todoapp.presentation.list.TodoListScreen
import com.example.todoapp.presentation.list.TodoListViewModel

//@Composable
//fun NavGraph(navController: NavHostController) {
//    NavHost(navController = navController, startDestination = "list") {
//        composable("list") {
//            TodoListScreen(navController)
//        }
//        composable(
//            "detail/{todoId}",
//            arguments = listOf(navArgument("todoId") { type = NavType.IntType })
//        ) {
//            val todoId = it.arguments?.getInt("todoId") ?: return@composable
//            TodoDetailScreen(todoId)
//        }
//    }
//}
//@Composable
//fun NavGraph(navController: NavHostController) {
//    NavHost(
//        navController = navController,
//        startDestination = "list"
//    ) {
//        composable("list") {
//            TodoListScreen(navController)
//        }
//        composable(
//            "detail/{todoId}",
//            arguments = listOf(navArgument("todoId") { type = NavType.IntType })
//        ) {
//            val todoId = it.arguments?.getInt("todoId") ?: return@composable
//            TodoDetailScreen(todoId)
//        }
//    }
//}
//@Composable
//fun NavGraph(navController: NavHostController) {
//    NavHost(
//        navController = navController,
//        startDestination = "list"
//    ) {
//        composable("list") {
//            TodoListScreen(navController)
//        }
//        composable(
//            "detail/{todoId}",
//            arguments = listOf(navArgument("todoId") { type = NavType.IntType })
//        ) {
//            val todoId = it.arguments?.getInt("todoId") ?: return@composable
//            TodoDetailScreen(todoId)
//        }
//    }
//}
@Composable
fun TodoNavGraph(navController: NavHostController) {
    NavHost(navController, startDestination = "list") {
        composable("list") {
            val viewModel: TodoListViewModel = hiltViewModel()
            TodoListScreen(navController, viewModel)
        }
        composable(
            "detail/{todoId}",
            arguments = listOf(navArgument("todoId") { type = NavType.IntType })
        ) {
            val todoId = it.arguments?.getInt("todoId") ?: return@composable
            val detailViewModel: TodoDetailViewModel = hiltViewModel() //val viewModel: TodoDetailViewModel = hiltViewModel()
            TodoDetailScreen(todoId = todoId, viewModel = detailViewModel)
        }

    }
}

