package com.example.carproject.controller;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


import com.example.carproject.model.User;

import java.util.List;



public class UserAPIController {

    public static UserAPIController.ResponseCallback ResponseCallback;
    private RetrofitClient retrofitClient;
    private List<User> listUser;
    private String status;
    private User user;
    private UserAPI userApi;


    public interface ResponseCallback {
        void onSuccess(User user);
        void onFailure(Throwable t);
    }

    public UserAPIController(RetrofitClient retrofitClient) {
        this.retrofitClient = retrofitClient;
        this.userApi = RetrofitClient.getRetrofitInstance().create(UserAPI.class);
        this.status = "";
    }

    public String getMessage() {
        return status;
    }



    public void getLoginUser(String email, String password, UserAPIController.ResponseCallback responseCallback) {

        User user = new User(email, password, "");

        Call<User> call = this.userApi.loginUser(user);
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                responseCallback.onSuccess(response.body());
            }
            @Override
            public void onFailure(Call<User> call, Throwable t) {
                responseCallback.onFailure(new Exception("Request failed"));
            }
        });
    }
}