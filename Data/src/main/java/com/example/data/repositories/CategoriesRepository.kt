package com.example.data.repositories

import com.example.data.connections.NetworkListener
import com.example.data.remoteData.Categories.IRemoteCategoriesDataSource
import com.example.data.remoteData.Categories.IRemotePropertiesDataSource
import com.example.data.utils.Constants
import com.example.domain.apiStates.CategoriesApiStates
import com.example.domain.reposoitories.ICategoriesRepository

class CategoriesRepository(
    private val networkListener: NetworkListener,
    private val remoteData: IRemoteCategoriesDataSource,
) : ICategoriesRepository {


    override suspend fun getCategories(): CategoriesApiStates {

        return execute()

    }

    private suspend fun execute(): CategoriesApiStates {

            if (networkListener.getConnectivity()) {
                val response = remoteData.getCategories()

                if (response.isSuccessful) {
                    return CategoriesApiStates.Success(response.body())
                }

            }
            return CategoriesApiStates.Failure(Throwable(Constants.Errors.UNKNOWN_ERROR))



    }


}