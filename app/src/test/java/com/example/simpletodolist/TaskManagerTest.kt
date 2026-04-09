package com.example.simpletodolist

import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import com.example.simpletodolist.logic.TaskManager

class TaskManagerTest {

    private lateinit var manager: TaskManager

    @Before
    fun setup(){
        manager = TaskManager()
    }

    @Test
    fun `tambah task valid menambah ukuran list`(){
        manager.addTask("Belajar KPL")
        assertEquals(1, manager.getTasks().size)
    }
}