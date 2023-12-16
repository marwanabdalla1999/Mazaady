package com.example.domain.apiStates

import com.example.domain.models.properties.properties

sealed class PropertiesApiStates {
    data object Idle : PropertiesApiStates()

    data object Loading : PropertiesApiStates()

    class Success(var data: properties?) : PropertiesApiStates()
    class Failure(var error: Throwable) : PropertiesApiStates()


}



