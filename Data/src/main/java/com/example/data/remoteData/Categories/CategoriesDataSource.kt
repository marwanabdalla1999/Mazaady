package com.example.data.remoteData.Categories

import com.example.data.apisEndPoints.ApiService
import com.example.data.utils.Constants
import com.example.domain.models.categories.categories
import retrofit2.Response


class CategoriesDataSource (private val apiService: ApiService): IRemoteCategoriesDataSource {


    override suspend fun getCategories(): Response<categories> {

          return  apiService.getCategories(Constants.Credentials.PrivateKey)


    }


}