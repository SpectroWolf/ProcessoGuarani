package com.spectrotech.testeguarani.data.localDataSource

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import com.spectrotech.testeguarani.data.model.Client

@Dao
interface ClientDao {

    @Upsert()
    suspend fun upsertClient(client: Client)

    @Delete
    suspend fun deleteClient(client: Client)

    @Query("SELECT * FROM GUA_CLIENTES")
    fun getAllClients(): LiveData<List<Client>>

}