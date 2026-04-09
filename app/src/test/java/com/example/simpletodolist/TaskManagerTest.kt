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

    @Test
    fun `tambah task kosong tidak menambah ukuran list`(){
        manager.addTask(" ")
        assertEquals(0, manager.getTasks().size)
    }

    @Test
    fun `tambah task kosong kembalikan false`(){
        val result = manager.addTask(" ")
        assertFalse(result)
    }

    @Test
    fun `menghapus task menghilangkannya dari list`(){
        manager.addTask("Belajar KPL")
        val id = manager.getTasks().first().id
        manager.deleteTask(id)
        assertTrue(manager.getTasks().isEmpty())
    }

    @Test
    fun `ceklis task membuat isDone task menjadi true`(){
        manager.addTask("Belajar KPL")
        val id = manager.getTasks().first().id
        manager.completeTask(id)
        assertTrue(manager.getTasks().first().isDone)
    }

    @Test
    fun `unceklis task membuat isDone task menjadi false`(){
        manager.addTask("Belajar KPL")
        val id = manager.getTasks().first().id
        manager.completeTask(id)
        manager.completeTask(id)
        assertFalse(manager.getTasks().first().isDone)

    }
}