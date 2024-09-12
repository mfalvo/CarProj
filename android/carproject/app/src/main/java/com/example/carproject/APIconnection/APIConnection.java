package com.example.carproject.APIconnection;


import com.example.carproject.model.User;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;


public class APIConnection {

    interface RequestUser {
        @GET("api/users/{uid}")
        Call<User> getUser(@Path("uid") String id);
        @POST("/api/users")
        Call<String> createUser(@Body User user);
    }

    String urlBase = "https://localhost:8080";
    RequestUser requestUser;

    // Construtor da classe APIConnection
    public APIConnection() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(urlBase)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        requestUser = retrofit.create(RequestUser.class);
    }




    // UserData
    public interface FindUserCallback {
        void onSuccess(User user);
        void onFailure(Throwable t);
    }
    public void getUser(String id, FindUserCallback findUserCallback){
        requestUser.getUser(id).enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response)
            {   findUserCallback.onSuccess(response.body()); }
            @Override
            public void onFailure(Call<User> call, Throwable t)
            {   findUserCallback.onFailure(new Exception("Request failed")); }}
        );
    }


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


}