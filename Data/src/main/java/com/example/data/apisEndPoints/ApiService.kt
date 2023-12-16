package com.example.data.apisEndPoints

import com.example.domain.models.categories.categories
import com.example.domain.models.properties.properties
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path
import retrofit2.http.Query


interface ApiService {

    @GET("/api/v1/get_all_cats")
   suspend fun getCategories(
        @Header("private-key") key: String,
    ): Response<categories>

    @GET("/api/v1/properties")
    suspend fun getProperties(
        @Header("private-key") key: String,
        @Query("cat") cat:Int
    ): Response<properties>


    @GET("/api/v1/get-options-child/{option_id}")
    suspend fun getOptions(
        @Header("private-key") key: String,
        @Path("option_id") optionId:Int
    ): Response<properties>

}