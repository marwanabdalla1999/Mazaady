package com.example.domain.reposoitories

import com.example.domain.apiStates.CategoriesApiStates
import com.example.domain.apiStates.PropertiesApiStates

interface IPropertiesRepository {



    suspend fun getProperties(id : Int ): PropertiesApiStates
}