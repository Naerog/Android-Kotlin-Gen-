package com.api

import com.generation.estudosnav.model.Categoria
import com.generation.estudosnav.model.Tarefa
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {
    @GET("categoria")
    suspend fun listCategoria(): Response<List<Categoria>>

    //adicioanr nova tarefa
    @POST("tarefa")
    suspend fun addTarefa(
        @Body tarefa: Tarefa
    ): Response<Tarefa>

    //Requisições tarefas
    @GET("tarefa")
    suspend fun listTarefas(): Response<List<Tarefa>>

}