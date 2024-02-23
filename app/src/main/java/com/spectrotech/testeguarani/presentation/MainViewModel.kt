package com.spectrotech.testeguarani.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.spectrotech.testeguarani.data.model.Client
import com.spectrotech.testeguarani.data.repository.ClientRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val clientRepository: ClientRepository
) : BaseViewModel<UIState>(){

    private val _clientList: MutableLiveData<List<Client>> = MutableLiveData()
    val clientList: LiveData<List<Client>> = _clientList

    fun getAllClients(){

        uiStateClientList.value = UIState.Loading

        viewModelScope.launch {
            _clientList.value = clientRepository.getAllClients()

            uiStateClientList.postValue(UIState.Success)
        }

    }

    fun upsertClient(client: Client){

        uiStateClientList.value = UIState.Loading

        viewModelScope.launch {
            clientRepository.upsertClient(client)

            uiStateClientList.postValue(UIState.UpdatedDB)
        }
    }

    fun deleteClient(client: Client){

        uiStateClientList.value = UIState.Loading

        viewModelScope.launch {
            clientRepository.deleteClient(client)

            uiStateClientList.postValue(UIState.UpdatedDB)
        }
    }

}