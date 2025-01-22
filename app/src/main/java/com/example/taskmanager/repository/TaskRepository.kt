<<<<<<< HEAD
package com.example.taskmanager.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.taskmanager.database.dao.TaskDao
import com.example.taskmanager.database.entity.Task

class TaskRepository(private val taskDao: TaskDao) {

    var taskList: LiveData<List<Task>> = taskDao.getTaskList()
    private var _filterList: MutableLiveData<List<Task>> = MutableLiveData()
    var filterList: LiveData<List<Task>> = _filterList

    suspend fun insertTask(task: Task) = taskDao.insertTask(task)

    suspend fun updateTask(task: Task) = taskDao.updateTask(task)

    suspend fun deleteTaskById(id: Int) = taskDao.deleteTaskById(id)

    fun searchTask(query: String) {
        _filterList.postValue(taskDao.searchTask(query))
    }
=======
package com.example.taskmanager.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.taskmanager.database.dao.TaskDao
import com.example.taskmanager.database.entity.Task

class TaskRepository(private val taskDao: TaskDao) {

    var taskList: LiveData<List<Task>> = taskDao.getTaskList()
    private var _filterList: MutableLiveData<List<Task>> = MutableLiveData()
    var filterList: LiveData<List<Task>> = _filterList

    suspend fun insertTask(task: Task) = taskDao.insertTask(task)

    suspend fun updateTask(task: Task) = taskDao.updateTask(task)

    suspend fun deleteTaskById(id: Int) = taskDao.deleteTaskById(id)

    fun searchTask(query: String) {
        _filterList.postValue(taskDao.searchTask(query))
    }
>>>>>>> master
}