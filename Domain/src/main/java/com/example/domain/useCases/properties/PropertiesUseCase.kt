package com.example.domain.useCases.properties

import com.example.domain.apiStates.PropertiesApiStates
import com.example.domain.reposoitories.IPropertiesRepository

class PropertiesUseCase(
    private val properties: IPropertiesRepository
) : IPropertiesUseCase {

    override suspend fun getProperties(id : Int ): PropertiesApiStates {


        return properties.getProperties(id)


    }




}