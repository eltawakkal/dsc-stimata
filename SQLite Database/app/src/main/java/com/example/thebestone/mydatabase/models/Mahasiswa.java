package com.example.thebestone.mydatabase.models;

public class Mahasiswa {

    private String nama;
    private String jurusan;
    private String semester;

    public Mahasiswa(String nama, String jurusan, String semester) {
        this.nama = nama;
        this.jurusan = jurusan;
        this.semester = semester;
    }

    public String getNama() {
        return nama;
    }

    public String getJurusan() {
        return jurusan;
    }

    public String getSemester() {
        return semester;
    }

}
