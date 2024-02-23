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
) : ViewModel(){

    private val _clientList: MutableLiveData<Client> = MutableLiveData()
    val clientList: LiveData<Client> = _clientList

    fun getAllClients(){
        viewModelScope.launch {
            _clientList.value = clientRepository.getAllClients()
        }
    }

}