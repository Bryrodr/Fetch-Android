package com.example.fetch_apprenticeship.di

import android.app.Application
import androidx.room.Room
import com.example.fetch_apprenticeship.data.local.ListDatabase
import com.example.fetch_apprenticeship.data.local.dao.ListDao
import com.example.fetch_apprenticeship.data.remote.api.FetchApi
import com.example.fetch_apprenticeship.data.repository.ListItemRepository
import com.example.fetch_apprenticeship.data.repository.ListItemRepositoryImpl
import com.example.fetch_apprenticeship.domain.use_case.GetListItems
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideFetchApi(): FetchApi {
        return Retrofit.Builder()
            .baseUrl(FetchApi.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(FetchApi::class.java)
    }

    @Provides
    @Singleton
    fun provideListItemRepository(api: FetchApi, dao: ListDao): ListItemRepository {
        return ListItemRepositoryImpl(api, dao)
    }

    @Provides
    @Singleton
    fun providesGetListItemsUseCase(repository: ListItemRepository): GetListItems {
        return GetListItems(repository)
    }


    @Provides
    @Singleton
    fun provideListDatabase(app : Application): ListDatabase {
        return Room.databaseBuilder(app, ListDatabase::class.java, ListDatabase.DATABASE_NAME)
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun provideListDao(db: ListDatabase): ListDao {
        return db.listDao()
    }


}