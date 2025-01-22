package com.example.taskmanager.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.taskmanager.database.entity.Task
import com.example.taskmanager.repository.TaskRepository
import kotlinx.coroutines.launch

class TaskViewModel(private val taskRepository: TaskRepository) : ViewModel() {

    private var _taskList: LiveData<List<Task>> = taskRepository.taskList
    var taskList: LiveData<List<Task>> =_taskList

    fun insertTask(task: Task) {
        viewModelScope.launch {
            taskRepository.insertTask(task)
        }
    }

    fun updateTask(task: Task) {
        viewModelScope.launch {
            taskRepository.updateTask(task)
        }
    }

    fun deleteTaskById(id: Int) {
        viewModelScope.launch {
            taskRepository.deleteTaskById(id)
        }
    }
}