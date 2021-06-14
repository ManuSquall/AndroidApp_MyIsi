package com.example.myisi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText txtLogin, txtPassword;
    private Button btnConnect, btnSignIn;
    private String login, password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtLogin = findViewById(R.id.txtLogin);
        txtPassword = findViewById(R.id.txtPassword);
        btnConnect = findViewById(R.id.btnConnect);
        btnSignIn = findViewById(R.id.btnSignIn);

        //Gerer le click sur le boutton Connect
        btnConnect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login = txtLogin.getText().toString().trim();
                password = txtPassword.getText().toString().trim();
                if (login.isEmpty()|| password.isEmpty()){
                    Toast.makeText(MainActivity.this, getString(R.string.errors_fields), Toast.LENGTH_SHORT).show();
                }else{
                    Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                    startActivity(intent);
                }
            }
        });
    }
}