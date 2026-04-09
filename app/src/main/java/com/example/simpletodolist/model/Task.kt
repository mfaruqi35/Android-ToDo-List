package com.example.simpletodolist.model

data class Task(
    val id: Int,
    val title: String,
    val isDone: Boolean = false
)
