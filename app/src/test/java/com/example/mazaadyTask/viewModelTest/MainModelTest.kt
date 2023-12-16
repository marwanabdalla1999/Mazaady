package com.example.mazaadyTask.viewModelTest

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.domain.apiStates.CategoriesApiStates
import com.example.domain.apiStates.PropertiesApiStates
import com.example.domain.useCases.categories.ICategoriesUseCase
import com.example.domain.useCases.options.IOptionsUseCase
import com.example.domain.useCases.properties.IPropertiesUseCase
import com.example.mazaadyTask.mainScreen.viewModels.MainViewModel
import com.example.mazaadyTask.utils.getOrAwaitValue
import junit.framework.TestCase.assertEquals

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations

class MainModelTest {

    // Provide a rule to execute LiveData operations synchronously
    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var categoryUseCase: ICategoriesUseCase

    @Mock
    private lateinit var propertiesUseCase: IPropertiesUseCase

    @Mock
    private lateinit var optionsUseCase: IOptionsUseCase

    private lateinit var mainViewModel: MainViewModel

    @Before
    fun setup() {
        MockitoAnnotations.openMocks(this)

        mainViewModel = MainViewModel(categoryUseCase, propertiesUseCase, optionsUseCase)
    }


    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun categoriesSuccessTest() = runTest(UnconfinedTestDispatcher()) {


        val expectedResult = CategoriesApiStates.Success(null)
        `when`(categoryUseCase.getCategories()).thenReturn(expectedResult)

        // Act
        mainViewModel.getMainCategories()

        // Assert
        when (val result = mainViewModel.categories.getOrAwaitValue { }) {
            is CategoriesApiStates.Success -> {
                assertEquals(expectedResult.data, result.data)

            }


            else -> {
                assert(false)
            }
        }
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun categoriesFailureTest() = runTest(UnconfinedTestDispatcher()) {

        val expectedResult = CategoriesApiStates.Failure(Throwable())
        `when`(categoryUseCase.getCategories()).thenReturn(expectedResult)

        // Act
        mainViewModel.getMainCategories()

        // Assert
        when (val result = mainViewModel.categories.getOrAwaitValue { }) {

            is CategoriesApiStates.Failure -> {
                assertEquals(expectedResult.error, result.error)

            }

            else -> {
                assert(false)
            }
        }
    }


    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun propertiesSuccessTest() = runTest(UnconfinedTestDispatcher()) {

        val id = 0
        val expectedResult = PropertiesApiStates.Success(null)
        `when`(propertiesUseCase.getProperties(id)).thenReturn(expectedResult)

        // Act
        mainViewModel.getProperties(id)

        // Assert
        when (val result = mainViewModel.properties.getOrAwaitValue { }) {
            is PropertiesApiStates.Success -> {
                assertEquals(expectedResult.data, result.data)

            }


            else -> {
                assert(false)

            }
        }
    }


    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun propertiesFailureTest() = runTest(UnconfinedTestDispatcher()) {

        val id = 0
        val expectedResult = PropertiesApiStates.Failure(Throwable())
        `when`(propertiesUseCase.getProperties(id)).thenReturn(expectedResult)

        // Act
        mainViewModel.getProperties(id)

        // Assert
        when (val result = mainViewModel.properties.getOrAwaitValue { }) {
            is PropertiesApiStates.Failure -> {
                assertEquals(expectedResult.error, result.error)

            }


            else -> {
                assert(false)
            }
        }
    }

}