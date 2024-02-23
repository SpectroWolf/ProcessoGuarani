package com.spectrotech.testeguarani.di

import android.content.Context
import androidx.room.Room
import com.spectrotech.testeguarani.data.localDataSource.ClientDataBase
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
    ) = Room.databaseBuilder(
        context,
        ClientDataBase::class.java,
        "bancomovel"
    ).createFromAsset("database/bancomovel.db").build()

    @Singleton
    @Provides
    fun provideDao(dataBase: ClientDataBase) = dataBase.clientDao()

}