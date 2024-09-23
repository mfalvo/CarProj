package com.example.carproject.APIconnection;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

import com.example.carproject.model.User;

interface  UserAPI{
    @POST("/user/login")
    Call<User> loginUser(@Body User user);

    @POST("user/users")
    Call<String> createUser(@Body User user);
}
