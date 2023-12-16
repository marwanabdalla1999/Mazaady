package com.example.domain.reposoitories

import com.example.domain.apiStates.CategoriesApiStates
import com.example.domain.apiStates.OptionsApiStates
import com.example.domain.apiStates.PropertiesApiStates

interface IOptionsRepository {



    suspend fun getOptions(id : Int ): OptionsApiStates
}