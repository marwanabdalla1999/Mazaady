package com.example.domain.useCases.properties

import com.example.domain.apiStates.CategoriesApiStates
import com.example.domain.apiStates.PropertiesApiStates

interface IPropertiesUseCase {


   suspend fun getProperties(id : Int ): PropertiesApiStates
}