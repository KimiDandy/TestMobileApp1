package com.kimi.login_register;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

public class Activity_DetailMahasiswa extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_mahasiswa);

        Intent intent = getIntent();
        if (intent != null) {
            Mahasiswa selectedMahasiswa = intent.getParcelableExtra("selected_mahasiswa");
            Log.d("Debug", "Retrieved Mahasiswa: " + selectedMahasiswa.getNama());

            if (selectedMahasiswa != null) {
                TextView namaMahasiswa = findViewById(R.id.nama_mahasiswa1);
                TextView nimMahasiswa = findViewById(R.id.nim_mahasiswa1);
                TextView nohpMahasiswa = findViewById(R.id.nohp_mahasiswa1);
                ImageView gambarMahasiswa = findViewById(R.id.gambar_mahasiswa1);

                namaMahasiswa.setText(selectedMahasiswa.getNama());
                nimMahasiswa.setText(selectedMahasiswa.getNim());
                nohpMahasiswa.setText(selectedMahasiswa.getNohp());
                gambarMahasiswa.setImageResource(selectedMahasiswa.getFoto());
            } else {
                Log.d("Debug", "No Mahasiswa data found in the intent.");
            }
        } else {
            Log.d("Debug", "Intent is null.");
        }

        }
    }
