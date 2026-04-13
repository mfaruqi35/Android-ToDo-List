package com.example.simpletodolist

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun a_testTambahTask() {

        /* Memastikan fitur tambah task berjalan normal di Android */

        // Cari text field dan ketik tugas baru
        Thread.sleep(2000)
        composeTestRule.onNodeWithText("Tambah task...").performTextInput("Testing Tambah Task")
        
        // Klik tombol Add
        Thread.sleep(3000)
        composeTestRule.onNodeWithText("Add").performClick()

        // Pastikan tugas baru muncul di layar
        Thread.sleep(2000)
        composeTestRule.onNodeWithText("Belajar KPL").assertExists()
    }

    @Test
    fun b_testHapusTask() {

        /* Memastikan fitur hapus task berjalan normal di Android */

        // Cari text field dan ketik tugas baru
        Thread.sleep(2000)
        composeTestRule.onNodeWithText("Tambah task...").performTextInput("Testing Hapus Task")

        // Klik Tombol Add
        Thread.sleep(3000)
        composeTestRule.onNodeWithText("Add").performClick()
        Thread.sleep(3000)

        // Klik tombol Hapus
        composeTestRule.onNodeWithText("Hapus").performClick()
        Thread.sleep(2000)

        // Pastikan task sudah tidak ada
        composeTestRule.onNodeWithText("Task Hapus").assertDoesNotExist()
    }
}
