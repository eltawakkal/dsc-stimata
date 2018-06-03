package com.example.thebestone.intent;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class KelasKedua extends AppCompatActivity {

    ListView listViewMahasiswa;
    ListViewAdapter adapter;
    FloatingActionButton fabTAmbah;

    ArrayList<Mahasiswa> listMahasiswa;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kedua);

        pesanSelamatDatang();

        listMahasiswa = new ArrayList();

        tampilkanData();

        fabTAmbah = findViewById(R.id.fabTambah);
        fabTAmbah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tambahData();
            }
        });

    }

    private void tampilkanData() {

        adapter = new ListViewAdapter(KelasKedua.this, listMahasiswa);

        listViewMahasiswa = findViewById(R.id.listMahasiswa);
        listViewMahasiswa.setAdapter(adapter);
    }

    public void pesanSelamatDatang() {
        String email;
        email = getIntent().getStringExtra(MainActivity.EMAIL_KEY);

        Toast.makeText(this, "Selamat datang, " + email, Toast.LENGTH_SHORT).show();
    }

    public void tambahData() {
        View v = getLayoutInflater().inflate(R.layout.alert_tambah, null);

        final EditText editNama = v.findViewById(R.id.editAsalAlert);
        final EditText editAsal= v.findViewById(R.id.editAsalAlert);
        final EditText editSemester = v.findViewById(R.id.editSemesterAlert);

        AlertDialog.Builder alertTambah = new AlertDialog.Builder(this);

        alertTambah.setTitle("Tambah Data");
        alertTambah.setView(v);
        alertTambah.setPositiveButton("Tambah", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                String nama, asal, semester;

                nama = editNama.getText().toString();
                asal = editAsal.getText().toString();
                semester = editSemester.getText().toString();

                listMahasiswa.add(new Mahasiswa(nama, asal, semester));
                tampilkanData();
            }
        });
        alertTambah.setNegativeButton("Batal", null);
        alertTambah.show();
    }
}
