package com.example.thebestone.intent;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;
import java.util.zip.Inflater;

public class ListViewAdapter extends ArrayAdapter<Mahasiswa> {

    Activity context;
    List<Mahasiswa> listMahasiswa;

    int[] imgResource = {R.drawable.man_1, R.drawable.girl_1, R.drawable.man_2};

    public ListViewAdapter(Activity context, List<Mahasiswa> listMahasiswa) {
        super(context, R.layout.custom_row, listMahasiswa);

        this.context = context;
        this.listMahasiswa = listMahasiswa;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_row, null);

        TextView tvNama, tvAsal, tvSemester;
        ImageView imgMahasiswa;

        tvNama = v.findViewById(R.id.tvNamaMahasiswa);
        tvAsal = v.findViewById(R.id.tvAsal);
        tvSemester = v.findViewById(R.id.tvSemester);
        imgMahasiswa = v.findViewById(R.id.imgMahasiswa);

        imgMahasiswa.setImageResource(imgResource[position]);

        tvNama.setText(listMahasiswa.get(position).getNama());
        tvAsal.setText(listMahasiswa.get(position).getAsal());
        tvSemester.setText(listMahasiswa.get(position).getSemester());

        return v;
    }
}
