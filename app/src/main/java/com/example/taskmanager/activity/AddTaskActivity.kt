package com.example.taskmanager.activity

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.taskmanager.R
import com.example.taskmanager.database.db.TaskDatabase
import com.example.taskmanager.database.entity.Task
import com.example.taskmanager.databinding.ActivityAddTaskBinding
import com.example.taskmanager.repository.TaskRepository
import com.example.taskmanager.viewmodel.TaskViewModel
import com.example.taskmanager.viewmodel.TaskViewModelFactory

class AddTaskActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAddTaskBinding
    private lateinit var viewModel: TaskViewModel
    private var taskId: Int = -1


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityAddTaskBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val taskDao = TaskDatabase.getDatabase(this.applicationContext).taskDao()
        val taskRepository = TaskRepository(taskDao)
        val viewModelFactory = TaskViewModelFactory(taskRepository)
        viewModel = ViewModelProvider(this, viewModelFactory)[TaskViewModel::class.java]
        initViews()
        setClickListeners()
    }

    private fun initViews() {
        if (intent.hasExtra("id")) {
            taskId = intent.getIntExtra("id", -1)
            binding.textViewAppTitle.text = getString(R.string.edit_task)
            binding.editTextTitle.setText(intent.getStringExtra("title"))
            binding.editTextDescription.setText(intent.getStringExtra("description"))
            binding.imageViewDelete.visibility = View.VISIBLE
        }
    }

    private fun setClickListeners() {
        binding.buttonAddTask.setOnClickListener {
            val title = binding.editTextTitle.text.toString()
            val description = binding.editTextDescription.text.toString()

            if (title.isEmpty() && description.isEmpty()) {
                Toast.makeText(
                    this@AddTaskActivity,
                    "Please enter title and description",
                    Toast.LENGTH_SHORT
                )
                    .show()
            } else if (title.isEmpty()) {
                Toast.makeText(this@AddTaskActivity, "Please enter title", Toast.LENGTH_SHORT)
                    .show()
            } else if (description.isEmpty()) {
                Toast.makeText(this@AddTaskActivity, "Please enter description", Toast.LENGTH_SHORT)
                    .show()
            } else {
                if (taskId == -1) {
                    viewModel.insertTask(Task(id = 0, title = title, description = description))
                } else {
                    viewModel.updateTask(
                        Task(
                            id = taskId,
                            title = title,
                            description = description
                        )
                    )
                }

                finish()
            }
        }

        binding.imageViewDelete.setOnClickListener {
            viewModel.deleteTaskById(taskId)
            finish()
        }
    }
}