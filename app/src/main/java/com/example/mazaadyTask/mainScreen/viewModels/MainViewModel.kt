package com.example.mazaadyTask.mainScreen.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.utils.Constants
import com.example.domain.apiStates.CategoriesApiStates
import com.example.domain.apiStates.OptionsApiStates
import com.example.domain.apiStates.PropertiesApiStates
import com.example.domain.useCases.Categories.ICategoriesUseCase
import com.example.domain.useCases.options.IOptionsUseCase
import com.example.domain.useCases.properties.IPropertiesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val categoriesUseCase: ICategoriesUseCase,
                                        private  val propertiesUseCase: IPropertiesUseCase
                                        , private  val optionUseCase: IOptionsUseCase) :ViewModel() {

    private val _categories = MutableStateFlow<CategoriesApiStates>(CategoriesApiStates.Idle)
    val categories: StateFlow<CategoriesApiStates> = _categories

    private val _properties = MutableStateFlow<PropertiesApiStates>(PropertiesApiStates.Idle)
    val properties: StateFlow<PropertiesApiStates> = _properties

    private val _options = MutableStateFlow<OptionsApiStates>(OptionsApiStates.Idle)
    val options: StateFlow<OptionsApiStates> = _options
    private val categoriesExceptionHandler = CoroutineExceptionHandler { _, _ ->
        _categories.value = CategoriesApiStates.Failure(Throwable(Constants.Errors.UNKNOWN_ERROR))

    }
    private val propertiesExceptionHandler = CoroutineExceptionHandler { _, _ ->
        _properties.value = PropertiesApiStates.Failure(Throwable(Constants.Errors.UNKNOWN_ERROR))

    }
    private val optionsExceptionHandler = CoroutineExceptionHandler { _, _ ->
        _properties.value = PropertiesApiStates.Failure(Throwable(Constants.Errors.UNKNOWN_ERROR))

    }





    fun getMainCategories(){
        _categories.value=CategoriesApiStates.Loading
        viewModelScope.launch(Dispatchers.IO + categoriesExceptionHandler) {

            _categories.value = categoriesUseCase.getCategories()

        }

    }

    fun getProperties( id:Int){
        _properties.value=PropertiesApiStates.Loading
        viewModelScope.launch(Dispatchers.IO + propertiesExceptionHandler) {

            _properties.value = propertiesUseCase.getProperties(id)

        }

    }


    fun getOptions(id:Int){
        _options.value=OptionsApiStates.Loading
        viewModelScope.launch(Dispatchers.IO + propertiesExceptionHandler) {

            _options.value = optionUseCase.getOptions(id)

        }

    }


}