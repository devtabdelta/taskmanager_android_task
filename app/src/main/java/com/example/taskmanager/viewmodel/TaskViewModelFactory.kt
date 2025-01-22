package com.example.taskmanager.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.taskmanager.repository.TaskRepository

class TaskViewModelFactory(private val userRepository: TaskRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return TaskViewModel(userRepository) as T
    }
}