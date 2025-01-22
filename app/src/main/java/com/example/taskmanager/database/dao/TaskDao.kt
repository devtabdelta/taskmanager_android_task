package com.example.taskmanager.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.taskmanager.database.entity.Task

@Dao
interface TaskDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTask(task: Task)

    @Update
    suspend fun updateTask(task: Task)

    @Query(value = "SELECT * FROM tasks ORDER BY id DESC")
    fun getTaskList(): LiveData<List<Task>>

    @Query("SELECT * FROM tasks WHERE title LIKE :search OR description LIKE :search ORDER BY id DESC")
    fun searchTask(search: String): LiveData<List<Task>>

    @Query(value = "DELETE FROM tasks WHERE id IS :id")
    suspend fun deleteTaskById(id: Int)
}