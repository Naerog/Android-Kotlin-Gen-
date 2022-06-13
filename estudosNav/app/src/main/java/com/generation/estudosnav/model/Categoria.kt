package com.generation.estudosnav.model

data class Categoria(var id: Long,
                     var descricao: String,
                     var tarefas: List<Tarefa>)
