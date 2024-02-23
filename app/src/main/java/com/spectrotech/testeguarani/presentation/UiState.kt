package com.spectrotech.testeguarani.presentation

sealed class UIState {
    object Loading : UIState()
    object Success : UIState()
    object Error : UIState()
    object EmptyState: UIState()
    object UpdatedDB: UIState()
}