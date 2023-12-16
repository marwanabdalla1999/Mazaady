package com.example.data.repositories

import com.example.data.connections.NetworkListener
import com.example.data.remoteData.Categories.IRemotePropertiesDataSource
import com.example.data.utils.Constants
import com.example.domain.apiStates.CategoriesApiStates
import com.example.domain.apiStates.PropertiesApiStates
import com.example.domain.reposoitories.ICategoriesRepository
import com.example.domain.reposoitories.IPropertiesRepository

class PropertiesRepository(
    private val networkListener: NetworkListener,
    private val remoteData: IRemotePropertiesDataSource,
) : IPropertiesRepository {


    override suspend fun getProperties(id : Int): PropertiesApiStates {

        return execute(id)

    }

    private suspend fun execute(id : Int): PropertiesApiStates {

            if (networkListener.getConnectivity()) {
                val response = remoteData.getProperties(id)

                if (response.isSuccessful) {
                    return PropertiesApiStates.Success(response.body())
                }

            }
            return PropertiesApiStates.Failure(Throwable(Constants.Errors.UNKNOWN_ERROR))



    }


}