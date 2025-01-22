package com.example.taskmanager.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.taskmanager.database.entity.Task
import com.example.taskmanager.databinding.ItemViewTaskBinding

class TaskAdapter(val onItemClick: ((Task) -> Unit)) : RecyclerView.Adapter<TaskAdapter.TaskViewHolder>() {

    private var taskList: List<Task> = emptyList()

    inner class TaskViewHolder(val binding: ItemViewTaskBinding) :
        RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val binding =
            ItemViewTaskBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TaskViewHolder(binding)
    }

    override fun getItemCount() = taskList.count()

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        val task = taskList[position]
        holder.binding.textViewTitle.text = task.title
        holder.binding.textViewDescription.text = task.description
        holder.binding.root.setOnClickListener { onItemClick(task) }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateTaskList(newTaskList: List<Task>){
        taskList = newTaskList
        notifyDataSetChanged()
    }
}