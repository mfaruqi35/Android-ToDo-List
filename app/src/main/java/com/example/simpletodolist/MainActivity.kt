package com.example.simpletodolist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.simpletodolist.ui.theme.SimpleToDoListTheme
import com.example.simpletodolist.logic.TaskManager
import com.example.simpletodolist.model.Task

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SimpleToDoListTheme {
                TodoApp()
            }
        }
    }
}

@Composable
fun TodoApp() {
    val manager = remember { TaskManager() }
    var tasks by remember { mutableStateOf(manager.getTasks()) }
    var inputText by remember { mutableStateOf("") }

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text("To-Do List", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(12.dp))

        // Input row
        Row(verticalAlignment = Alignment.CenterVertically) {
            OutlinedTextField(
                value = inputText,
                onValueChange = { inputText = it },
                label = { Text("Tambah task...") },
                modifier = Modifier.weight(1f)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Button(onClick = {
                if (manager.addTask(inputText)) {
                    tasks = manager.getTasks()
                    inputText = ""
                }
            }) { Text("Add") }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // List task
        LazyColumn {
            items(tasks, key = { it.id }) { task ->
                TaskItem(
                    task = task,
                    onComplete = {
                        manager.completeTask(task.id)
                        tasks = manager.getTasks()
                    },
                    onDelete = {
                        manager.deleteTask(task.id)
                        tasks = manager.getTasks()
                    }
                )
            }
        }
    }
}

@Composable
fun TaskItem(task: Task, onComplete: () -> Unit, onDelete: () -> Unit) {
    Row(
        modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(checked = task.isDone, onCheckedChange = { onComplete() })
        Text(
            text = task.title,
            modifier = Modifier.weight(1f),
            style = if (task.isDone)
                MaterialTheme.typography.bodyLarge.copy(color = MaterialTheme.colorScheme.outline)
            else
                MaterialTheme.typography.bodyLarge
        )
        TextButton(onClick = onDelete) { Text("Hapus") }
    }
}