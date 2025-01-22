# Task Manager App

A mini Android application for managing tasks using Kotlin. This app demonstrates the implementation of the MVVM architecture with Room Database, LiveData, and ViewModel. Users can create, search, edit, and delete tasks.

## Feature

#### 1. Local Persistence
   * Task data is persisted locally using the Room database.

#### 2. Main Screen
   * Displays a list of tasks (title and description) using a RecyclerView in ```MainActivity.kt```.
   * Includes search functionality to filter tasks by title or description in real-time.

#### 3. Add Task Screen
   * Create a new task from the ```AddTaskActivity.kt``` screen with validation to ensure that no fields are left empty.

#### 4. Edit & Delete Tasks
   * Update or delete existing tasks using the Update Task Screen, implemented using the same ```AddTaskActivity.kt```.

## Tech Stack
* **Language**: Kotlin

* **Architecture**: MVVM

* **Database**: Room

* **Lifecycle Components**: ViewModel, LiveData
