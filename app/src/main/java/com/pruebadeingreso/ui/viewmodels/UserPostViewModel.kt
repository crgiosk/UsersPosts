package com.pruebadeingreso.ui.viewmodels

import androidx.databinding.ObservableBoolean
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pruebadeingreso.data.usecase.UserUseCase
import com.pruebadeingreso.ui.binds.UserBind
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserPostViewModel @Inject constructor(
    private val userUseCase: UserUseCase
) : ViewModel() {

    private val _usersList: MutableLiveData<List<UserBind>> = MutableLiveData()
    val usersList: LiveData<List<UserBind>> = _usersList

    var showLoading = ObservableBoolean()


    fun showLoadingSet(isShow: Boolean) {
        this.showLoading.set(isShow)
    }

    fun getAllUsers() {
        showLoadingSet(true)
        viewModelScope.launch {
            showLoadingSet(false)
            val response = userUseCase.invoke()
            _usersList.value = response
        }
    }
}