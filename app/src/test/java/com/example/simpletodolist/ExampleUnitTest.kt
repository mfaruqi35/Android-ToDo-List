package com.example.simpletodolist

import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import com.example.simpletodolist.logic.TaskManager

class ExampleUnitTest {
    private lateinit var manager: TaskManager

    /* Inisialisasi TaskManager baru sebelum mulai setiap test */
    @Before
    fun setup(){
        manager = TaskManager()
    }

    /* Unit test untuk memastikan list bertambah 1 setelah task valid ditambahkan*/
    @Test
    fun `tambah task valid menambah ukuran list`(){
        manager.addTask("Belajar KPL")
        assertEquals(1, manager.getTasks().size)
    }

    /* Unit test untuk memastikan task dengan judul spasi/kosong tidak masuk ke list*/
    @Test
    fun `tambah task kosong tidak menambah ukuran list`(){
        manager.addTask(" ")
        assertEquals(0, manager.getTasks().size)
    }

    /* Unit test untuk memastikan addTask() mengembalikan false jika judul kosong */
    @Test
    fun `tambah task kosong kembalikan false`(){
        val result = manager.addTask(" ")
        assertFalse(result)
    }

    /* Unit test untuk memastikan task benar-beanr hilang dari list setelah dihapus*/
    @Test
    fun `menghapus task menghilangkannya dari list`(){
        manager.addTask("Belajar KPL")
        val id = manager.getTasks().first().id
        manager.deleteTask(id)
        assertTrue(manager.getTasks().isEmpty())
    }

    /* Unit test untuk memastikan isDone berubah menjadi true setelah completeTask dipanggil*/
    @Test
    fun `ceklis task membuat isDone task menjadi true`(){
        manager.addTask("Belajar KPL")
        val id = manager.getTasks().first().id
        manager.completeTask(id)
        assertTrue(manager.getTasks().first().isDone)
    }

    /* Unit test untuk memastikan isDone kembali false jika completeTask dipanggil dua kali (toggle)*/
    @Test
    fun `unceklis task membuat isDone task menjadi false`(){
        manager.addTask("Belajar KPL")
        val id = manager.getTasks().first().id
        manager.completeTask(id)
        manager.completeTask(id)
        assertFalse(manager.getTasks().first().isDone)

    }

    /* Unit test untuk memastikan semua task tersimpan dengan benar saat ditambahkan sekaligus*/
    @Test
    fun `menambah banyak task`(){
        manager.addTask("Task 1")
        manager.addTask("Task 2")
        manager.addTask("Task 3")
        assertEquals(3, manager.getTasks().size)
    }
}