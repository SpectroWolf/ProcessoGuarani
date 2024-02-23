package com.spectrotech.testeguarani.data.repository

import com.spectrotech.testeguarani.data.localDataSource.ClientDao
import com.spectrotech.testeguarani.data.model.Client
import javax.inject.Inject

class ClientRepository @Inject constructor(
    private val clientDao: ClientDao
) {

    fun getAllClients() {
        clientDao.getAllClients()
    }

    fun upsertClient(client: Client){

    }

}