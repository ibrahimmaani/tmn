package com.example.commerce.models.networks;


import com.example.commerce.views.auth.resp.RespSignin;
import com.example.commerce.models.entities.Object;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by hamdhanywijaya@gmail.com on 02/02/18.
 */

public interface Endpoint {

    @GET("product")
    Call<Object> listProduct(
    );

    @FormUrlEncoded
    @POST("auth/login")
    Call<RespSignin> authLogin(
            @Field("email") String email , @Field("password") String password
    );




}
