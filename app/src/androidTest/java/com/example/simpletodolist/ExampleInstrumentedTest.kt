package com.example.simpletodolist

import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.simpletodolist.logic.TaskManager

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Before

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {

    private lateinit var manager : TaskManager

    @Before
    fun setup(){
        manager = TaskManager()
    }

    /* Test untuk memastikan package nama aplikasi sudah benar*/
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.example.simpletodolist", appContext.packageName)
    }

    /* Test untuk memastikan TakManager berjalan normal di lingkungan Android */
    @Test
    fun taskManager_addTask_berjalanDiAndroid(){
        manager.addTask("Test aplikasi di emulator")
        assertEquals(1, manager.getTasks().size)
    }

    /* Memastikan delete task berjalan normal di lingkungan Android */
    @Test
    fun taskManager_deleteTask_berjalanDiAndroid(){
        manager.addTask("Task untuk dihapus")
        val id = manager.getTasks().first().id
        manager.deleteTask(id)
        assertTrue(manager.getTasks().isEmpty())
    }
}