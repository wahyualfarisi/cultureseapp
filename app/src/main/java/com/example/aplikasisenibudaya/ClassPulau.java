package com.example.aplikasisenibudaya;

public class ClassPulau {

    String kode_pulau;
    String nama_pulau;
    String image;

    public ClassPulau(String kode_pulau, String nama_pulau, String image){
        this.kode_pulau = kode_pulau;
        this.nama_pulau = nama_pulau;
        this.image = image;
    }

    public String getKode_pulau() {
        return kode_pulau;
    }

    public String getNama_pulau() {
        return nama_pulau;
    }

    public String getImage() {
        return image;
    }
}
