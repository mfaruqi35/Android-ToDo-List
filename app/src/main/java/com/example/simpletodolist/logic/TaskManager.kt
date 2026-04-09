package com.example.simpletodolist.logic

import com.example.simpletodolist.model.Task

class TaskManager {
    private val _tasks = mutableListOf<Task>()
    private var nextId = 1

    fun addTask(title: String): Boolean {
        if (title.isBlank()) return false
        _tasks.add(Task(nextId++, title))
        return true
    }

    fun deleteTask(id: Int){
        _tasks.removeIf { it.id == id }
    }

    fun completeTask(id: Int) {
        val index = _tasks.indexOfFirst { it.id == id }
        if (index != -1) {
            _tasks[index] = _tasks[index].copy(isDone = !_tasks[index].isDone)
        }
    }

    fun getTasks(): List<Task> = _tasks.toList()
}