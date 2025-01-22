<<<<<<< HEAD
package com.example.taskmanager.activity

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.taskmanager.R
import com.example.taskmanager.adapter.TaskAdapter
import com.example.taskmanager.database.db.TaskDatabase
import com.example.taskmanager.databinding.ActivityMainBinding
import com.example.taskmanager.repository.TaskRepository
import com.example.taskmanager.viewmodel.TaskViewModel
import com.example.taskmanager.viewmodel.TaskViewModelFactory

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var taskViewModel: TaskViewModel
    private var taskAdapter: TaskAdapter = TaskAdapter { task ->
        val intent = Intent(this@MainActivity, AddTaskActivity::class.java)
        intent.putExtra("id", task.id)
        intent.putExtra("title", task.title)
        intent.putExtra("description", task.description)
        startActivity(intent)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val taskDao = TaskDatabase.getDatabase(this.applicationContext).taskDao()
        val taskRepository = TaskRepository(taskDao)
        val viewModelFactory = TaskViewModelFactory(taskRepository)
        taskViewModel = ViewModelProvider(this, viewModelFactory)[TaskViewModel::class.java]

        initViews()
        setClickListeners()
    }

    private fun initViews() {
        binding.recyclerViewTasks.let {
            it.setHasFixedSize(false)
            it.adapter = taskAdapter
            it.layoutManager = GridLayoutManager(this, 2)
        }

        taskViewModel.taskList.observe(this) { list ->
            taskAdapter.updateTaskList(list)
        }
    }

    private fun setClickListeners() {
        binding.floatingActionButtonAddTask.setOnClickListener {
            startActivity(Intent(this@MainActivity, AddTaskActivity::class.java))
        }
    }
=======
package com.example.taskmanager.activity

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.taskmanager.R
import com.example.taskmanager.adapter.TaskAdapter
import com.example.taskmanager.database.db.TaskDatabase
import com.example.taskmanager.databinding.ActivityMainBinding
import com.example.taskmanager.repository.TaskRepository
import com.example.taskmanager.viewmodel.TaskViewModel
import com.example.taskmanager.viewmodel.TaskViewModelFactory

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var taskViewModel: TaskViewModel
    private var taskAdapter: TaskAdapter = TaskAdapter { task ->
        val intent = Intent(this@MainActivity, AddTaskActivity::class.java)
        intent.putExtra("id", task.id)
        intent.putExtra("title", task.title)
        intent.putExtra("description", task.description)
        startActivity(intent)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val taskDao = TaskDatabase.getDatabase(this.applicationContext).taskDao()
        val taskRepository = TaskRepository(taskDao)
        val viewModelFactory = TaskViewModelFactory(taskRepository)
        taskViewModel = ViewModelProvider(this, viewModelFactory)[TaskViewModel::class.java]

        initViews()
        setClickListeners()
    }

    private fun initViews() {
        binding.recyclerViewTasks.let {
            it.setHasFixedSize(false)
            it.adapter = taskAdapter
            it.layoutManager = GridLayoutManager(this, 2)
        }

        taskViewModel.taskList.observe(this) { list ->
            taskAdapter.updateTaskList(list)
        }
    }

    private fun setClickListeners() {
        binding.floatingActionButtonAddTask.setOnClickListener {
            startActivity(Intent(this@MainActivity, AddTaskActivity::class.java))
        }
    }
>>>>>>> master
}