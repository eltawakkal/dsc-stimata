package com.example.thebestone.mydatabase.sqlite;

import android.app.Activity;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class SqliteConfig extends SQLiteOpenHelper{

    private static String DB_NAME = "dsc";
    private static int DB_VERSION = 1;

    private static String TB_MAHASISWA =
            "CREATE TABLE tbMahasiswa (NAMA TEXT, JURUSAN TEXT, SEMESTER TEXT)";

    Activity context;

    public SqliteConfig (Activity context) {
        super(
                context,  //showing in this class
                DB_NAME, // db name
                null, // cursor we set null for now
                DB_VERSION // db version
        );
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            db.execSQL(TB_MAHASISWA);
        } catch (SQLiteException error) {
            Toast.makeText(context, "Error : " + error, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
