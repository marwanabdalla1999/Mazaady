package com.example.data.remoteData.options

import com.example.data.apisEndPoints.ApiService
import com.example.data.utils.Constants
import com.example.domain.models.properties.properties
import retrofit2.Response

class OptionsDataSource(private val apiService: ApiService): IOptionDataSource {



    override suspend fun getOptions(id : Int): Response<properties> {

        return  apiService.getOptions(Constants.Credentials.PrivateKey,id)


    }
}