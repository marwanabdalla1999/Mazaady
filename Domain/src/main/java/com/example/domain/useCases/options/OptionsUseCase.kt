package com.example.domain.useCases.options

import com.example.domain.apiStates.OptionsApiStates
import com.example.domain.reposoitories.IOptionsRepository

class OptionsUseCase(
    private val options: IOptionsRepository
) : IOptionsUseCase {

    override suspend fun getOptions(id : Int ): OptionsApiStates {


        return options.getOptions(id)


    }




}