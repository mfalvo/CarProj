package com.example.carproject.controller;

import retrofit2.Callback;


import com.example.carproject.model.User;

import java.util.List;

public class UserAPIController {

    private RetrofitClient retrofitClient;
    private List<User> listUser;
    private String message;


    public UserAPIController(RetrofitClient retrofitClient, UserApi userApi, User user, String message) {
        this.retrofitClient = retrofitClient;
        this.userApi = RetrofitClient.getRetrofitInstance().create(UserApi.class);;
        this.user = user;
        this.message = message;
    }

    public RetrofitClient getRetrofitClient() {
        return retrofitClient;
    }

    public void setRetrofitClient(RetrofitClient retrofitClient) {
        this.retrofitClient = retrofitClient;
    }








    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    public void getAlunoByEmailAndPassword

    AlunoApi alunoApi =
    //Call<Aluno> call = alunoApi.getAlunoByEmail(email);
    Call<Aluno> call = alunoApi.getAlunoByEmailAndPassword(email,senha);
                call.enqueue(new Callback<Aluno>() {
        @Override
        public void onResponse(Call<Aluno> call, Response<Aluno> response) {
            if (response.isSuccessful() && response.body() != null) {
                Aluno aluno = response.body();
                resultTextView.setText("Nome: " + aluno.getNome());
            } else {
                resultTextView.setText("Email não encontrado");
            }
        }

        @Override
        public void onFailure(Call<Aluno> call, Throwable t) {
            resultTextView.setText("Erro: " + t.getMessage());
        }
    });
}
