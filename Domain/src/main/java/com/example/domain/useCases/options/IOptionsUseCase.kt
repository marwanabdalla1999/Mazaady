package com.example.domain.useCases.options

import com.example.domain.apiStates.OptionsApiStates

interface IOptionsUseCase {


   suspend fun getOptions(id : Int ): OptionsApiStates
}