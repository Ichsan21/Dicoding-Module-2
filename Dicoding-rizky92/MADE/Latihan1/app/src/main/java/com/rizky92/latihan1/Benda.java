package com.rizky92.latihan1;

import android.os.Parcel;
import android.os.Parcelable;

// INI POJO (Plain Old Java Object)

public class Benda implements Parcelable {
    private String nama;
    private int harga;
    private int stok;

    protected Benda(Parcel in) {
        nama = in.readString();
        harga = in.readInt();
        stok = in.readInt();
    }

    public Benda() { }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    public int getStok() {
        return stok;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(nama);
        parcel.writeInt(harga);
        parcel.writeInt(stok);
    }

    public static final Creator<Benda> CREATOR = new Creator<Benda>() {
        @Override
        public Benda createFromParcel(Parcel parcel) {
            return new Benda(parcel);
        }

        @Override
        public Benda[] newArray(int i) {
            return new Benda[i];
        }
    };
}
