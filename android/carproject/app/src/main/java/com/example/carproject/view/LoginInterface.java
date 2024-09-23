package com.example.carproject.view;

import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


import com.example.carproject.controller.APIConnection;
import com.example.carproject.model.User;
import com.example.carproject.R;

public class LoginInterface extends AppCompatActivity {

    private final APIConnection apiConnection = new APIConnection();
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
    }

    public void getLogin(View view){
        User user = new User();

        user.setEmail("adriano.alvares@gmail.com");
        user.setPassword("123");
        apiConnection.loginUser(user,new APIConnection.LoginUserCallback(){
            @Override
            public void onSuccess(User user) {
                //textView.setText(user_list.getSupport().getText());
                AlertDialog.Builder alerta = new AlertDialog.Builder(LoginInterface.this);
                alerta.setCancelable(false);
                alerta.setTitle("Login");
                alerta.setMessage("OK!!!");
                alerta.setNegativeButton("Ok",null);
                alerta.create().show();
            }
            @Override
            public void onFailure(Throwable t) {
                //Log.e("UserList", "Erro ao buscar usuários", t);
                AlertDialog.Builder alerta = new AlertDialog.Builder(LoginInterface.this);
                alerta.setCancelable(false);
                alerta.setTitle("Login");
                alerta.setMessage("Nome de usuário ou password com erro!");
                alerta.setNegativeButton("Ok",null);
                alerta.create().show();
            }
        });

    }
}