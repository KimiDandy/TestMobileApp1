package com.kimi.login_register;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterMahasiswa extends RecyclerView.Adapter <AdapterMahasiswa.ViewHolder> {

    private ArrayList<Mahasiswa> mahasiswaModel;
    private Context context;

    public AdapterMahasiswa(ArrayList<Mahasiswa> mahasiswaModel, Context context) {
        this.mahasiswaModel = mahasiswaModel;
        this.context = context;
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
        holder.gambarMahasiswa.setImageResource(mahasiswa.getFoto());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("Debug", "Card view clicked for Mahasiswa: " + mahasiswa.getNama());
                Intent intent = new Intent(context, Activity_DetailMahasiswa.class);
                intent.putExtra("selected_mahasiswa", mahasiswa);
                context.startActivity(intent);
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
        ImageView gambarMahasiswa;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            namaMahasiswa = itemView.findViewById(R.id.nama_mahasiswa);
            gambarMahasiswa = itemView.findViewById(R.id.gambar_mahasiswa);

        }
    }
}
