package com.example.data.remoteData.options

import com.example.domain.models.properties.properties
import retrofit2.Response

interface IOptionDataSource {


    suspend fun getOptions(id : Int): Response<properties>

}