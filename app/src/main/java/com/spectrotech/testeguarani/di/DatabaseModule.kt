package com.spectrotech.testeguarani.di

import android.content.Context
import androidx.room.Room
import com.spectrotech.testeguarani.data.localDataSource.ClientDao
import com.spectrotech.testeguarani.data.localDataSource.ClientDataBase
import com.spectrotech.testeguarani.data.repository.ClientRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun provideDataBase(
        @ApplicationContext context: Context
    ) : ClientDataBase = Room.databaseBuilder(
        context,
        ClientDataBase::class.java,
        "local_db_client"
    ).createFromAsset("database/bancomovel.db").build()

    @Singleton
    @Provides
    fun provideDao(dataBase: ClientDataBase) : ClientDao = dataBase.clientDao()

    @Provides
    @Singleton
    fun provideClientRepository(dao: ClientDao) : ClientRepository = ClientRepository(dao)

}