package com.example.domain.reposoitories

import com.example.domain.apiStates.CategoriesApiStates

interface ICategoriesRepository {



    suspend fun getCategories(): CategoriesApiStates
}