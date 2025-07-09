package com.works.services

import com.works.models.LoginModel
import com.works.models.UserModel
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface JsonBulut {

    @POST("auth/login")
    fun userLogin( @Body loginModel: LoginModel ) : Call<UserModel>

}