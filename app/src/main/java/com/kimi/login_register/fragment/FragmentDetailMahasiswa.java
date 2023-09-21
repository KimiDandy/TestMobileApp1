package com.kimi.login_register.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.kimi.login_register.Mahasiswa;
import com.kimi.login_register.R;

public class FragmentDetailMahasiswa extends Fragment {
    View view;
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_detail_mahasiswa, container, false);
        Mahasiswa selectedMahasiswa = getArguments().getParcelable("selected_mahasiswa");
        TextView namaMahasiswa = view.findViewById(R.id.nama_mahasiswa1);
        TextView nimMahasiswa = view.findViewById(R.id.nim_mahasiswa1);
        TextView nohpMahasiswa = view.findViewById(R.id.nohp_mahasiswa1);
        ImageView gambarMahasiswa = view.findViewById(R.id.gambar_mahasiswa1);

        namaMahasiswa.setText(selectedMahasiswa.getNama());
        nimMahasiswa.setText(selectedMahasiswa.getNim());
        nohpMahasiswa.setText(selectedMahasiswa.getNohp());
        gambarMahasiswa.setImageResource(selectedMahasiswa.getFoto());
        return view;
    }
}