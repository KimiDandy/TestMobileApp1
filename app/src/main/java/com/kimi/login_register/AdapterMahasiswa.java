package com.kimi.login_register;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.kimi.login_register.fragment.FragmentDetailMahasiswa;

import java.util.ArrayList;

public class AdapterMahasiswa extends RecyclerView.Adapter <AdapterMahasiswa.ViewHolder> {

    private ArrayList<Mahasiswa> mahasiswaModel;
    private Context context;
    private FragmentManager fragmentManager;

    public AdapterMahasiswa(ArrayList<Mahasiswa> mahasiswaModel, Context context, FragmentManager fragmentManager) {
        this.mahasiswaModel = mahasiswaModel;
        this.context = context;
        this.fragmentManager = fragmentManager;
    }

    @NonNull
    @Override
    public AdapterMahasiswa.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.mahasiswa_card,parent, false);
        ViewHolder vh = new ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterMahasiswa.ViewHolder holder, int position) {
        Mahasiswa mahasiswa = mahasiswaModel.get(position);
        holder.namaMahasiswa.setText(mahasiswa.getNama());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("Debug", "Card view clicked for Mahasiswa: " + mahasiswa.getNama());
                FragmentDetailMahasiswa fragmentDetailMahasiswa = new FragmentDetailMahasiswa();
                Bundle args = new Bundle();
                args.putParcelable("selected_mahasiswa", mahasiswa);
                fragmentDetailMahasiswa.setArguments(args);

                fragmentManager.beginTransaction()
                        .replace(R.id.baseFragment_detail_mahasiswa, fragmentDetailMahasiswa)
                        .addToBackStack(null)
                        .commit();
            }
        });
    }

    @Override
    public int getItemCount()
    {
        return mahasiswaModel.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView namaMahasiswa;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            namaMahasiswa = itemView.findViewById(R.id.nama_mahasiswa);

        }
    }
}
