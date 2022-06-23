package com.generation.estudosnav.adapter

import com.generation.estudosnav.model.Tarefa

interface TaskItemClickListener {
    fun onTaskClicked(tarefas: Tarefa)
}