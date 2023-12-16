package com.example.data.repositories

import com.example.data.connections.NetworkListener
import com.example.data.remoteData.Categories.IRemotePropertiesDataSource
import com.example.data.remoteData.options.IOptionDataSource
import com.example.data.utils.Constants
import com.example.domain.apiStates.CategoriesApiStates
import com.example.domain.apiStates.OptionsApiStates
import com.example.domain.apiStates.PropertiesApiStates
import com.example.domain.reposoitories.ICategoriesRepository
import com.example.domain.reposoitories.IOptionsRepository
import com.example.domain.reposoitories.IPropertiesRepository

class OptionsRepository(
    private val networkListener: NetworkListener,
    private val remoteData: IOptionDataSource,
) : IOptionsRepository {


    override suspend fun getOptions(id : Int): OptionsApiStates {

        return execute(id)

    }

    private suspend fun execute(id : Int): OptionsApiStates {

            if (networkListener.getConnectivity()) {
                val response = remoteData.getOptions(id)

                if (response.isSuccessful) {
                    System.out.println("gdfgfdgdfgfdgdfgdfgfdg"+response.body())
                    return OptionsApiStates.Success(response.body())
                }

            }
            return OptionsApiStates.Failure(Throwable(Constants.Errors.UNKNOWN_ERROR))



    }


}