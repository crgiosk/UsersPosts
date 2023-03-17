package com.pruebadeingreso.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pruebadeingreso.data.usecase.PostUseCase
import com.pruebadeingreso.data.usecase.UserUseCase
import com.pruebadeingreso.ui.binds.PostUserBind
import com.pruebadeingreso.ui.binds.UserBind
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserPostViewModel @Inject constructor(
    private val userUseCase: UserUseCase,
    private val postUseCase: PostUseCase
) : ViewModel() {

    var userSelected: UserBind? = null

    private val _usersList: MutableLiveData<List<UserBind>> = MutableLiveData()
    val usersList: LiveData<List<UserBind>> = _usersList

    private val _postByUserList: MutableLiveData<List<PostUserBind>> = MutableLiveData()
    val postByUserList: LiveData<List<PostUserBind>> = _postByUserList

    private val _showLoading: MutableLiveData<Boolean> = MutableLiveData(false)
    val showLoading: LiveData<Boolean> = _showLoading

    private val _isEmptyList: MutableLiveData<Boolean> = MutableLiveData(false)
    val isEmptyList: LiveData<Boolean> = _isEmptyList

    fun showLoadingSet(isShow: Boolean) {
        _showLoading.value = isShow
    }

    fun isEmptyListSet(isEmpty: Boolean) {
        _isEmptyList.value = isEmpty
    }

    fun getUsers() {
        showLoadingSet(true)
        viewModelScope.launch {
            val response = userUseCase.invoke()
            _usersList.value = response
            showLoadingSet(false)
        }
    }

    fun getPostByUser() {
        showLoadingSet(true)
        viewModelScope.launch {
            val data = postUseCase.getPostByUser(userSelected?.idUser ?: 0)
            _postByUserList.value = data
            showLoadingSet(false)

        }
    }

    fun searchUserByName(
        name: String,
        onResults: (List<UserBind>) -> Unit
    ) {

        viewModelScope.launch {
            onResults.invoke(
                userUseCase.searchUserByName(name)
            )
        }
    }
}