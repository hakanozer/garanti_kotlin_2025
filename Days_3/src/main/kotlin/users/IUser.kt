package com.works.users

import com.works.models.UserModel

interface IUser {

    /**
     * bu fonksiyon kullanıcı girişini kontro eder
     */
    fun userLogin(username: String, password: String): UserModel?
    fun userName(userID: Int): String?
    fun userLogout(userID: Int): Boolean

}