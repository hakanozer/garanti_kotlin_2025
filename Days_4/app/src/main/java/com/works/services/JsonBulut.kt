package com.works.services

import com.works.models.LoginModel
import com.works.models.ProductsModel
import com.works.models.UserModel
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface JsonBulut {

    @POST("auth/login")
    fun userLogin( @Body loginModel: LoginModel ) : Call<UserModel>

    @GET("products")
    fun allProducts(
        @Query("page") page:Int,
        @Query("per_page") per_page:Int
    ) : Call<ProductsModel>

}