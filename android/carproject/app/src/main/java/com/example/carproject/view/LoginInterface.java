package com.example.carproject.view;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


import com.example.carproject.controller.RetrofitClient;
import com.example.carproject.controller.UserAPIController;
import com.example.carproject.model.User;
import com.example.carproject.R;

public class LoginInterface extends AppCompatActivity {

    private EditText txtEmail;
    private EditText txtPassword;

    //private final APIConnection apiConnection = new APIConnection();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.login_interface);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        txtEmail = findViewById(R.id.edtEmail);
        txtPassword = findViewById(R.id.edtPassWord);


    }

    public void getLogin(View view){


       String email_user = txtEmail.getText().toString();
       String password_user = txtPassword.getText().toString();

        RetrofitClient retrofitClient;
        retrofitClient = new RetrofitClient();

        UserAPIController userAPIController = new UserAPIController(retrofitClient);

        //apiConnection.loginUser(user,new APIConnection.LoginUserCallback(){
        userAPIController.getLoginUser(email_user, password_user, new UserAPIController.ResponseCallback(){
            @Override
            public void onSuccess(User user) {
                //textView.setText(user_list.getSupport().getText());
                AlertDialog.Builder alerta = new AlertDialog.Builder(LoginInterface.this);
                alerta.setCancelable(false);
                alerta.setTitle("Login");
                alerta.setMessage(user.toString());
                alerta.setNegativeButton("Ok",null);
                alerta.create().show();
            }
            @Override
            public void onFailure(Throwable t) {
                //Log.e("UserList", "Erro ao buscar usuários", t);
                AlertDialog.Builder alerta = new AlertDialog.Builder(LoginInterface.this);
                alerta.setCancelable(false);
                alerta.setTitle("Login");
                alerta.setMessage(t.toString());
                alerta.setNegativeButton("Falouu",null);
                alerta.create().show();
            }
        });

    }
}