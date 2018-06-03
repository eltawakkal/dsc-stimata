package com.example.thebestone.mydatabase;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.example.thebestone.mydatabase.adapter.ListViewAdapterQ;
import com.example.thebestone.mydatabase.models.Mahasiswa;
import com.example.thebestone.mydatabase.sqlite.SqliteConfig;

import java.util.ArrayList;
import java.util.List;

public class AktifitasUtama extends AppCompatActivity {

    SqliteConfig dbConfig;
    SQLiteDatabase db;
    Cursor cursor;

    List<Mahasiswa> listMahasiswa;
    ListView mListViewMahasiswa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aktifitas_utama);

        dbConfig = new SqliteConfig(this);

        mListViewMahasiswa = findViewById(R.id.listview_mahasiswa);

        showAllData();
    }

    public void gotToAddData(View view) {
        Intent intent = new Intent(this, AddData.class);
        startActivity(intent);
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();

        showAllData();
    }

    public void showAllData() {
        db = dbConfig.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM tbMahasiswa", null);

        if (cursor.getCount() == 0) {
            Toast.makeText(this, "Tidak Ada Data", Toast.LENGTH_SHORT).show();
        } else {

            listMahasiswa = new ArrayList<>();

            for (int i = 0; i < cursor.getCount(); i ++) {
                cursor.moveToPosition(i);
                listMahasiswa.add(new Mahasiswa(
                        cursor.getString(0),
                        cursor.getString(1),
                        cursor.getString(2)));
            }

            ListViewAdapterQ adapterQ = new ListViewAdapterQ(this, listMahasiswa);
            mListViewMahasiswa.setAdapter(adapterQ);

        }
    }

}
