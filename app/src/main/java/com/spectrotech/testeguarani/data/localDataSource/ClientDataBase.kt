package com.spectrotech.testeguarani.data.localDataSource

import androidx.room.Database
import androidx.room.RoomDatabase
import com.spectrotech.testeguarani.data.model.Client

@Database(entities = [Client::class], version = 1, exportSchema = true)
abstract class ClientDataBase : RoomDatabase() {
    abstract fun clientDao(): ClientDao
}