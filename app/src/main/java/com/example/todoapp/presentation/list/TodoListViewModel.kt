package com.example.todoapp.presentation.list

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
//import com.example.todoapp.TodoListState
import com.example.todoapp.data.repository.TodoRepository
import kotlinx.coroutines.launch
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.todoapp.data.local.TodoEntity
import com.example.todoapp.domain.model.toDomain
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import com.example.todoapp.presentation.list.TodoListState

//@HiltViewModel
//class TodoListViewModel @Inject constructor(
//    private val repository: TodoRepository
//) : ViewModel() {
//    var state by mutableStateOf(TodoListState())
//        private set
//
//    init {
//        loadTodos()
//    }
//
//    private fun loadTodos() {
//        viewModelScope.launch {
//            state = state.copy(isLoading = true)
//            try {
//                val todos = repository.getTodos()
//                state = state.copy(todos = todos, isLoading = false)
//            } catch (e: Exception) {
//                state = state.copy(error = e.message ?: "Error", isLoading = false)
//            }
//        }
//    }
//}

//@HiltViewModel
//class TodoListViewModel @Inject constructor(
//    private val repository: TodoRepository
//) : ViewModel() {
//
//    private val _todoList = MutableLiveData<List<TodoEntity>>()
//    val todoList: LiveData<List<TodoEntity>> = _todoList
//
//    fun loadTodos() {
//        viewModelScope.launch {
//            _todoList.value = repository.getTodos()
//        }
//    }
//}
@HiltViewModel
class TodoListViewModel @Inject constructor(
    private val repository: TodoRepository
) : ViewModel() {

    var state by mutableStateOf(TodoListState())
        private set

    init {
        loadTodos()
    }

    fun loadTodos() {
        viewModelScope.launch {
            state = state.copy(isLoading = true)
            try {
                val todos = repository.getTodos().map { it.toDomain() }
                state = state.copy(todos = todos, isLoading = false)
            } catch (e: Exception) {
                state = state.copy(error = e.message ?: "Unknown error", isLoading = false)
            }
        }
    }
}



//class TodoListViewModel(private val repository: TodoRepository) : ViewModel() {
//    var state by mutableStateOf(TodoListState())
//
//    init {
//        loadTodos()
//    }
//
//    private fun loadTodos() {
//        viewModelScope.launch {
//            state = state.copy(isLoading = true)
//            try {
//                val todos = repository.getTodos()
//                state = state.copy(todos = todos, isLoading = false)
//            } catch (e: Exception) {
//                state = state.copy(error = e.message ?: "Error", isLoading = false)
//            }
//        }
//    }
//}
