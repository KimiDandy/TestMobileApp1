package com.kimi.login_register;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.kimi.login_register.fragment.FragmentLogin;
import com.kimi.login_register.fragment.FragmentMahasiswa;
import com.kimi.login_register.fragment.FragmentNegara;

public class Activity_mainDashboard extends AppCompatActivity {
    TextView textView1, textView2, textView3;
    FragmentNegara fragmentNegara = new FragmentNegara();
    FragmentMahasiswa fragmentMahasiswa = new FragmentMahasiswa();
    FragmentLogin fragmentLogin = new FragmentLogin();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_dashboard);
        textView1 = findViewById(R.id.textview1);
        textView2 = findViewById(R.id.textview2);
        textView3 = findViewById(R.id.textview3);

        getSupportFragmentManager().beginTransaction().add(R.id.baseFragment, fragmentNegara).commit();

        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().replace(R.id.baseFragment, fragmentNegara).commit();
            }
        });

        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().replace(R.id.baseFragment, fragmentMahasiswa).commit();
            }
        });

        textView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().replace(R.id.baseFragment, fragmentLogin).commit();
            }
        });
    }
}