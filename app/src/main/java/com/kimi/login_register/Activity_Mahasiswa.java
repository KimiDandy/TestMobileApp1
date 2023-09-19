package com.kimi.login_register;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class Activity_Mahasiswa extends AppCompatActivity{

    private RecyclerView recyclerView;
    private AdapterMahasiswa adapterMahasiswa;
    private ArrayList<Mahasiswa> mahasiswa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mahasiswa);

        getData();

        recyclerView = findViewById(R.id.recycle_view);
        adapterMahasiswa = new AdapterMahasiswa(mahasiswa, getApplicationContext());
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(Activity_Mahasiswa.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapterMahasiswa);
    }

    private void getData() {
        mahasiswa = new ArrayList<>();
        mahasiswa.add(new Mahasiswa("Kimi", R.drawable.kimi, "E41220493", "085210035577"));
        mahasiswa.add(new Mahasiswa("Ariz", R.drawable.ariz, "E41220090", "085257754805"));
        mahasiswa.add(new Mahasiswa("Bintang", R.drawable.bintang, "E41220148", "085748100201"));
        mahasiswa.add(new Mahasiswa("Akila", R.drawable.akila, "E41220089", "085655339075"));
    }
}