package com.kimi.login_register;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText etUsername, etPassword;
    private Button btnlogin;
    private TextView textdaftar;
    private TextView textregister;

    private static String Username = "admin";
    private static String Password = "kims";

    public String getUsername() {
        return Username;
    }
    public static void setUsername(String username) {
        Username = username;
    }
    public String getPassword() {
        return Password;
    }

    public static void setPassword(String password) {
        Password = password;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        btnlogin = findViewById(R.id.btnlogin);
        textregister = findViewById(R.id.textregister);

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(etUsername.getText().toString().equals(Username) && etPassword.getText().toString().equals(Password)){
                    Intent login = new Intent(MainActivity.this, Activity_mainDashboard.class);
                    startActivity(login);

                    Toast.makeText(MainActivity.this, "Login berhasil", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Login gagal", Toast.LENGTH_SHORT).show();
                }
            }
        });

        textregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent register = new Intent(MainActivity.this, Activity_Register.class);
                startActivity(register);
            }
        });
    }
}
