package com.example.thebestone.mydatabase;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.thebestone.mydatabase.sqlite.SqliteConfig;

public class AddData extends AppCompatActivity {

    EditText editNama, editJurusan, editSemester;
    Button btSimpan, btCancel;

    SqliteConfig dbConfig;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_data);

        dbConfig = new SqliteConfig(this);

        editNama = findViewById(R.id.edit_nama);
        editJurusan = findViewById(R.id.edit_jurusan);
        editSemester = findViewById(R.id.edit_semester);
        btSimpan = findViewById(R.id.bt_simpan);
        btSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nama, jurusan, semester;

                nama = editNama.getText().toString();
                jurusan = editJurusan.getText().toString();
                semester = editSemester.getText().toString();

                if (nama.equals("") || jurusan.equals("") || semester.equals("")) {
                    Toast.makeText(AddData.this, "Semuad Kolom Harus Di Isi", Toast.LENGTH_SHORT).show();
                } else {
                    tambahMahasiswa(nama, jurusan, semester);
                }

            }
        });

    }

    public void tambahMahasiswa(String nama, String jurusan, String semester) {
        db = dbConfig.getWritableDatabase();
        db.execSQL("INSERT INTO tbMahasiswa VALUES ('" + nama +"', '"+ jurusan +"', '"+ semester +"')");
        finish();
    }

}
