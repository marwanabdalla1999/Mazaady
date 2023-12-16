package com.example.domain.apiStates

import com.example.domain.models.categories.categories

sealed class CategoriesApiStates {
    data object Idle : CategoriesApiStates()

    data object Loading : CategoriesApiStates()

    class Success(var data: categories?) : CategoriesApiStates()
    class Failure(var error: Throwable) : CategoriesApiStates()


}



