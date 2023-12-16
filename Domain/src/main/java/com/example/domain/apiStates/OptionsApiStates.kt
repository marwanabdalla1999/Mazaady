package com.example.domain.apiStates

import com.example.domain.models.properties.properties

sealed class OptionsApiStates {
    data object Idle : OptionsApiStates()

    data object Loading : OptionsApiStates()

    class Success(var data: properties?) : OptionsApiStates()
    class Failure(var error: Throwable) : OptionsApiStates()


}



