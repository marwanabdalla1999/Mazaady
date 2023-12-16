package com.example.domain.useCases.Categories

import com.example.domain.apiStates.CategoriesApiStates
import com.example.domain.reposoitories.ICategoriesRepository

class CategoriesUseCase(
    private val categories: ICategoriesRepository
) : ICategoriesUseCase {

    override suspend fun getCategories(): CategoriesApiStates {


        return categories.getCategories()


    }




}