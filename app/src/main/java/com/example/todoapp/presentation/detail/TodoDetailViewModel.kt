//package com.example.todoapp.presentation.detail



//import androidx.compose.runtime.*
//import androidx.lifecycle.ViewModel
//import androidx.lifecycle.viewModelScope
//import com.example.todoapp.data.repository.TodoRepository
//import com.example.todoapp.domain.model.Todo
//import dagger.hilt.android.lifecycle.HiltViewModel
//import kotlinx.coroutines.launch
//import javax.inject.Inject
//
//@HiltViewModel
//class TodoDetailViewModel @Inject constructor(
//    private val repository: TodoRepository
//) : ViewModel() {
//
//    var todo by mutableStateOf<Todo?>(null)
//        private set
//
//    var isLoading by mutableStateOf(false)
//        private set
//
//    var error by mutableStateOf("")
//        private set
//
//    fun loadTodoById(id: Int) {
//        viewModelScope.launch {
//            isLoading = true
//            try {
//                val todos = repository.getTodos()
//                todo = todos.find { it.id == id }
//            } catch (e: Exception) {
//                error = e.message ?: "Unknown Error"
//            } finally {
//                isLoading = false
//            }
//        }
//    }
//}

package com.example.todoapp.presentation.detail


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todoapp.data.local.TodoEntity
import com.example.todoapp.data.repository.TodoRepository
import com.example.todoapp.domain.model.Todo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

//@HiltViewModel
//class TodoDetailViewModel @Inject constructor(
//    private val repository: TodoRepository
//) : ViewModel() {
//
//    private val _todo = MutableStateFlow<Todo?>(null)
//    val todo: StateFlow<Todo?> = _todo
//
//    fun loadTodoById(id: Int) {
//        viewModelScope.launch {
//            _todo.value = repository.getTodoById(id)
//        }
//    }
//}

//@HiltViewModel
//class TodoDetailViewModel @Inject constructor(
//    private val repository: TodoRepository
//) : ViewModel() {
//
//    private val _todo = MutableLiveData<TodoEntity?>()
//    val todo: LiveData<TodoEntity?> = _todo
//
//    fun loadTodo(id: Int) {
//        viewModelScope.launch {
//            _todo.value = repository.getTodoById(id)
//        }
//    }
//}

@HiltViewModel
class TodoDetailViewModel @Inject constructor(
    private val repository: TodoRepository
) : ViewModel() {

    private val _todo = MutableStateFlow<TodoEntity?>(null)
    val todo: StateFlow<TodoEntity?> = _todo

    fun loadTodoById(id: Int) {
        viewModelScope.launch {
            _todo.value = repository.getTodoById(id)
        }
    }
}


