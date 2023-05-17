package com.example.proyecto_dami.interfaces

import com.example.proyecto_dami.models.CategoriaCLS
import com.example.proyecto_dami.models.UsuarioCLS
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

public interface ApiInteface {

    @GET("Categoria")
    fun getData(): Call<List<CategoriaCLS>>

    @POST("Login")
    fun getDataUsuario(@Body Login: UsuarioCLS): Call<UsuarioCLS>

}