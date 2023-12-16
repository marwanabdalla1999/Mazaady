package com.example.domain.useCases.Categories

import com.example.domain.apiStates.CategoriesApiStates

interface ICategoriesUseCase {


   suspend fun getCategories(): CategoriesApiStates
}