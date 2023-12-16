package com.example.mazaadyTask.dI

import com.example.domain.reposoitories.ICategoriesRepository
import com.example.domain.reposoitories.IOptionsRepository
import com.example.domain.reposoitories.IPropertiesRepository
import com.example.domain.useCases.Categories.ICategoriesUseCase
import com.example.domain.useCases.Categories.CategoriesUseCase
import com.example.domain.useCases.options.IOptionsUseCase
import com.example.domain.useCases.options.OptionsUseCase
import com.example.domain.useCases.properties.IPropertiesUseCase
import com.example.domain.useCases.properties.PropertiesUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
  fun getCategoriesUseCase(categoryRepo: ICategoriesRepository): ICategoriesUseCase {

      return CategoriesUseCase(categoryRepo)
  }
    @Provides
    fun getPropertiesUseCase(propertiesRepo: IPropertiesRepository): IPropertiesUseCase {

        return PropertiesUseCase(propertiesRepo)
    }

    @Provides
    fun getOptionsUseCase(optionsUseCase: IOptionsRepository): IOptionsUseCase {

        return OptionsUseCase(optionsUseCase)
    }


}