package com.example.thebestone.mydatabase.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.thebestone.mydatabase.R;
import com.example.thebestone.mydatabase.models.Mahasiswa;

import java.util.List;

public class ListViewAdapterQ extends ArrayAdapter<Mahasiswa> {

    Activity context;
    List<Mahasiswa> listMahasiswa;

    public ListViewAdapterQ(Activity context, List<Mahasiswa> listMahasiswa) {
        super(context, R.layout.custom_row, listMahasiswa);

        this.context = context;
        this.listMahasiswa = listMahasiswa;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = context.getLayoutInflater().inflate(R.layout.custom_row, parent, false);

        TextView tvName, tvJurusan, tvSemester;

        tvName = v.findViewById(R.id.tv_nama);
        tvJurusan = v.findViewById(R.id.tv_jurusan);
        tvSemester = v.findViewById(R.id.tv_semester);

        tvName.setText(listMahasiswa.get(position).getNama());
        tvJurusan.setText(listMahasiswa.get(position).getJurusan());
        tvSemester.setText(listMahasiswa.get(position).getSemester());

        return v;
    }
}
