package com.pruebadeingreso.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class UserPostViewModel: ViewModel() {
    private val _showLoading: MutableLiveData<Boolean> = MutableLiveData(false)
    val showLoading: LiveData<Boolean> = _showLoading


    fun showLoadingSet(isShow: Boolean) {
        this._showLoading.value = isShow
    }
}