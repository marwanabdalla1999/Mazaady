package com.example.data.remoteData.Categories

import com.example.domain.models.categories.categories
import com.example.domain.models.properties.properties
import retrofit2.Response

interface IRemotePropertiesDataSource {



    suspend fun getProperties(id : Int): Response<properties>
}