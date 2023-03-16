package com.pruebadeingreso.data.network.models.user


import com.google.gson.annotations.SerializedName
import com.pruebadeingreso.ui.binds.UserBind

data class UserApiResponse(
    @SerializedName("address")
    val address: Address,
    @SerializedName("company")
    val company: Company,
    @SerializedName("email")
    val email: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("phone")
    val phone: String,
    @SerializedName("username")
    val username: String,
    @SerializedName("website")
    val website: String
) {
    fun toBind(): UserBind {
        return UserBind(
            idUser = id,
            name = name,
            numberPhone = phone,
            email = email
        )
    }
}