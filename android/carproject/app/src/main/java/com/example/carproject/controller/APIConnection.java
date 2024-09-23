package com.example.carproject.controller;

import com.example.carproject.model.User;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.POST;

public class APIConnection {
    // URL  base do servidor  backend
    private String urlBase = "https://127.0.0.1:8443/";
    // Objeto RequestUser responsável pelas requisições ao servidor
    private RequestUser requestUser;

    // Construtor do objeto de conexão ao servidor de backend
    public APIConnection() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(urlBase)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        requestUser = retrofit.create(RequestUser.class);
    }

    // Define os pontos de acesso ao servidor de backend
    interface RequestUser {
        @POST("/user/login")
        Call<User> loginUser(@Body User user);
        //@POST("user/users")
        //Call<String> createUser(@Body User user);
    }

    //Método para verificar o login do usuário
    public void loginUser(User user, LoginUserCallback logedUserCallback){
        requestUser.loginUser(user).enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response)
            {
                logedUserCallback.onSuccess(response.body()); }
            @Override
            public void onFailure(Call<User> call, Throwable t)
            {
                logedUserCallback.onFailure(new Exception("Request failed")); }}
        );
    }

    public interface LoginUserCallback {
        void onSuccess(User user);
        void onFailure(Throwable t);
    }


    /*
    public interface NewUserCallback {
        void onSuccess(String retorno);
        void onFailure(Throwable t);
    }
    public void createUser(User newUser, NewUserCallback newUserCallback){

        Call<String> call = requestUser.createUser(newUser);
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                newUserCallback.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                newUserCallback.onFailure(new Exception("Request failed")); }}
        );


    }

    */
}