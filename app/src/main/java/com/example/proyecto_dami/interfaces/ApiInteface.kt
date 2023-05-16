package com.example.proyecto_dami.interfaces

import com.example.proyecto_dami.models.CategoriaCLS
import retrofit2.Call
import retrofit2.http.GET

public interface ApiInteface {

    @GET("Categoria")
    fun getData(): Call<List<CategoriaCLS>>
}