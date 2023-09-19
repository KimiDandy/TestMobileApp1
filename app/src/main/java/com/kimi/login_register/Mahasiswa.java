package com.kimi.login_register;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.ArrayList;

public class Mahasiswa implements Parcelable {
    private String nama;
    private int foto;
    private String nim;
    private String nohp;


    public Mahasiswa(String nama, int foto, String nim, String nohp){
        this.nama = nama;
        this.foto = foto;
        this.nim = nim;
        this.nohp = nohp;
    }


    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public String getNim() {
        return nim;
    }

    public void setNo(String nim) {
        this.nim = nim;
    }

    public String getNohp() {
        return nohp;
    }

    public void setNohp(String nohp) {
        this.nohp = nohp;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nama);
        dest.writeInt(foto);
        dest.writeString(nim);
        dest.writeString(nohp);
    }

    public static final Parcelable.Creator<Mahasiswa> CREATOR = new Parcelable.Creator<Mahasiswa>() {
        @Override
        public Mahasiswa createFromParcel(Parcel source) {
            return new Mahasiswa(source);
        }

        @Override
        public Mahasiswa[] newArray(int size) {
            return new Mahasiswa[size];
        }
    };

    private Mahasiswa(Parcel source) {
        nama = source.readString();
        foto = source.readInt();
        nim = source.readString();
        nohp = source.readString();
    }
}
