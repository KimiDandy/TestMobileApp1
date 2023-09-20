package com.kimi.login_register.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kimi.login_register.Activity_Mahasiswa;
import com.kimi.login_register.AdapterMahasiswa;
import com.kimi.login_register.Mahasiswa;
import com.kimi.login_register.R;

import java.util.ArrayList;

public class FragmentMahasiswa extends Fragment {
    View view;
    private RecyclerView recyclerView;
    private AdapterMahasiswa adapterMahasiswa;
    private ArrayList<Mahasiswa> mahasiswa;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_mahasiswa, container, false);
        getDataMahasiswa();
        recyclerView = view.findViewById(R.id.fragment_recycle_view);
        adapterMahasiswa = new AdapterMahasiswa(mahasiswa, getContext());
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapterMahasiswa);
        return view;
    }

    private void getDataMahasiswa() {
        mahasiswa = new ArrayList<>();
        mahasiswa.add(new Mahasiswa("Kimi", R.drawable.kimi, "E41220493", "085210035577"));
        mahasiswa.add(new Mahasiswa("Ariz", R.drawable.ariz, "E41220090", "085257754805"));
        mahasiswa.add(new Mahasiswa("Bintang", R.drawable.bintang, "E41220148", "085748100201"));
        mahasiswa.add(new Mahasiswa("Akila", R.drawable.akila, "E41220089", "085655339075"));
    }
}