package com.example.data.remoteData.Categories

import com.example.domain.apiStates.CategoriesApiStates
import com.example.domain.models.categories.Category
import com.example.domain.models.categories.categories
import retrofit2.Response

interface IRemoteCategoriesDataSource {



    suspend fun getCategories(): Response<categories>
}