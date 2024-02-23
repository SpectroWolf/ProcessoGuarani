package com.spectrotech.testeguarani.data.repository

import androidx.lifecycle.LiveData
import com.spectrotech.testeguarani.data.localDataSource.ClientDao
import com.spectrotech.testeguarani.data.model.Client
import javax.inject.Inject

class ClientRepository @Inject constructor(
    private val clientDao: ClientDao
) {

    suspend fun getAllClients() = clientDao.getAllClients()

    suspend fun upsertClient(client: Client) = clientDao.upsertClient(client)

    suspend fun deleteClient(client: Client) = clientDao.deleteClient(client)

}