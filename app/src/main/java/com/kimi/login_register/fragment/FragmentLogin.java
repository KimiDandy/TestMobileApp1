package com.kimi.login_register.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.kimi.login_register.R;


public class FragmentLogin extends Fragment {
    View view;
    private EditText etUsername, etPassword;
    private Button btnlogin;
    private TextView textdaftar;
    private TextView textregister;
    FragmentNegara fragmentNegara = new FragmentNegara();


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

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_login, container, false);
        etUsername = view.findViewById(R.id.etUsername);
        etPassword = view.findViewById(R.id.etPassword);
        btnlogin = view.findViewById(R.id.btnlogin);
        textregister = view.findViewById(R.id.textregister);

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(etUsername.getText().toString().equals(Username) && etPassword.getText().toString().equals(Password)){
                    getFragmentManager().beginTransaction().replace(R.id.baseFragment, fragmentNegara).commit();

                    Toast.makeText(getContext(), "Login berhasil", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getContext(), "Login gagal", Toast.LENGTH_SHORT).show();
                }
            }
        });

        textregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().replace(R.id.baseFragment, new FragmentRegister()).commit();
            }
        });
        return view;
    }
}