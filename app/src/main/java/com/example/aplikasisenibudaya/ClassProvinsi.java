package com.example.aplikasisenibudaya;

public class ClassProvinsi  {

    String kode_provinsi;
    String nama_provinsi;
    String kode_pulau;
    String image;

    public ClassProvinsi(String kode_provinsi, String nama_provinsi, String kode_pulau, String image) {
        this.kode_provinsi = kode_provinsi;
        this.nama_provinsi = nama_provinsi;
        this.kode_pulau = kode_pulau;
        this.image = image;
    }


    public String getKode_provinsi() {
        return kode_provinsi;
    }

    public String getNama_provinsi() {
        return nama_provinsi;
    }

    public String getKode_pulau() {
        return kode_pulau;
    }

    public String getImage() {
        return image;
    }
}
