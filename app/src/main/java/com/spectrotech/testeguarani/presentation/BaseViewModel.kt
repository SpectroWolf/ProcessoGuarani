package com.spectrotech.testeguarani.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.spectrotech.testeguarani.util.CustomMutableLiveData

open class BaseViewModel <T> : ViewModel(){

    val uiStateClientList: CustomMutableLiveData<T> = CustomMutableLiveData()
    fun uiStateClientList(): LiveData<T> = uiStateClientList

    fun cleanUiState(){
        uiStateClientList.value = null!!
    }

}