package com.example.thebestone.intent;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class KelasKedua extends AppCompatActivity {

    ListView listViewMahasiswa;
    ArrayAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kedua);

        pesanSelamatDatang();

        String[] arrayMahasiswa = new String[3];

        arrayMahasiswa[0] = "adnan";
        arrayMahasiswa[1] = "nabila";
        arrayMahasiswa[2] = "dika";

        adapter = new ArrayAdapter(KelasKedua.this, android.R.layout.simple_list_item_1, arrayMahasiswa);

        listViewMahasiswa = findViewById(R.id.listMahasiswa);
        listViewMahasiswa.setAdapter(adapter);



//        ArrayList<Mahasiswa> listMahasiswa = new ArrayList();
//
//        listMahasiswa.add(new Mahasiswa("akil","malang", "1"));
//        listMahasiswa.add(new Mahasiswa("nabila","surabaya", "4"));
    }

    public void pesanSelamatDatang() {
        String email;
        email = getIntent().getStringExtra(MainActivity.EMAIL_KEY);

        Toast.makeText(this, "Selamat datang, " + email, Toast.LENGTH_SHORT).show();
    }
}
