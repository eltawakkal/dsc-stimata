package com.example.thebestone.intent;

public class Mahasiswa {

    private String nama;
    private String asal;
    private String semester;

    public Mahasiswa(String nama, String asal, String semester) {
        this.nama = nama;
        this.asal = asal;
        this.semester = semester;
    }

    public String getNama() {
        return nama;
    }

    public String getAsal() {
        return asal;
    }

    public String getSemester() {
        return semester;
    }
}
