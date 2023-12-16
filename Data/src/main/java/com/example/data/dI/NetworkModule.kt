package com.example.data.dI

import android.content.Context
import com.example.data.apisEndPoints.ApiService
import com.example.data.connections.NetworkListener
import com.example.data.remoteData.Categories.CategoriesDataSource
import com.example.data.remoteData.Categories.IRemoteCategoriesDataSource
import com.example.data.remoteData.Categories.IRemotePropertiesDataSource
import com.example.data.remoteData.Categories.PropertiesDataSource
import com.example.data.remoteData.options.IOptionDataSource
import com.example.data.remoteData.options.OptionsDataSource
import com.example.data.repositories.CategoriesRepository
import com.example.data.repositories.OptionsRepository
import com.example.data.repositories.PropertiesRepository
import com.example.data.utils.Constants.BaseUrl.BASE_URL
import com.example.domain.reposoitories.ICategoriesRepository
import com.example.domain.reposoitories.IOptionsRepository
import com.example.domain.reposoitories.IPropertiesRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    fun getCategoryRepo(networkListener: NetworkListener, remotePetsDataStore: IRemoteCategoriesDataSource): ICategoriesRepository {

        return CategoriesRepository(networkListener,remotePetsDataStore)
    }


    @Provides
    fun getRemoteCategoryDataStore(apiService: ApiService): IRemoteCategoriesDataSource {

        return CategoriesDataSource(apiService)
    }


    @Provides
    fun getPropertiesRepo(networkListener: NetworkListener, propertiesDataSource: IRemotePropertiesDataSource): IPropertiesRepository {

        return PropertiesRepository(networkListener,propertiesDataSource)
    }


    @Provides
    fun getPropertiesDataSource(apiService: ApiService): IRemotePropertiesDataSource {

        return PropertiesDataSource(apiService)
    }


    @Provides
    fun getOptionsRepo(networkListener: NetworkListener, optionsDataSource: IOptionDataSource): IOptionsRepository {

        return OptionsRepository(networkListener,optionsDataSource)
    }


    @Provides
    fun getOptionDataSource(apiService: ApiService): IOptionDataSource {

        return OptionsDataSource(apiService)
    }

    @Provides
    fun getApiService(): ApiService {
        val client = OkHttpClient.Builder()
            .connectTimeout(5, TimeUnit.SECONDS)
            .writeTimeout(5, TimeUnit.SECONDS)
            .readTimeout(5, TimeUnit.SECONDS)

            .build()
        val retrofitInstance = Retrofit
            .Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofitInstance.create(ApiService::class.java)


    }
    @Provides
    fun getNetworkListener(@ApplicationContext context: Context):NetworkListener{
        return NetworkListener(context)
    }
}

